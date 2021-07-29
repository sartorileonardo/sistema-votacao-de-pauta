package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "sessaoVotacao")
@Entity
@Table(name = "voto")
public class Voto implements Serializable {
    @Id
    private String cpfEleitor;

    @Column(name = "mensagem_voto")
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @Column(name = "data")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao")
    private SessaoVotacao sessaoVotacao;

}
