package com.example.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PautaDto {
    //@NotBlank(message = "Descrição não pode ser vázio.")
    private String nome;
}
