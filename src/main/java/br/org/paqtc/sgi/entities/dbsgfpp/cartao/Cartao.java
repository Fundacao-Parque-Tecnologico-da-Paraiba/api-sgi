package br.org.paqtc.sgi.entities.dbsgfpp.cartao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tucartao")
@AllArgsConstructor
@NoArgsConstructor
public class Cartao implements Serializable {

    @Id
    @Column(name = "idMovimento")
    private Long idMovimento;

    @Column(name = "NanoMovimento", nullable = false)
    private Integer anoMovimento;

    @Column(name = "NmesMovimento", nullable = false)
    private Integer mesMovimento;

    @Column(name = "NdiaMovimento", nullable = false)
    private Integer diaMovimento;

    @Column(name = "NCartao", nullable = false)
    private String numeroCartao;

    @Column(name = "FgTipo")
    private String tipo;

    @Column(name = "FgSubtipo")
    private String subtipo;

    @Column(name = "DtMovimento", nullable = false)
    private LocalDate dataMovimento;

    @Column(name = "NtOperacao")
    private String numeroOperacao;

    @Column(name = "DsMovimento")
    private String descricao;

    @Column(name = "NuValor", nullable = false)
    private BigDecimal valor;

    @Column(name = "NuSolicitacao", nullable = false)
    private Integer numeroSolicitacao;

    @Column(name = "NuDocumento")
    private String numeroDocumento;

    @Column(name = "Favorecido")
    private String favorecido;

    @Column(name = "TipoProg", nullable = false)
    private String tipoProg;

    @Column(name = "nTipoProg", nullable = false)
    private String nTipoProg;

    @Column(name = "ValorProg", nullable = false)
    private BigDecimal valorProg;

    @Column(name = "ContaProg", nullable = false)
    private String contaProg;

    @Column(name = "NParcelas", nullable = false)
    private Integer numeroParcelas;

    @Column(name = "CoordProg", nullable = false)
    private String coordenadorProg;

    @Column(name = "ProjetoProg", nullable = false)
    private String projetoProg;

    @Column(name = "teano_idano", nullable = false)
    private Integer idAno;

    @Column(name = "tsUsuario_idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "teCategoria_idCategoria", nullable = false)
    private Integer idCategoria;
}
