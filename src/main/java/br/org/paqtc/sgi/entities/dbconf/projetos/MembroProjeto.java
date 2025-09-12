package br.org.paqtc.sgi.entities.dbconf.projetos;

import br.org.paqtc.sgi.dto.MembroProjetoDto;
import br.org.paqtc.sgi.entities.dbconf.ids.MembroProjetoId;
import br.org.paqtc.sgi.entities.dbconf.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tsequipetec")
@AllArgsConstructor
@NoArgsConstructor
public class MembroProjeto implements Serializable {

    @EmbeddedId
    private MembroProjetoId id;

    @Column(name = "Nano")
    private Integer ano;

    @Column(name = "Nmes")
    private Integer mes;

    @Column(name = "Ndia")
    private Integer dia;

    @Column(name = "DtCadastro")
    private LocalDate dataCadastro;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "NmMembro")
    private String nomeMembro;

    @Column(name = "Ncpf")
    private String cpf;

    @Column(name = "Nemail")
    private String email;

    @Column(name = "Ntelefone")
    private String telefone;

    @Column(name = "CargaHorario")
    private String cargaHorario;

    @Column(name = "ValorBolsa")
    private String valorBolsa;

    @Column(name = "tipoconta")
    private String tipoConta;

    @Column(name = "chavepix")
    private String chavePix;

    @Column(name = "NmBanco")
    private String banco;

    @Column(name = "NAgencia")
    private String agencia;

    @Column(name = "NContaCorrente")
    private String contaCorrente;

    @Column(name = "Situacao")
    private String situacao;

    @Column(name = "PeriodoTotal")
    private String periodoTotal;

    @Column(name = "PeriodoInicial")
    private String periodoInicial;

    @Column(name = "PeriodoFinal")
    private String periodoFinal;

    @MapsId("idCoord")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tsMembro_idCoord")
    private Usuario coordenador;

    @MapsId("idProjeto")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tsMembro_idProjeto")
    private Projeto projeto;

    public MembroProjetoDto toDto() {
        return MembroProjetoDto.builder()
                .id(this.getId().getIdMembro())
                .idProjeto(this.getId().getIdProjeto())
                .nomeProjeto(this.projeto.getNome())
                .cargaHorario(this.getCargaHorario())
                .periodoInicial(this.getPeriodoInicial())
                .periodoFinal(this.getPeriodoFinal())
                .periodoTotal(this.getPeriodoTotal())
                .tipo(this.getTipo())
                .nomeMembro(this.getNomeMembro())
                .situacao(this.getSituacao())
                .valorBolsa(this.getValorBolsa())
                .build();
    }
}
