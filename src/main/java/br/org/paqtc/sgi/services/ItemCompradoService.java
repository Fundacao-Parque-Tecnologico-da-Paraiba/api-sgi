package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import br.org.paqtc.sgi.exceptions.ItemCompradoNaoExisteException;
import br.org.paqtc.sgi.repositories.ItemCompradoRepository;
import br.org.paqtc.sgi.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemCompradoService {
    private final ItemCompradoRepository itemCompradoRepository;

    @Autowired
    public ItemCompradoService(ItemCompradoRepository itemCompradoRepository, UsuarioRepository usuarioRepository) {
        this.itemCompradoRepository = itemCompradoRepository;
    }

    public List<ItemCompradoDto> getItemComprado(String nome, Long numeroSolicitacao) {
        List<ItemComprado> itens = buscarItens(nome, numeroSolicitacao);

        if (itens.isEmpty()) {
            throw new ItemCompradoNaoExisteException(mensagemErro(nome, numeroSolicitacao));
        }

        return itens.stream()
                .map(ItemComprado::toDto)
                .toList();
    }

    public ItemCompradoDto getItemCompradoById(Long id) {
        return itemCompradoRepository.findById(id)
                .map(ItemComprado::toDto)
                .orElseThrow(() -> new ItemCompradoNaoExisteException("O id " + id + " não foi encontrado!"));
    }

    private List<ItemComprado> buscarItens(String nome, Long numeroSolicitacao) {
        List<ItemComprado> itemComprados = null;
        if (nome != null && numeroSolicitacao != null) {
            itemComprados = itemCompradoRepository.findByNomeContainingIgnoreCaseAndAndSolicitacao_NumeroSolicitacao(nome, numeroSolicitacao);
        } else if (nome != null) {
            itemComprados = itemCompradoRepository.findByNomeContainingIgnoreCase(nome);
        } else if (numeroSolicitacao != null) {
            itemComprados = itemCompradoRepository.findBySolicitacao_NumeroSolicitacao(numeroSolicitacao);
        } else {
            itemComprados = itemCompradoRepository.findAll();
        }
        return itemComprados;
    }

    private String mensagemErro(String nome, Long numeroSolicitacao) {
        String mensagemErro = "Nenhum item encontrado!";
        if (nome != null && numeroSolicitacao != null) {
            mensagemErro = String.format("O item com nome %s e número de solicitação %d não foi encontrado!", nome, numeroSolicitacao);
        } else if (nome != null) {
            mensagemErro = String.format("O item com nome %s não foi encontrado!", nome);
        } else if (numeroSolicitacao != null) {
            mensagemErro = String.format("O item com número de solicitação %d não foi encontrado!", numeroSolicitacao);
        }
        return mensagemErro;
    }
}
