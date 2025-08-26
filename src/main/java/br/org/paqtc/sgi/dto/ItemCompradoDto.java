package br.org.paqtc.sgi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCompradoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome_produto")
    private String nome;

    @JsonProperty("valor_unitario")
    private String valorUnitario;

    @JsonProperty("quantidade")
    private BigDecimal quantidade;

    @JsonProperty("medida")
    private String medida;

    @JsonProperty("descricao_detalhada")
    private String descricaoDetalhada;

    @JsonProperty("valor_total")
    private String valorTotal;

    @JsonProperty("numero_de_solicitacao")
    private Long idSolicitacao;
}
