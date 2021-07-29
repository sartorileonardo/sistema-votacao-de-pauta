package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"pauta"})
@Table(name = "sessao_votacao")
public class SessaoVotacao implements Serializable {

    @ApiModelProperty(value = "Identificador unico da sessao, gerado automaticamente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Data/Hora de abertura da sessao")
    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    @ApiModelProperty(value = "Data/Hora de fechamento de votação", example = "2021-07-07T18:20:21.223Z")
    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @ApiModelProperty(value = "Pauta da sessao")
    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @ApiModelProperty(value = "Votos da sessao")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sessaoVotacao", cascade = CascadeType.ALL)
    private Collection<Voto> votos = new LinkedHashSet<Voto>();

}
