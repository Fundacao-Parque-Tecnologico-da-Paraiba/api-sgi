package br.org.paqtc.sgi.entities.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tuusuariotec")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTecnico implements Serializable {

    @Id
    @Column(name = "idUsuarioTec")
    private Long id;

    @Column(name = "DtCadastro")
    private LocalDate dtCadastro;

    @Column(name = "GrauFormacao")
    private String grauFormacao;

    @Column(name = "NmUsuarioTec")
    private String nome;

    @Column(name = "Ncpf")
    private String cpf;

    @Column(name = "DsEmail")
    private String email;

    @Column(name = "DsSenha")
    private String senha;

    @Column(name = "Ntelefone")
    private String telefone;

    @Column(name = "NmBanco")
    private String banco;

    @Column(name = "NAgencia")
    private String agencia;

    @Column(name = "NContaCorrente")
    private String contaCorrente;

    @Column(name = "tipoconta")
    private String tipoConta;

    @Column(name = "chavepix")
    private String chavePix;

}
