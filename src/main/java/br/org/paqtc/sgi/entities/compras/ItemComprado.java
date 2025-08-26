package br.org.paqtc.sgi.entities.compras;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table(name = "tbitenscompra")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemComprado {
    @Id
    @Column(name = "iditemcompras")
    private Long id;

    @Column(name = "ItemCompras")
    private String nome;

    @Column(name = "ValorUnitario")
    private String valorUnitario;

    @Column(name = "Quantidade")
    private BigDecimal quantidade;

    @Column(name = "Medida")
    private String medida;

    @Column(name = "DescricaoDetalhada")
    private String descricaoDetalhada;

    @Column(name = "ValorTotal")
    private String valorTotal;

    @Column(name = "idItemCompras_NuSolicitacao")
    private Long idSolicitacao;

    public ItemCompradoDto getToDto() {
        return ItemCompradoDto.builder()
                .id(id)
                .nome(nome)
                .valorUnitario(valorUnitario)
                .quantidade(quantidade)
                .medida(medida)
                .descricaoDetalhada(descricaoDetalhada)
                .valorTotal(valorTotal)
                .idSolicitacao(idSolicitacao)
                .build();
    }
}
