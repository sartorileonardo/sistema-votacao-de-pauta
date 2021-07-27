package com.example;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "voto")
public class Voto implements Serializable {
    @Id
    private Integer cpf;

    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    public Voto(Integer cpf, MensagemVoto mensagemVoto) {
        this.cpf = cpf;
        this.mensagemVoto = mensagemVoto;
    }

    public Voto() {
    }
}
