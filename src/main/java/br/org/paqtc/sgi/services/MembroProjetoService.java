package br.org.paqtc.sgi.services;

import br.org.paqtc.sgi.dto.MembroProjetoDto;
import br.org.paqtc.sgi.dto.MembrosPorProjetoDto;
import br.org.paqtc.sgi.entities.dbconf.projetos.MembroProjeto;
import br.org.paqtc.sgi.entities.dbconf.projetos.Projeto;
import br.org.paqtc.sgi.exceptions.ProjetoNaoExisteException;
import br.org.paqtc.sgi.repositories.dbconf.MembroProjetoRepository;
import br.org.paqtc.sgi.repositories.dbconf.ProjetosRepository;
import br.org.paqtc.sgi.repositories.dbconf.specifications.ProjetoSpecification;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembroProjetoService {
    private final MembroProjetoRepository membroProjetoRepository;
    private final ProjetosRepository  projetosRepository;

    public MembroProjetoService(MembroProjetoRepository membroProjetoRepository, ProjetosRepository projetosRepository) {
        this.membroProjetoRepository = membroProjetoRepository;
        this.projetosRepository = projetosRepository;
    }

    public List<MembrosPorProjetoDto> getMembrosDoProjeto(String nomeProjeto, Long idProjeto) {
        List<Projeto> projetos = new ArrayList<>();

        if (nomeProjeto == null && idProjeto == null) {
            projetos = projetosRepository.findAll();
        } else if (idProjeto != null) {
            projetos.add(projetosRepository.findById(idProjeto).orElseThrow(ProjetoNaoExisteException::new));
        } else {
            projetos = projetosRepository.findAll(
                    ProjetoSpecification.nomeProjetoContains(nomeProjeto)
            );
        }

        if (projetos.isEmpty()) {
            return Collections.emptyList();
        }

        List<Long> ids = projetos.stream()
                .map(Projeto::getIdProjeto).toList();

        List<MembroProjeto> membroProjetos = buscarMembrosDoProjeto(
                ids
        );

        Map<Long, List<MembroProjetoDto>> membrosAgrupados = membroProjetos.stream()
                .map(MembroProjeto::toDto).sorted()
                .collect(Collectors.groupingBy(MembroProjetoDto::getIdProjeto));

        return projetos.stream()
                .map(proj -> MembrosPorProjetoDto.builder()
                        .idProjeto(proj.getIdProjeto())
                        .nomeProjeto(proj.getNome())
                        .membroProjetoDtos(
                                membrosAgrupados.getOrDefault(proj.getIdProjeto(), Collections.emptyList())
                        )
                        .build()
                )
                .toList();
    }

    private List<MembroProjeto> buscarMembrosDoProjeto(List<Long> idsProjeto) {
        return membroProjetoRepository.findAllById_IdProjetoIn(idsProjeto);
    }
}
