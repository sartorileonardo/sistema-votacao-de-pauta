package com.votacao.resource;

import com.votacao.resource.request.PautaRequestDto;
import com.votacao.resource.response.PautaResponseDto;
import com.votacao.entity.Pauta;
import com.votacao.exception.RegraDeNegocioException;
import com.votacao.exception.TipoMensagemRegraDeNegocioException;
import com.votacao.service.PautaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/pauta")
@RequiredArgsConstructor
public class PautaResource {

    private static final Logger logger = LoggerFactory.getLogger(PautaResource.class);

    private final PautaService pautaService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public List<PautaResponseDto> getPautas() {
        logger.info("Consultando pautas...");
        return pautaService.getPautas().stream()
                .map(this::getPautaResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idPauta}")
    public PautaResponseDto getPauta(@PathVariable("idPauta") Integer idPauta) {
        logger.info("Consultando pauta...");

        return getPautaResponse(pautaService.getPautaById(idPauta));
    }

    @PostMapping
    public ResponseEntity<PautaResponseDto> criarPauta(@RequestBody @Valid PautaRequestDto pautaRequest) {
        logger.info("Criando pauta...");
        Pauta pauta = objectMapper.convertValue(pautaRequest, Pauta.class);
        pauta = pautaService.addPauta(pauta);
        logger.info("Pauta criada com sucesso!");

        return ResponseEntity.ok(objectMapper.convertValue(pauta, PautaResponseDto.class))
                .status(HttpStatus.CREATED)
                .build();
    }

    private PautaResponseDto getPautaResponse(Pauta pauta) {
        PautaResponseDto pautaResponse = objectMapper.convertValue(pauta, PautaResponseDto.class);
        pautaResponse.setResultado(pautaService.resultado(pauta));

        return pautaResponse;
    }
}
