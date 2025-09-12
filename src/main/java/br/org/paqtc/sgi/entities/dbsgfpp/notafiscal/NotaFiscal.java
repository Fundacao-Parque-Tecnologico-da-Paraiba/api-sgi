package br.org.paqtc.sgi.entities.dbsgfpp.notafiscal;

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
@Table(name = "tunotafiscal")
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal implements Serializable {

    @Id
    @Column(name = "idNotaFiscal")
    private Long idNotaFiscal;

    @Column(name = "NanoNotaFiscal", nullable = false)
    private Integer anoNotaFiscal;

    @Column(name = "NmesNotaFiscal", nullable = false)
    private Integer mesNotaFiscal;

    @Column(name = "NdiaNotaFiscal", nullable = false)
    private Integer diaNotaFiscal;

    @Column(name = "TipoRecebimento", nullable = false)
    private String tipoRecebimento;

    @Column(name = "DtNotaFiscal", nullable = false)
    private LocalDate dataNotaFiscal;

    @Column(name = "Nnota")
    private String numeroNota;

    @Column(name = "NuSolicitacao", nullable = false)
    private Integer numeroSolicitacao;

    @Column(name = "Favorecido")
    private String favorecido;

    @Column(name = "NuValor", nullable = false)
    private BigDecimal valor;

    @Column(name = "ContaFaturada", nullable = false)
    private String contaFaturada;

    @Column(name = "DataDeposito", nullable = false)
    private LocalDate dataDeposito;

    @Column(name = "ContaDeposito", nullable = false)
    private String contaDeposito;

    @Column(name = "ContaTransfDeposito", nullable = false)
    private String contaTransfDeposito;

    @Column(name = "DataTransfDeposito", nullable = false)
    private LocalDate dataTransfDeposito;

    @Column(name = "DescricaoNF", nullable = false)
    private String descricaoNF;

    @Column(name = "tsUsuario_idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "teano_idano", nullable = false)
    private Integer idAno;
}
