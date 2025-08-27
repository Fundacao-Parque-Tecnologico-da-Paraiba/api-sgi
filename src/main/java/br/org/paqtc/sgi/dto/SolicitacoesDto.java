package br.org.paqtc.sgi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacoesDto {

    @JsonProperty("data-solicitacao")
    private Date dataSolicitacao;

    @JsonProperty("numero-solicitacao")
    private Integer numeroSolicitacao;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("nome-projeto")
    private String nomeProjeto;

    @JsonProperty("nome-coordenador")
    private String nomeCoordenador;
}
