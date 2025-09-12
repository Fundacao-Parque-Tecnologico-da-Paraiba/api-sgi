package br.org.paqtc.sgi.repositories.dbconf;

import br.org.paqtc.sgi.entities.dbconf.projetos.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projeto, Long>, JpaSpecificationExecutor<Projeto> {
}
