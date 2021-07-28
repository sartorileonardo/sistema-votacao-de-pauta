package com.example.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "voto")
public class Voto {
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


    public Voto() {
    }

    public Voto(String cpfEleitor, MensagemVoto mensagemVoto, LocalDateTime dataHora, SessaoVotacao sessaoVotacao) {
        this.cpfEleitor = cpfEleitor;
        this.mensagemVoto = mensagemVoto;
        this.dataHora = dataHora;
        this.sessaoVotacao = sessaoVotacao;
    }
}
