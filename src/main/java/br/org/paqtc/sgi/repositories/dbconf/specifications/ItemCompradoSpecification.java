package br.org.paqtc.sgi.repositories.dbconf.specifications;

import br.org.paqtc.sgi.entities.dbconf.compras.ItemComprado;
import org.springframework.data.jpa.domain.Specification;

public class ItemCompradoSpecification {
    public static Specification<ItemComprado> nomeContains(String nome) {
        return (root, query, cb) ->
                nome == null ? null : cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<ItemComprado> numeroSolicitacaoEquals(Long numeroSolicitacao) {
        return (root, query, cb) ->
                numeroSolicitacao == null ? null : cb.equal(root.get("solicitacao").get("numeroSolicitacao"), numeroSolicitacao);
    }
}
