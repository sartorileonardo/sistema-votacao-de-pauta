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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sessaoVotacao", cascade = CascadeType.ALL)
    private Collection<Voto> votos = new LinkedHashSet<Voto>();

}
