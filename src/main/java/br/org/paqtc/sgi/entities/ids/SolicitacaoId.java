package br.org.paqtc.sgi.entities.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SolicitacaoId implements Serializable {
    @Column(name = "idSolicitacao")
    private Integer idSolicitacao;

    @Column(name = "teano_idano")
    private Integer idAno;

    @Column(name = "tsUsuario_idUsuario")
    private Long idUsuario;

    @Column(name = "tsProjeto_idProjeto")
    private Integer idProjeto;
}
