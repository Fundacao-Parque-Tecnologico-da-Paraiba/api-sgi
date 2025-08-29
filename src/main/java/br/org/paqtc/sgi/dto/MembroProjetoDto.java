package br.org.paqtc.sgi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembroProjetoDto {

    @JsonProperty("id")
    private Long id;

    private String periodoTotal;

    private String periodoInicial;

    private String periodoFinal;

    private String situacao;

    private String valorBolsa;

    private String cargaHorario;

    private String nomeMembro;

    private String tipo;

    private Long idProjeto;

    private String nomeProjeto;
}
