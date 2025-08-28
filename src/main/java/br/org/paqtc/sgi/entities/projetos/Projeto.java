package br.org.paqtc.sgi.entities.projetos;

import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.enums.SituacaoProjeto;
import br.org.paqtc.sgi.entities.ids.ProjetoId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @EmbeddedId
    private ProjetoId id;

    @Column(name = "NmProjeto")
    private String nome;

    @Column(name = "NmCoordenador")
    private String coordenador;

    @Column(name = "NmGerente")
    private String gerente;

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

    public ProjetoDto toDto() {
        return ProjetoDto.builder()
                .nomeProjeto(nome)
                .nomeCoordenador(coordenador)
                .nomeGerente(gerente)
                .id(id.getIdProjeto())
                .situacaoProjeto(SituacaoProjeto.getByDescricao(situacao))
                .build();
    }
}
