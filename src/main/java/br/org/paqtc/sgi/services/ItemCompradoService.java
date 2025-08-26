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
            return itemCompradoRepository
                    .findByNomeContainingIgnoreCaseAndIdSolicitacao(nome, numeroSolicitacao)
                    .stream().map(ItemComprado::toDto).toList();
        } else if (nome != null) {
            return  itemCompradoRepository
                    .findByNomeContainingIgnoreCase(nome)
                    .stream().map(ItemComprado::toDto).toList();
        } else if (numeroSolicitacao != null) {
            return itemCompradoRepository
                    .findByIdSolicitacao(numeroSolicitacao)
                    .stream().map(ItemComprado::toDto).toList();
        }
        return itemCompradoRepository.findAll().stream().map(ItemComprado::toDto).toList();
    }

    public ItemCompradoDto getItemCompradoById(Long id) {
        return itemCompradoRepository.findById(id)
                .map(ItemComprado::toDto)
                .orElseThrow(() -> new ItemCompradoNaoExisteException("O id " + id + " não foi encontrado!"));
    }
}
