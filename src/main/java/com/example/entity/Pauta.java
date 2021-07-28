package com.example.entity;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(targetEntity = Voto.class)
    private List<Voto> votos;

}
