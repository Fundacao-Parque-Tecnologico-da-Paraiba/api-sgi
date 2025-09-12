package br.org.paqtc.sgi.entities.dbsgfpp.lancamentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tulancamento")
@AllArgsConstructor
@NoArgsConstructor
public class Lancamento implements Serializable {

    @Id
    @Column(name = "idLancamento")
    private Long idLancamento;

    @Column(name = "NanoLancamento", nullable = false)
    private Integer anoLancamento;

    @Column(name = "NmesLancamento", nullable = false)
    private Integer mesLancamento;

    @Column(name = "NdiaLancamento", nullable = false)
    private Integer diaLancamento;

    @Column(name = "NuLancamento")
    private String numeroLancamento;

    @Column(name = "NuAgencia", nullable = false)
    private String agencia;

    @Column(name = "NuConta", nullable = false)
    private String conta;

    @Column(name = "DtLancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(name = "DsPagOrigem")
    private String descricaoPagadorOrigem;

    @Column(name = "DsLancamento")
    private String descricaoLancamento;

    @Column(name = "NuValor", nullable = false)
    private BigDecimal valor;

    @Column(name = "NuDocumento")
    private String numeroDocumento;

    @Column(name = "NuValorDC")
    private String valorDC;

    @Column(name = "NuSolicitacao", nullable = false)
    private Integer numeroSolicitacao;

    @Column(name = "NuSolicitacoes", nullable = false)
    private String numerosSolicitacoes;

    @Column(name = "Rubrica", nullable = false)
    private String rubrica;

    @Column(name = "Item", nullable = false)
    private String item;

    @Column(name = "teano_idano", nullable = false)
    private Integer idAno;

    @Column(name = "tsUsuario_idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "teCategoria_idCategoria", nullable = false)
    private Integer idCategoria;
}
