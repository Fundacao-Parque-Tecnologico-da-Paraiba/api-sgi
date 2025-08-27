package br.org.paqtc.sgi.entities.compras;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.dto.SolicitacoesDto;
import br.org.paqtc.sgi.entities.solicitacoes.Solicitacoes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "tbitenscompra")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemComprado implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "idItemCompras_NuSolicitacao", referencedColumnName = "NuSolicitacao")
    private Solicitacoes solicitacao;

    public ItemCompradoDto toDto() {
        return ItemCompradoDto.builder()
                .id(id)
                .nome(nome)
                .valorUnitario(valorUnitario)
                .quantidade(quantidade)
                .medida(medida)
                .descricaoDetalhada(descricaoDetalhada)
                .valorTotal(valorTotal)
                .idSolicitacao(solicitacao != null ? solicitacao.toDto() : null)
                .build();
    }
}
