package br.org.paqtc.sgi.entities.dbconf.projetos;

import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.dbconf.enums.SituacaoProjeto;
import br.org.paqtc.sgi.entities.dbconf.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tsprojetos")
@AllArgsConstructor
@NoArgsConstructor
public class Projeto implements Serializable {

    @Id()
    @Column(name = "idProjeto")
    private Long idProjeto;

    @Column(name = "tsUsuario_idUsuario")
    private Long idUsuario;

    @Column(name = "idUsuario_idCoord")
    private Long idCoord;

    @Column(name = "idUsuario_idCoordMonitor")
    private Long idCoordMonitor;

    @Column(name = "NmProjeto")
    private String nome;

    @Column(name = "NmMonitor")
    private String monitor;

    @Column(name = "NmMonitor1")
    private String monitor1;

    @Column(name = "NmMonitor2")
    private String monitor2;

    @Column(name = "NomeBanco")
    private String banco;

    @Column(name = "NAgencia")
    private String agencia;

    @Column(name = "ContaEmpresa_01")
    private String contaEmpresa01;

    @Column(name = "ContaEmpresa_02")
    private String contaEmpresa02;

    @Column(name = "ContaEmbrapii")
    private String contaEmbrapii;

    @Column(name = "ContaSebraeEmbrapii")
    private String contaSebraeEmbrapii;

    @Column(name = "ContaEmpresa_01_pix")
    private String contaEmpresa01Pix;

    @Column(name = "ContaEmpresa_02_pix")
    private String contaEmpresa02Pix;

    @Column(name = "ContaEmbrapii_pix")
    private String contaEmbrapiiPix;

    @Column(name = "ContaSebraeEmbrapii_pix")
    private String contaSebraeEmbrapiiPix;

    @Column(name = "LinkBoletos")
    private String linkBoletos;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "TemRH")
    private String temRh;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tsUsuario_idUsuario", insertable = false, updatable = false)
    private Usuario coordenador;

    @MapsId("idCoord")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario_idCoord", insertable = false, updatable = false)
    private Usuario gerente;

    @MapsId("idCoordMonitor")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario_idCoordMonitor", insertable = false, updatable = false)
    private Usuario coordMonitor;

    public ProjetoDto toDto() {
        return ProjetoDto.builder()
                .nomeProjeto(nome)
                .nomeCoordenador(coordenador.getNome())
                .nomeGerente(gerente.getNome())
                .id(idProjeto)
                .situacaoProjeto(SituacaoProjeto.getByDescricao(situacao))
                .build();
    }
}
