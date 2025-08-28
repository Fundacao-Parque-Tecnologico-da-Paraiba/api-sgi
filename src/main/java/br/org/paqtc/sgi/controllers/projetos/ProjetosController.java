package br.org.paqtc.sgi.controllers.projetos;

import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.enums.SituacaoProjeto;
import br.org.paqtc.sgi.services.ProjetosService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@Validated
public class ProjetosController {

    private final ProjetosService projetosService;

    public ProjetosController(ProjetosService projetosService) {
        this.projetosService = projetosService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> getProjetos(
            @RequestParam(required = false) String nomeProjeto,
            @RequestParam(required = false) String nomeCoordenador,
            @RequestParam(required = false) String nomeGerente,
            @RequestParam(required = false) String nomeMonitor,
            @RequestParam(required = false) SituacaoProjeto situacaoProjeto
    ) {
        return ResponseEntity.ok(
                projetosService.getProjetos(
                    nomeProjeto,
                    nomeCoordenador,
                    nomeGerente,
                    nomeMonitor,
                    situacaoProjeto
                )
        );
    }
}
