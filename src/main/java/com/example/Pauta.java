package com.example;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Pauta {
    private Integer id;
    private String nome;
    private List<Voto> votos;

    public Pauta() {
    }

    public Pauta(Integer id, String nome, List<Voto> votos) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
    }
}
