package br.org.paqtc.sgi.repositories.dbconf;

import br.org.paqtc.sgi.entities.dbconf.compras.ItemComprado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompradoRepository extends JpaRepository<ItemComprado, Long>, JpaSpecificationExecutor<ItemComprado> {
}
