package br.org.paqtc.sgi.repositories;

import br.org.paqtc.sgi.entities.ids.ProjetoId;
import br.org.paqtc.sgi.entities.projetos.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projeto, ProjetoId>, JpaSpecificationExecutor<Projeto> {
}
