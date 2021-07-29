package com.example.controller.response;

import com.example.entity.MensagemVoto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class PautaDto {

    private String id;

    private String nome;

    private Map<MensagemVoto, Long> resultado;
}
