package com.example.controller;

import com.example.entity.Pauta;
import com.example.entity.SessaoVotacao;
import com.example.entity.Voto;
import com.example.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pautas")
@RequiredArgsConstructor
public class PautaController {

    private static final Logger logger = LoggerFactory.getLogger(PautaController.class);

    private final PautaService pautaService;

    @PostMapping
    public ResponseEntity<Pauta> criarPauta(@RequestBody Pauta pautaRequest) {
        logger.info("Chamada para criar pauta: {}.", pautaRequest);

        Pauta pauta = pautaService.addPauta(pautaRequest);

        logger.info("Pauta criada com sucesso.");

        return ResponseEntity.ok(pauta)
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public List<Pauta> getPautas() {
        logger.info("Retornando pautas.");
        return pautaService.getPautas();
    }

    @GetMapping("/{idPauta}")
    public Optional<Pauta> getPauta(@PathVariable("idPauta")
                                          Integer idPauta) {
        logger.info("Buscando pauta id {}.", idPauta);

        return pautaService.getPauta(idPauta);
    }

    @PostMapping("/{idPauta}/iniciar-sessao-votacao")
    public ResponseEntity iniciarSessaoVotacao(@PathVariable("idPauta") Integer idPauta,
                                               @RequestBody SessaoVotacao abrirSessaoRequest) {
        logger.info("Pauta {} abertura de sessão.", idPauta);

        pautaService.iniciarSessaoVotacao(idPauta, abrirSessaoRequest != null ? abrirSessaoRequest.getDataFechamento() : null);

        logger.info("Sessão de votação iniciada com sucesso.");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idPauta}/votar")
    public ResponseEntity votar(@PathVariable("idPauta") Integer idPauta,
                                @RequestBody Voto votoRequest) {
        logger.info("Pauta {} adicionando voto {}.", idPauta, votoRequest);

        pautaService.votar(idPauta, votoRequest);

        logger.info("Voto realizado com sucesso.");

        return ResponseEntity.ok().build();
    }
}
