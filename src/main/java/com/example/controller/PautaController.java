package com.example.controller;

import com.example.entity.Pauta;
import com.example.entity.SessaoVotacao;
import com.example.service.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/v1/pauta"})
public class PautaController {

    private static final Logger logger = LoggerFactory.getLogger(PautaController.class);

    @Autowired
    private PautaService pautaService;

    @Cacheable(value = "pautas")
    @GetMapping
    public List<Pauta> getAll() {
        logger.info("Consultando todas as pautas...");
        return pautaService.getPautas();
    }


    @GetMapping(path = {"/{idPauta}"})
    public ResponseEntity getById(@PathVariable Integer idPauta) {
        logger.info("Consultando pauta id {}.", idPauta);
        return pautaService.getPauta(idPauta)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @CacheEvict(value = "pautas", allEntries = true)
    @PostMapping
    public ResponseEntity<Pauta> create(@RequestBody Pauta pauta) {
        logger.info("Criando pauta...");
        Pauta p = pautaService.addPauta(pauta);
        logger.info("Pauta criada com sucesso.");
        return ResponseEntity.ok(p)
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/{idPauta}/iniciar-sessao-votacao")
    public ResponseEntity iniciarSessaoVotacao(@PathVariable("idPauta") Integer idPauta,
                                               @RequestBody SessaoVotacao sessaoVotacao) {
        logger.info("Pauta aberta.", idPauta);
        pautaService.iniciarSessaoVotacao(idPauta, sessaoVotacao.getDataFechamento());
        logger.info("A votação foi iniciada e termina em ".concat(pautaService.getTempoSessaoPadrao().toString()).concat(" segundos."));

        return ResponseEntity.ok().build();
    }

    @CacheEvict(value = "pautas", allEntries = true)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        logger.info("Removendo pauta...");
        pautaService.delete(id);
        logger.info("Pauta removida com sucesso.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    

}
