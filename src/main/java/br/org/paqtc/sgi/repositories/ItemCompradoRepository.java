package br.org.paqtc.sgi.repositories;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.entities.compras.ItemComprado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCompradoRepository extends JpaRepository<ItemComprado, Long> {
    List<ItemComprado> findByNomeContainingIgnoreCaseAndIdSolicitacao(String nome, Long idSolicitacao);

    List<ItemComprado> findByNomeContainingIgnoreCase(String nome);

    List<ItemComprado> findByIdSolicitacao(Long numeroSolicitacao);
}
