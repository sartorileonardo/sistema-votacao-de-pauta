package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@EqualsAndHashCode
@Table(name = "pautas")
public class Pauta implements Serializable{
    @ApiModelProperty(value = "Identificador unico da pauta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Nome da pauta")
    private String nome;

    @ApiModelProperty(value = "Lista de votos da pauta")
    @OneToMany(targetEntity = Voto.class)
    private List<Voto> votos;

    public Pauta(Integer id, String nome, List<Voto> votos) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
    }

    public Pauta() {
    }
}
