package com.example;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "voto")
public class Voto implements Serializable {
    //@Id
    @Column(unique = true, nullable = false, insertable = true, updatable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    public Voto(String cpf, MensagemVoto mensagemVoto) {
        this.cpf = cpf;
        this.mensagemVoto = mensagemVoto;
    }

    public Voto() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public MensagemVoto getMensagemVoto() {
        return mensagemVoto;
    }

    public void setMensagemVoto(MensagemVoto mensagemVoto) {
        this.mensagemVoto = mensagemVoto;
    }
}
