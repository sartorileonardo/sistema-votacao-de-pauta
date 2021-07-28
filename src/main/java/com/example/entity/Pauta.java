package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "pautas")
public class Pauta {
    @ApiModelProperty(value = "Identificador unico da pauta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Nome da pauta")
    private String nome;

    @ApiModelProperty(value = "Lista de votos da pauta")
    @OneToMany(targetEntity = Voto.class)
    private List<Voto> votos;

}
