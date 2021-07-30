package com.example.controller.response;

import com.example.entity.MensagemVoto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class VotoResponseDto {
    private MensagemVoto mensagemVoto;
}
