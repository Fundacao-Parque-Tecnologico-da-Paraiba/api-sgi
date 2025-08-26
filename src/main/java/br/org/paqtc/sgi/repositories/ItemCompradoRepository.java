package br.org.paqtc.sgi.repositories;

import br.org.paqtc.sgi.entities.compras.ItemComprado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompradoRepository extends JpaRepository<ItemComprado, Long> {
}
