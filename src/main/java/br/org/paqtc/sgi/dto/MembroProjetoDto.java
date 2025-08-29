package br.org.paqtc.sgi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembroProjetoDto implements Comparable<MembroProjetoDto>{

    @JsonProperty("id")
    private Long id;

    private String nomeMembro;

    private String tipo;

    private Long idProjeto;

    private String nomeProjeto;

    private String situacao;

    private String valorBolsa;

    private String periodoTotal;

    private String periodoInicial;

    private String periodoFinal;

    private String cargaHorario;

    @Override
    public int compareTo(MembroProjetoDto outro) {
        int comparacaoTipo = Comparator.nullsLast(String::compareToIgnoreCase)
                .compare(this.tipo, outro.tipo);
        if (comparacaoTipo != 0) {
            return comparacaoTipo;
        }
        return Comparator.nullsLast(String::compareToIgnoreCase)
                .compare(this.nomeMembro, outro.nomeMembro);
    }
}
