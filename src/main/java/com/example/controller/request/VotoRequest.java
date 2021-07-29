package com.example.controller.request;

import com.example.entity.MensagemVoto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class VotoRequest {

    //@NotNull(message = "informe o eleitor que irá votar.")
    private String cpfEleitor;

    //@NotNull(message = "informe a opção do voto, valores podem ser: SIM/NAO")
    private MensagemVoto opcaoVoto;
}
