package br.org.paqtc.sgi.controllers.compras;

import br.org.paqtc.sgi.dto.ItemCompradoDto;
import br.org.paqtc.sgi.repositories.ItemCompradoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Nested
    @DisplayName("Buscando todos os itens de compra")
    class GetAllItensCompras {

        @Test
        @DisplayName("Quando Busco todos os itens de compra com sucesso")
        void testBuscandoItensCOmpradosComSucesso() throws Exception {
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
}