package com.example.controller.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class SessaoDto {

    @ApiModelProperty(example = "2019-01-08T22:34:22.337Z")
    private LocalDateTime dataFechamento;
}
