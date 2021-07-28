package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@EqualsAndHashCode
@ToString(exclude = {"pauta"})
@Table(name = "sessao_votacao")
public class SessaoVotacao implements Serializable {

    @ApiModelProperty(value = "Identificador unico da sessao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Data/Hora de abertura da sessao")
    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    @ApiModelProperty(value = "Data/Hora de fechamento da sessao")
    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @ApiModelProperty(value = "Pauta da sessao")
    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    public SessaoVotacao() {
    }

    public SessaoVotacao(Integer id, LocalDateTime dataAbertura, LocalDateTime dataFechamento, Pauta pauta) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.pauta = pauta;
    }
}
