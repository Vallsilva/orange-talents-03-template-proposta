package br.com.zupacademy.valeria.propostas.propostas;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@Transactional
public class PropostaControllerTest {

    //Um teste considerando que o solicitante ja existe
    //Um teste pra ver o retorno

    @Autowired
    private MockMvc mockMvc; //Simular requisições http
    @Autowired
    private ObjectMapper objectMapper; //Ajudar a lidar com Json
    @Autowired
    private PropostaRepository propostaRepository;

    PropostaRequest propostaRequest = new PropostaRequest(TipoPessoa.PF, "09000201640", "vdsilvav12@gmail.com", "Valéria da Silva", "Rua tal, nX", BigDecimal.valueOf(2500));


    @Test
    void deveSalvarUmaProposta() throws Exception {
        String json = geradorJson(propostaRequest);

        mockMvc.perform(post("/proposta").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(header().string(LOCATION, endsWith("/proposta/1")));

        assertTrue(propostaRepository.findByDocumento("09000201640").isPresent());

    }

    @Test
    void naoDeveSalvarUmaPropostaParaSolicitanteJaCadastrado() throws Exception{

        propostaRepository.save(propostaRequest.toModel());

        String json = geradorJson(propostaRequest);

        mockMvc.perform(post("/proposta").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());

        assertEquals(1, propostaRepository.count());

    }

    public String geradorJson(PropostaRequest request) throws Exception{
       return objectMapper.writeValueAsString(request);
    }
}
