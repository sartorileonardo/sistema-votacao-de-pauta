package com.votacao.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.votacao.resource.request.PautaRequestDto;
import com.votacao.resource.request.VotoRequestDto;
import com.votacao.resource.response.PautaResponseDto;
import com.votacao.entity.Pauta;
import com.votacao.entity.Voto;
import com.votacao.exception.RegraDeNegocioException;
import com.votacao.exception.TipoMensagemRegraDeNegocioException;
import com.votacao.service.PautaService;
import com.votacao.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
