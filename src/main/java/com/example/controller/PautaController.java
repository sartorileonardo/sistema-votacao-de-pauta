package com.example.controller;

import com.example.controller.request.PautaRequest;
import com.example.controller.request.SessaoRequest;
import com.example.controller.request.VotoRequest;
import com.example.controller.response.PautaResponse;
import com.example.entity.Pauta;
import com.example.entity.Voto;
import com.example.exception.RegraDeNegocioException;
import com.example.exception.TipoMensagemRegraDeNegocioException;
import com.example.service.PautaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/pauta")
@RequiredArgsConstructor
public class PautaController {

    private static final Logger logger = LoggerFactory.getLogger(PautaController.class);

    private final PautaService pautaService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<PautaResponse> criarPauta(@RequestBody PautaRequest pautaRequest) {
        logger.info("Chamada para criar pauta: {}.", pautaRequest);

        Pauta pauta = objectMapper.convertValue(pautaRequest, Pauta.class);

        pauta = pautaService.addPauta(pauta);

        logger.info("Pauta criada com sucesso.");

        return ResponseEntity.ok(objectMapper.convertValue(pauta, PautaResponse.class))
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public List<PautaResponse> getPautas() {
        logger.info("Retornando pautas.");
        return pautaService.getPautas().stream()
                .map(this::getPautaResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idPauta}")
    public PautaResponse getPauta(@PathVariable("idPauta")
                                          Integer idPauta) {
        logger.info("Buscando pauta id {}.", idPauta);

        return getPautaResponse(pautaService.getPauta(idPauta).orElseThrow(() -> new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.PAUTA_NAO_ENCONTRADA, HttpStatus.NOT_FOUND)));
    }

    private PautaResponse getPautaResponse(Pauta pauta) {
        PautaResponse pautaResponse = objectMapper.convertValue(pauta, PautaResponse.class);
        pautaResponse.setResultado(pautaService.result(pauta));

        return pautaResponse;
    }

    @PostMapping("/{idPauta}/iniciar-sessao-votacao")
    public ResponseEntity iniciarSessaoVotacao(@PathVariable("idPauta") Integer idPauta,
                                               @RequestBody SessaoRequest abrirSessaoRequest) {
        logger.info("Pauta {} abertura de sessão.", idPauta);

        pautaService.iniciarSessaoVotacao(idPauta, abrirSessaoRequest != null ? abrirSessaoRequest.getDataFechamento() : null);

        logger.info("Sessão de votação iniciada com sucesso.");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idPauta}/votar")
    public ResponseEntity votar(@PathVariable("idPauta") Integer idPauta,
                                @RequestBody VotoRequest votoRequest) {
        logger.info("Pauta {} adicionando voto {}.", idPauta, votoRequest);

        pautaService.votar(idPauta, objectMapper.convertValue(votoRequest, Voto.class));

        logger.info("Voto realizado com sucesso.");

        return ResponseEntity.ok().build();
    }
}
