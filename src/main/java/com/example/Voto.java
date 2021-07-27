package com.example;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "voto")
public class Voto {
    @Id
    private String cpf;

    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    public Voto(String cpf, MensagemVoto mensagemVoto) {
        this.cpf = cpf;
        this.mensagemVoto = mensagemVoto;
    }

    public Voto() {
    }
}
