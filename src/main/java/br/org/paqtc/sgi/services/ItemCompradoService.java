package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.dbconf.compras.ItemComprado;
import br.org.paqtc.sgi.exceptions.ItemCompradoNaoExisteException;
import br.org.paqtc.sgi.repositories.dbconf.ItemCompradoRepository;
import br.org.paqtc.sgi.repositories.dbconf.specifications.ItemCompradoSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemCompradoService {
    private final ItemCompradoRepository itemCompradoRepository;

    @Autowired
    public ItemCompradoService(ItemCompradoRepository itemCompradoRepository) {
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
        return itemCompradoRepository.findAll(
                Specification.allOf(
                        ItemCompradoSpecification.nomeContains(nome),
                        ItemCompradoSpecification.numeroSolicitacaoEquals(numeroSolicitacao)
                )
        );
    }

    private String mensagemErro(String nome, Long numeroSolicitacao) {
        StringBuilder mensagem = new StringBuilder("Nenhum item comprado encontrado com os filtros: ");

        List<String> filtros = new ArrayList<>();

        if (nome != null) {
            filtros.add("nome do item = " + nome);
        }
        if (numeroSolicitacao != null) {
            filtros.add("número de solicitação = " + numeroSolicitacao);
        }

        mensagem.append(String.join(", ", filtros));
        return mensagem.toString();
    }
}
