package br.org.paqtc.sgi.controllers.compras;

import br.org.paqtc.sgi.dto.ExceptionDto;
import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.repositories.ItemCompradoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

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
@DisplayName("Testes do controlador de itens comprados")
class ItemCompradoControllerTest {

    final String URI_ITENS_COMPRADOS = "/itens-comprados";

    @Autowired
    MockMvc driver;

    @Autowired
    ItemCompradoRepository itemCompradoRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Nested
    @DisplayName("Buscando todos os itens de compra")
    class GetAllItensCompras {

        @Test
        @DisplayName("Quando Busco todos os itens de compra com sucesso")
        void testBuscandoItensCompradosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ItemCompradoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(330, respostas.size());
        }
    }

    @Nested
    @DisplayName("Buscando todos os itens de compra por ID")
    class GetAllItensComprasById {

        @Test
        @DisplayName("Quando Busco todos os itens de compra por ID sucesso")
        void testBuscandoItensCompradosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS + "/315")
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ItemCompradoDto respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertEquals(315, respostas.getId());
            assertEquals("Notebook ga", respostas.getNome());
        }

        @Test
        @DisplayName("Quando Busco todos os itens de compra com ID não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS + "/100000000")
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("O id 100000000 não foi encontrado!", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os itens de compra que contem o mesmo nome")
    class GetAllItensComprasByName {

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo nome com sucesso")
        void testBuscandoItensCompradosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nome", "notebook")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ItemCompradoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(20, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nome", "blablabla")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum item comprado encontrado com os filtros: nome do item = blablabla", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os itens de compra que contem o mesmo nome e numero de solicitação")
    class GetAllItensComprasByNameAndSolicitacao {

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo nome com sucesso")
        void testBuscandoItensCompradosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nome", "notebook")
                            .param("numeroSolicitacao", "21389")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ItemCompradoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo nome não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("nome", "blablabla")
                            .param("numeroSolicitacao", "21389")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum item comprado encontrado com os filtros: nome do item = blablabla, número de solicitação = 21389", respostas.getMessage());
        }
    }

    @Nested
    @DisplayName("Buscando todos os itens de compra que contem o mesmo numero de solicitação")
    class GetAllItensComprasByNumeroSolicitacao {

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo numero de solicitação com sucesso")
        void testBuscandoItensCompradosComSucesso() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("numeroSolicitacao", "25054")
                    )
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            List<ItemCompradoDto> respostas = objectMapper.readValue(responseJsonString, new TypeReference<>() {});
            assertNotNull(respostas);
            assertFalse(respostas.isEmpty());
            assertEquals(1, respostas.size());
        }

        @Test
        @DisplayName("Quando Busco todos os itens de compra que contem o mesmo numero de solicitação não existente")
        void testBuscandoItensCompradosNaoExistente() throws Exception {
            String responseJsonString = driver.perform(get(URI_ITENS_COMPRADOS)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("numeroSolicitacao", "00001112")
                    )
                    .andExpect(status().isNotFound())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            ExceptionDto respostas = objectMapper.readValue(responseJsonString, ExceptionDto.class);
            assertNotNull(respostas);
            assertEquals("Nenhum item comprado encontrado com os filtros: número de solicitação = 1112", respostas.getMessage());
        }
    }
}