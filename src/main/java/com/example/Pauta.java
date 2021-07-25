package com.example;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
