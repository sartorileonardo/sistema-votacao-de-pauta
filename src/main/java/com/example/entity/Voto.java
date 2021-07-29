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
    @ApiModelProperty(value = "CPF do eleitor", example = "38649231071")
    @NotNull(message = "CPF do eleitor obrigatório.")
    @Id
    private String cpfEleitor;

    @ApiModelProperty(value = "Mensagem de voto do eleitor", example = "SIM")
    @NotNull(message = "Mensagem de voto é obrigatório e precisa seguir o padrão: SIM/NAO")
    @Column(name = "mensagem_voto")
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @ApiModelProperty(value = "Data/Hora do voto")
    @Column(name = "data")
    private LocalDateTime dataHora;

    @ApiModelProperty(value = "Sessão do voto")
    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao")
    private SessaoVotacao sessaoVotacao;

}
