package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pauta")
public class Pauta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
}
