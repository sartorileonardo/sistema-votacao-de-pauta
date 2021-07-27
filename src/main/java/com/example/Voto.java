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
    //@Id
    @Column(unique = true, nullable = false, insertable = true, updatable = false, length = 11)
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
