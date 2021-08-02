package com.votacao.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.votacao.entity.Pauta;
import com.votacao.entity.Voto;
import com.votacao.exception.RegraDeNegocioException;
import com.votacao.exception.TipoMensagemRegraDeNegocioException;
import com.votacao.resource.request.PautaRequestDto;
import com.votacao.resource.request.VotoRequestDto;
import com.votacao.resource.response.PautaResponseDto;
import com.votacao.service.PautaService;
import com.votacao.service.VotoService;
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
@RequestMapping("/v1/voto")
@RequiredArgsConstructor
public class VotoResource {

    private static final Logger logger = LoggerFactory.getLogger(VotoResource.class);

    private final VotoService votoService;
    private final ObjectMapper objectMapper;

    @PostMapping("/{idPauta}/votar")
    public ResponseEntity votar(@PathVariable("idPauta") Integer idPauta, @RequestBody @Valid VotoRequestDto voto) {
        votoService.votar(idPauta, objectMapper.convertValue(voto, Voto.class));
        logger.info("Voto registrado com sucesso!");

        return ResponseEntity.ok().build();
    }

}
