package com.votacao.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.votacao.entity.Voto;
import com.votacao.resource.request.VotoRequestDto;
import com.votacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
