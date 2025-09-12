package br.org.paqtc.sgi.repositories.dbconf.specifications;

import br.org.paqtc.sgi.entities.dbconf.enums.SituacaoProjeto;
import br.org.paqtc.sgi.entities.dbconf.projetos.Projeto;
import org.springframework.data.jpa.domain.Specification;

public class ProjetoSpecification {

    public static Specification<Projeto> nomeProjetoContains(String nomeProjeto) {
        return (root, query, cb) ->
                nomeProjeto == null ? null : cb.like(cb.lower(root.get("nome")), "%" + nomeProjeto.toLowerCase() + "%");
    }

    public static Specification<Projeto> coordenadorContains(String nomeCoordenador) {
        return (root, query, cb) ->
                nomeCoordenador == null ? null : cb.like(cb.lower(root.get("coordenador").get("nome")), "%" + nomeCoordenador.toLowerCase() + "%");
    }

    public static Specification<Projeto> gerenteContains(String nomeGerente) {
        return (root, query, cb) ->
                nomeGerente == null ? null : cb.like(cb.lower(root.get("gerente").get("nome")), "%" + nomeGerente.toLowerCase() + "%");
    }

    public static Specification<Projeto> monitorContains(String nomeMonitor) {
        return (root, query, cb) -> {
            if (nomeMonitor == null) {
                return null;
            }
            String pattern = "%" + nomeMonitor.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("monitor")), pattern),
                    cb.like(cb.lower(root.get("monitor1")), pattern),
                    cb.like(cb.lower(root.get("monitor2")), pattern)
            );
        };
    }

    public static Specification<Projeto> situacaoEquals(SituacaoProjeto situacaoProjeto) {
        return (root, query, cb) ->
                situacaoProjeto == null ? null : cb.equal(root.get("situacao"), situacaoProjeto.name());
    }
}
