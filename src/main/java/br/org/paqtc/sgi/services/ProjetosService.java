package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.enums.SituacaoProjeto;
import br.org.paqtc.sgi.entities.projetos.Projeto;
import br.org.paqtc.sgi.exceptions.ProjetoNaoExisteException;
import br.org.paqtc.sgi.repositories.ProjetosRepository;
import br.org.paqtc.sgi.repositories.specifications.ProjetoSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetosService {
    private final ProjetosRepository projetosRepository;

    public ProjetosService(ProjetosRepository projetosRepository) {
        this.projetosRepository = projetosRepository;
    }

    public List<ProjetoDto> getProjetos(
            String nomeProjeto,
            String nomeCoordenador,
            String nomeGerente,
            String nomeMonitor,
            SituacaoProjeto situacaoProjeto
    ) {
        List<Projeto> projetos = buscarProjetos(nomeProjeto, nomeCoordenador, nomeGerente, nomeMonitor, situacaoProjeto);
        if (projetos.isEmpty()) {
            throw new ProjetoNaoExisteException(
                    mensagemErro(nomeProjeto, nomeCoordenador, nomeGerente, nomeMonitor, situacaoProjeto)
            );
        }

        return projetos.stream().map(Projeto::toDto).toList();
    }

    private List<Projeto> buscarProjetos(
            String nomeProjeto, 
            String nomeCoordenador,
            String nomeGerente, 
            String nomeMonitor,
            SituacaoProjeto situacaoProjeto
    ) {
        return projetosRepository.findAll(
                Specification.allOf(
                        ProjetoSpecification.nomeProjetoContains(nomeProjeto),
                        ProjetoSpecification.coordenadorContains(nomeCoordenador),
                        ProjetoSpecification.gerenteContains(nomeGerente),
                        ProjetoSpecification.monitorContains(nomeMonitor),
                        ProjetoSpecification.situacaoEquals(situacaoProjeto)
                )
        );
    }

    private String mensagemErro(
            String nomeProjeto,
            String nomeCoordenador,
            String nomeGerente,
            String nomeMonitor,
            SituacaoProjeto situacaoProjeto
    ) {
        StringBuilder mensagem = new StringBuilder("Nenhum projeto encontrado com os filtros: ");

        List<String> filtros = new ArrayList<>();

        if (nomeProjeto != null) {
            filtros.add("nome do projeto = " + nomeProjeto);
        }
        if (nomeCoordenador != null) {
            filtros.add("coordenador = " + nomeCoordenador);
        }
        if (nomeGerente != null) {
            filtros.add("gerente = " + nomeGerente);
        }
        if (nomeMonitor != null) {
            filtros.add("monitor = " + nomeMonitor);
        }
        if (situacaoProjeto != null) {
            filtros.add("situação = " + situacaoProjeto.name());
        }

        if (filtros.isEmpty()) {
            return "Nenhum projeto encontrado!";
        }

        mensagem.append(String.join(", ", filtros));
        return mensagem.toString();
    }
}
