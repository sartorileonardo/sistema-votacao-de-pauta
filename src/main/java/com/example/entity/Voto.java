package com.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "CPF do eleitor obrigatório.")
    @Id
    private String cpfEleitor;

    @NotNull(message = "Mensagem de voto é obrigatório e precisa seguir o padrão: SIM/NAO")
    @Column(name = "mensagem_voto")
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @Column(name = "data")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "sessaoVotacao")
    private SessaoVotacao sessaoVotacao;

}
