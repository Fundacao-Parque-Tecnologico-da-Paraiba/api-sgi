package br.org.paqtc.sgi.entities.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoId implements Serializable {

    @Column(name = "idProjeto")
    private Long idProjeto;

    @Column(name = "tsUsuario_idUsuario")
    private Long idUsuario;

    @Column(name = "idUsuario_idCoord")
    private Long idCoord;

    @Column(name = "idUsuario_idCoordMonitor")
    private Long idCoordMonitor;

}
