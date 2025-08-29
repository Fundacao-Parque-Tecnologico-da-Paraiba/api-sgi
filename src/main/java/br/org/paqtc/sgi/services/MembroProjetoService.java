package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.MembroProjetoDto;
import br.org.paqtc.sgi.entities.projetos.MembroProjeto;
import br.org.paqtc.sgi.entities.projetos.Projeto;
import br.org.paqtc.sgi.repositories.MembroProjetoRepository;
import br.org.paqtc.sgi.repositories.ProjetosRepository;
import br.org.paqtc.sgi.repositories.specifications.ProjetoSpecification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MembroProjetoService {
    private final MembroProjetoRepository membroProjetoRepository;
    private final ProjetosRepository  projetosRepository;

    public MembroProjetoService(MembroProjetoRepository membroProjetoRepository, ProjetosRepository projetosRepository) {
        this.membroProjetoRepository = membroProjetoRepository;
        this.projetosRepository = projetosRepository;
    }

    public List<MembroProjetoDto> getMembrosDoProjeto(String nomeProjeto, Long idProjeto) {
        if (nomeProjeto == null && idProjeto == null) {
            return membroProjetoRepository.findAll().stream().map(MembroProjeto::toDto).toList();
        }
        if (idProjeto != null) {
            List<MembroProjeto> membroProjetos = buscarMembrosDoProjeto(Collections.singletonList(idProjeto));
            return membroProjetos.stream()
                    .map(
                            projeto -> {
                                MembroProjetoDto membroProjetoDto = projeto.toDto();
                                membroProjetoDto.setIdProjeto(projeto.getId().getIdProjeto());
                                return membroProjetoDto;
                            }
                    )
                    .toList();
        }
        List<Projeto> projetos = projetosRepository.findAll(
                ProjetoSpecification.nomeProjetoContains(nomeProjeto)
        );
        Map<Long, Projeto> ids = projetos.stream()
                .collect(Collectors.toMap(
                        projeto -> projeto.getId().getIdProjeto(),
                        projeto -> projeto
                ));
        List<MembroProjeto> membroProjetos = buscarMembrosDoProjeto(ids.keySet().stream().toList());
        return membroProjetos.stream()
                .map(
                        membroProjeto -> {
                            MembroProjetoDto membroProjetoDto = membroProjeto.toDto();
                            Projeto projeto = ids.get(membroProjeto.getId().getIdProjeto());
                            membroProjetoDto.setNomeProjeto(projeto.getNome());
                            return membroProjetoDto;
                        }
                )
                .toList();
    }

    private List<MembroProjeto> buscarMembrosDoProjeto(List<Long> idsProjeto) {
        return membroProjetoRepository.findAllById_IdProjetoIn(idsProjeto);
    }
}
