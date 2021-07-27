package com.example.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "pauta")
public class Pauta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(targetEntity = Voto.class)
    private List<Voto> votos;

    public Pauta() {
    }

    public Pauta(Integer id, String nome, List<Voto> votos) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
    }
}
