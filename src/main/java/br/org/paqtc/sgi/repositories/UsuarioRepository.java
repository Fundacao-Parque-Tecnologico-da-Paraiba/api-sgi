package br.org.paqtc.sgi.repositories;

import br.org.paqtc.sgi.entities.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
