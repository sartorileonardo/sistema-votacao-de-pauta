package com.votacao.test;

import static org.mockito.Mockito.when;

import com.votacao.controller.PautaController;
import com.votacao.service.PautaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
public class PautaControllerIntegrationTest {
    private MockMvc mockMvc;

    @Mock
    private PautaService service;

    @InjectMocks
    private PautaController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getPautas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/pauta/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addPauta() throws Exception {
        String json = "{\n" +
                "  \"nome\": \"pautaC\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/pauta/").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void iniciarVotacaoSessao() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("v1/pauta/1/iniciar-sessao-votacao").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void votarPauta() throws Exception {
        String json = "{\n" +
                "  \"cpfEleitor\": \"122155\"\n" +
                "  \"mensagemVoto\": \"SIM\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("v1/pauta/1/votar").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



    @Test
    public void getPauta() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/pauta/", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}