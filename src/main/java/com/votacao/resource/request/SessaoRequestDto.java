package com.votacao.resource.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@EqualsAndHashCode
public class SessaoRequestDto {

    @ApiModelProperty(value = "Data/Hora de fechamento de votação", example = "2021-07-07T18:20:21.223Z")
    private LocalDateTime dataFechamento;
}
