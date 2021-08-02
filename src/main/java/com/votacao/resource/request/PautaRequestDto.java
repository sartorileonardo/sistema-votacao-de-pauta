package com.votacao.resource.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
@ToString
public class PautaRequestDto {
    @ApiModelProperty(value = "Nome da pauta a ser votada")
    @NotBlank(message = "Nome é obrigatótio")
    private String nome;
}
