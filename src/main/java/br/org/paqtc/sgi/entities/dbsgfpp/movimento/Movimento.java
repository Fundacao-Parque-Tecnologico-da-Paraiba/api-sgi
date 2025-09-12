package br.org.paqtc.sgi.entities.dbsgfpp.movimento;

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
@Table(name = "tumovimento")
@AllArgsConstructor
@NoArgsConstructor
public class Movimento implements Serializable {

    @Id
    @Column(name = "idMovimento")
    private Long idMovimento;

    @Column(name = "NanoMovimento", nullable = false)
    private Integer anoMovimento;

    @Column(name = "NmesMovimento", nullable = false)
    private Integer mesMovimento;

    @Column(name = "NdiaMovimento", nullable = false)
    private Integer diaMovimento;

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

    @Column(name = "FoPagamento")
    private String formaPagamento;

    @Column(name = "FgStatus", nullable = false)
    private String status;

    @Column(name = "NuPagamento")
    private String numeroPagamento;

    @Column(name = "NuSolicitacao", nullable = false)
    private Integer numeroSolicitacao;

    @Column(name = "NuDocumento")
    private String numeroDocumento;

    @Column(name = "Favorecido")
    private String favorecido;

    @Column(name = "NuFavorecido")
    private String numeroFavorecido;

    @Column(name = "BancoFavorecido", nullable = false)
    private String bancoFavorecido;

    @Column(name = "AgFavorecido", nullable = false)
    private String agenciaFavorecido;

    @Column(name = "ContaFavorecido", nullable = false)
    private String contaFavorecido;

    @Column(name = "nProg", nullable = false)
    private Integer numeroProg;

    @Column(name = "TipoProg", nullable = false)
    private String tipoProg;

    @Column(name = "nTipoProg", nullable = false)
    private String nTipoProg;

    @Column(name = "DescricaoProg", nullable = false)
    private String descricaoProg;

    @Column(name = "ValorProg", nullable = false)
    private BigDecimal valorProg;

    @Column(name = "ContaProg", nullable = false)
    private String contaProg;

    @Column(name = "DataProg", nullable = false)
    private LocalDate dataProg;

    @Column(name = "CoordProg", nullable = false)
    private String coordenadorProg;

    @Column(name = "ProjetoProg", nullable = false)
    private String projetoProg;

    @Column(name = "Setor", nullable = false)
    private String setor;

    @Column(name = "AssDG", nullable = false)
    private String assDG;

    @Column(name = "AssDA", nullable = false)
    private String assDA;

    @Column(name = "PConf", nullable = false)
    private String pConf;

    @Column(name = "TED", nullable = false)
    private String ted;

    @Column(name = "ObservacaoDiretoria", nullable = false)
    private String observacaoDiretoria;

    @Column(name = "teano_idano", nullable = false)
    private Integer idAno;

    @Column(name = "tsUsuario_idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "teCategoria_idCategoria", nullable = false)
    private Integer idCategoria;
}
