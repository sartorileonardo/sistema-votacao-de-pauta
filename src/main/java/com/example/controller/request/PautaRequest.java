package com.example.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PautaRequest {

    //@NotNull(message = "Título deve ser informado.")
    //@NotBlank(message = "Título não pode ser vázio.")
    private String titulo;

    //@NotBlank(message = "Descrição não pode ser vázio.")
    private String nome;
}
