package br.org.paqtc.sgi.controllers.projetos;

import br.org.paqtc.sgi.dto.ExceptionDto;
import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.dto.ProjetoDto;
import br.org.paqtc.sgi.entities.enums.SituacaoProjeto;
import br.org.paqtc.sgi.repositories.ProjetosRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de projetos")
class ProjetosControllerTest {

    final String URI_PROJETOS = "/projetos";

    @Autowired
    MockMvc driver;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ProjetosRepository projetosRepository;

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Nested
    @DisplayName("Buscando todos os projetos")
    class GetAllProjetos {

        @Test
        @DisplayName("Quando Busco todos os projeto com sucesso")
        void testBuscandoProjetosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1024, respostas.size());
        }
    }

    @Nested
    @DisplayName("Buscando todos os projetos que contem o mesmo nome")
    class GetAllProjetosByName {

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeProjeto", "C - KUNUMI - PAQTCPB")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeProjeto", "blablabla")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum projeto encontrado com os filtros: nome do projeto = blablabla", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os projetos que contem o mesmo nome de coordenador")
    class GetAllProjetosByNomeCoordenador {

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeCoordenador", "José Nilton Silva")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(107, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeCoordenador", "blablabla")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum projeto encontrado com os filtros: coordenador = blablabla", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os projetos que contem o mesmo nome de gerente")
    class GetAllProjetosByNomeGerente {

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeGerente", "Esther Vilar Brasileiro")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(58, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeGerente", "blablabla")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum projeto encontrado com os filtros: gerente = blablabla", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os projetos que contem o mesmo nome de gerente")
    class GetAllProjetosByNomeMonitor {

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucessoMonitor1() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeMonitor", "Jorge Cesar Abrantes Figueiredo")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucessoMonitor2() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeMonitor", "Lívia Maria Rodrigues Sampaio Campos")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome com sucesso")
        void testBuscandoProjetosComSucessoMonitor3() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeMonitor", "Zayra Barboza Ferreira")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nomeMonitor", "blablabla")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum projeto encontrado com os filtros: monitor = blablabla", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os projetos por status")
    class GetAllProjetosByStatus {

        @Test
        @DisplayName("Quando Busco todos os projeto vigentes")
        void testBuscandoProjetosComSucessoVigente() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("situacaoProjeto", SituacaoProjeto.VIGENTE.toString())
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(546, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os projeto finalizados")
        void testBuscandoProjetosComSucessoFinalizados() throws Exception {
            String responseJsonString = driver.perform(get(URI_PROJETOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("situacaoProjeto", SituacaoProjeto.FINALIZADO.toString())
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ProjetoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(478, respostas.size());
        }
    }
}
