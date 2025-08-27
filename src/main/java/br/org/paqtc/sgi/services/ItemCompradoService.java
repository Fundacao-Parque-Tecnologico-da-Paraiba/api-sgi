package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import br.org.paqtc.sgi.exceptions.ItemCompradoNaoExisteException;
import br.org.paqtc.sgi.repositories.ItemCompradoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCompradoService {
    private final ItemCompradoRepository itemCompradoRepository;

    @Autowired
    public ItemCompradoService(ItemCompradoRepository itemCompradoRepository) {
        this.itemCompradoRepository = itemCompradoRepository;
    }

    @Transactional
    public List<ItemCompradoDto> getItemComprado(String nome, Long numeroSolicitacao) {
        if (nome != null && numeroSolicitacao != null) {
            List<ItemCompradoDto> itemCompradoDtos = itemCompradoRepository
                    .findByNomeContainingIgnoreCaseAndAndSolicitacao_NumeroSolicitacao(nome, numeroSolicitacao)
                    .stream().map(ItemComprado::toDto).toList();
            if (itemCompradoDtos.isEmpty()) {
                throw new ItemCompradoNaoExisteException(
                        "O item com nome " + nome + " e número de solicitação "
                                + numeroSolicitacao + " não foi encontrado!"
                );
            }
            return itemCompradoDtos;
        } else if (nome != null) {
            List<ItemCompradoDto> itemCompradoDtos = itemCompradoRepository
                    .findByNomeContainingIgnoreCase(nome)
                    .stream().map(ItemComprado::toDto).toList();
            if (itemCompradoDtos.isEmpty()) {
                throw new ItemCompradoNaoExisteException("O item com nome " + nome + " não foi encontrado!");
            }
            return itemCompradoDtos;
        } else if (numeroSolicitacao != null) {
            List<ItemCompradoDto> itemCompradoDtos = itemCompradoRepository
                    .findBySolicitacao_NumeroSolicitacao(numeroSolicitacao)
                    .stream().map(ItemComprado::toDto).toList();
            if (itemCompradoDtos.isEmpty()) {
                throw new ItemCompradoNaoExisteException("O item com número de solicitação "
                        + numeroSolicitacao + " não foi encontrado!");
            }
            return itemCompradoDtos;
        }
        return itemCompradoRepository.findAll().stream().map(ItemComprado::toDto).toList();
    }

    public ItemCompradoDto getItemCompradoById(Long id) {
        return itemCompradoRepository.findById(id)
                .map(ItemComprado::toDto)
                .orElseThrow(() -> new ItemCompradoNaoExisteException("O id " + id + " não foi encontrado!"));
    }
}
