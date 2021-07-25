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
}
