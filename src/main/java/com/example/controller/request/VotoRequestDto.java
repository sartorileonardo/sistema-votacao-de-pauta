package com.example.controller.request;

import com.example.entity.MensagemVoto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@ToString
public class VotoRequestDto {

    @ApiModelProperty(value = "CPF do eleitor", example = "38649231071")
    @NotNull(message = "CPF do eleitor obrigatório.")
    private String cpfEleitor;

    @ApiModelProperty(value = "Mensagem de voto do eleitor", example = "SIM")
    @NotNull(message = "Mensagem de voto é obrigatório e precisa seguir o padrão: SIM/NAO")
    private MensagemVoto mensagemVoto;
}
