package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.MembroProjetoDto;
import br.org.paqtc.sgi.dto.MembrosPorProjetoDto;
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

    public List<MembrosPorProjetoDto> getMembrosDoProjeto(String nomeProjeto, Long idProjeto) {
        List<Projeto> projetos;

        if (nomeProjeto == null && idProjeto == null) {
            projetos = projetosRepository.findAll();
        } else if (idProjeto != null) {
            projetos = projetosRepository.findAllById_IdProjeto(idProjeto);
        } else {
            projetos = projetosRepository.findAll(
                    ProjetoSpecification.nomeProjetoContains(nomeProjeto)
            );
        }

        if (projetos.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Long, Projeto> ids = projetos.stream()
                .collect(Collectors.toMap(
                        p -> p.getId().getIdProjeto(),
                        p -> p
                ));

        List<MembroProjeto> membroProjetos = buscarMembrosDoProjeto(
                new ArrayList<>(ids.keySet())
        );

        Map<Long, List<MembroProjetoDto>> membrosAgrupados = membroProjetos.stream()
                .map(membro -> {
                    MembroProjetoDto dto = membro.toDto();
                    Projeto projeto = ids.get(membro.getId().getIdProjeto());
                    if (projeto != null) {
                        dto.setNomeProjeto(projeto.getNome());
                    }
                    return dto;
                }).sorted()
                .collect(Collectors.groupingBy(MembroProjetoDto::getIdProjeto));

        return ids.values().stream()
                .map(projeto -> MembrosPorProjetoDto.builder()
                        .idProjeto(projeto.getId().getIdProjeto())
                        .nomeProjeto(projeto.getNome())
                        .membroProjetoDtos(
                                membrosAgrupados.getOrDefault(projeto.getId().getIdProjeto(), Collections.emptyList())
                        )
                        .build()
                )
                .toList();
    }

    private List<MembroProjeto> buscarMembrosDoProjeto(List<Long> idsProjeto) {
        return membroProjetoRepository.findAllById_IdProjetoIn(idsProjeto);
    }
}
