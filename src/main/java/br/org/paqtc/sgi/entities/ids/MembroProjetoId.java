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
public class MembroProjetoId implements Serializable {

    @Column(name = "idmembro")
    private Long idMembro;

    @Column(name = "tsMembro_idCoord")
    private Long idCoord;

    @Column(name = "tsMembro_idProjeto")
    private Long idProjeto;
}
