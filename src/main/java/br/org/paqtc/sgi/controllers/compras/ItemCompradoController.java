package br.org.paqtc.sgi.controllers.compras;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import br.org.paqtc.sgi.services.ItemCompradoService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-comprados")
@Validated
public class ItemCompradoController {

    private final ItemCompradoService itemCompradoService;

    @Autowired
    public ItemCompradoController(ItemCompradoService itemCompradoService) {
        this.itemCompradoService = itemCompradoService;
    }

    @GetMapping
    public ResponseEntity<List<ItemCompradoDto>> getAllItemComprado(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Long numeroSolicitacao
    ) {
        return ResponseEntity.ok(itemCompradoService.getItemComprado(
                nome,
                numeroSolicitacao
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCompradoDto> getItemCompradoById(@PathVariable Long id) {
        return ResponseEntity.ok(itemCompradoService.getItemCompradoById(id));
    }
}
