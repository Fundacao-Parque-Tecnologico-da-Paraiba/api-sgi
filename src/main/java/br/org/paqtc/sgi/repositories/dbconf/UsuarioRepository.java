package br.org.paqtc.sgi.repositories.dbconf;

import br.org.paqtc.sgi.entities.dbconf.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
