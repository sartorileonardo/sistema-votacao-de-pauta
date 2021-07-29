package com.example.controller.response;

import com.example.entity.MensagemVoto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class PautaResponse {

    private String id;

    private String titulo;

    private String descricao;

    private Map<MensagemVoto, Long> resultado;
}
