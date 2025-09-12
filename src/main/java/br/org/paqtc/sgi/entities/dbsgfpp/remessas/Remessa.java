package br.org.paqtc.sgi.entities.dbsgfpp.remessas;

import br.org.paqtc.sgi.entities.dbconf.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "turemessa")
@AllArgsConstructor
@NoArgsConstructor
public class Remessa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRemessa")
    private Long idRemessa;

    @Column(name = "NanoRemessa")
    private Integer anoRemessa;

    @Column(name = "NmesRemessa")
    private Integer mesRemessa;

    @Column(name = "NdiaRemessa")
    private Integer diaRemessa;

    @Column(name = "DtRemessa")
    private LocalDate dataRemessa;

    @Column(name = "DataProg")
    private LocalDate dataProgramada;

    @Column(name = "DsRemessa")
    private String descricao;

    @Column(name = "NuRemessa")
    private String numeroRemessa;

    @Column(name = "NuSolicitacao")
    private Integer numeroSolicitacao;

    @Column(name = "Projeto", nullable = false)
    private String projeto;

    @Column(name = "Coordenador", nullable = false)
    private String coordenadorNome;

    @Column(name = "ContaProjeto")
    private String contaProjeto;

    @Column(name = "NomeFav")
    private String nomeFavorecido;

    @Column(name = "CPFFav")
    private String cpfFavorecido;

    @Column(name = "BancoFav")
    private String bancoFavorecido;

    @Column(name = "AgFav")
    private String agenciaFavorecido;

    @Column(name = "ContFav")
    private String contaFavorecido;

    @Column(name = "TipPag")
    private String tipoPagamento;

    @Column(name = "FormLanc")
    private String formaLancamento;

    @Column(name = "ValorProg", nullable = false)
    private BigDecimal valorProgramado;

    @Column(name = "Situacao", nullable = false)
    private String situacao;

    @Column(name = "teano_idano", nullable = false)
    private Integer idAno;

    @Column(name = "tsUsuario_idUsuario", nullable = false)
    private Long idUsuario;
}
