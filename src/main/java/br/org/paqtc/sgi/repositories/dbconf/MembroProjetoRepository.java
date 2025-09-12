package br.org.paqtc.sgi.repositories.dbconf;

import br.org.paqtc.sgi.entities.dbconf.projetos.MembroProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembroProjetoRepository extends JpaRepository<MembroProjeto, Long>, JpaSpecificationExecutor<MembroProjeto> {
    List<MembroProjeto> findAllById_IdProjetoIn(List<Long> idsProjeto);
}
