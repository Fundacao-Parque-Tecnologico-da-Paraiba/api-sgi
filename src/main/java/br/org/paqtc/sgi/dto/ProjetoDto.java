package br.org.paqtc.sgi.dto;

import br.org.paqtc.sgi.entities.dbconf.enums.SituacaoProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDto {
    private Long id;
    private String nomeProjeto;
    private String nomeCoordenador;
    private String nomeGerente;
    private SituacaoProjeto situacaoProjeto;
}
