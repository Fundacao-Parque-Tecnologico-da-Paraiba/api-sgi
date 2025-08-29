package br.org.paqtc.sgi.controllers.projetos;

import br.org.paqtc.sgi.dto.MembroProjetoDto;
import br.org.paqtc.sgi.dto.MembrosPorProjetoDto;
import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.enums.SituacaoProjeto;
import br.org.paqtc.sgi.services.MembroProjetoService;
import br.org.paqtc.sgi.services.ProjetosService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@Validated
public class ProjetosController {

    private final ProjetosService projetosService;
    private final MembroProjetoService membroProjetoService;

    public ProjetosController(ProjetosService projetosService, MembroProjetoService membroProjetoService) {
        this.projetosService = projetosService;
        this.membroProjetoService = membroProjetoService;
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

    @GetMapping("/membros")
    public ResponseEntity<List<MembrosPorProjetoDto>> getMembros(
            @RequestParam(required = false) String nomeProjeto,
            @RequestParam(required = false) Long idProjeto
    ){
        return ResponseEntity.ok(membroProjetoService.getMembrosDoProjeto(nomeProjeto, idProjeto));
    }
}
