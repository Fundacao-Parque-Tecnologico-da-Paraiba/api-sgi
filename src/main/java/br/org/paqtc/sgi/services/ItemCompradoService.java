package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import br.org.paqtc.sgi.repositories.ItemCompradoRepository;
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
    public List<ItemCompradoDto> getItemComprado() {
        return itemCompradoRepository.findAll().stream().map(ItemComprado::getToDto).toList();
    }
}
