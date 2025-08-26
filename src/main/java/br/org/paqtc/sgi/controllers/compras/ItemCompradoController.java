package br.org.paqtc.sgi.controllers.compras;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import br.org.paqtc.sgi.services.ItemCompradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itens-comprados")
public class ItemCompradoController {

    private final ItemCompradoService itemCompradoService;

    @Autowired
    public ItemCompradoController(ItemCompradoService itemCompradoService) {
        this.itemCompradoService = itemCompradoService;
    }

    @GetMapping
    public ResponseEntity<List<ItemCompradoDto>> getAllItemComprado() {
        return ResponseEntity.ok(itemCompradoService.getItemComprado());
    }
}
