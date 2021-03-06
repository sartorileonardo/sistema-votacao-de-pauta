package com.votacao.resource;

import com.votacao.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/sessao")
@RequiredArgsConstructor
public class SessaoResource {

    private static final Logger logger = LoggerFactory.getLogger(SessaoResource.class);
    private final SessaoService sessaoService;

    @PostMapping("/{idPauta}/iniciar-sessao-votacao")
    public ResponseEntity iniciarSessaoVotacao(@PathVariable("idPauta") Integer idPauta) {
        logger.info("Iniciando sessão de votação...", idPauta);
        sessaoService.iniciarSessaoVotacao(idPauta, LocalDateTime.now().plusSeconds(sessaoService.getTempoSessaoPadrao()));
        logger.info("Sessão de votação iniciada com sucesso, o tempo de votação encerra em " + sessaoService.getTempoSessaoPadrao() + " segundos.");

        return ResponseEntity.ok().build();
    }

}
