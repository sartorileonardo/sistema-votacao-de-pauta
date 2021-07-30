package com.votacao.controller.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class PautaResponseDto {

    private String id;

    private String nome;

    private Map<String, Long> resultado;
}
