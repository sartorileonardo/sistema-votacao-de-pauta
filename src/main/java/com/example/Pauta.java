package com.example;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "pauta")
public class Pauta {
    private Integer id;
    private String nome;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Voto> votos;

    public Pauta() {
    }

    public Pauta(Integer id, String nome, List<Voto> votos) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
    }
}
