package br.org.paqtc.sgi.entities.dbconf.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbusuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @Column(name = "idUsuario")
    private Long id;

    @Column(name = "NmUsuario")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "Email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "setor")
    private String setor;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "Nivel")
    private String nivel;

    @Column(name = "user_ict")
    private String userIct;

    @Column(name = "user_lab")
    private String userLab;

    @Column(name = "user_ue")
    private String userUe;

    @Column(name = "subnivel")
    private String subnivel;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "token_expire")
    private LocalDateTime tokenExpire;
}
