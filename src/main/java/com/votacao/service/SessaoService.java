package com.votacao.service;

import com.votacao.entity.Pauta;
import com.votacao.entity.SessaoVotacao;
import com.votacao.exception.RegraDeNegocioException;
import com.votacao.exception.TipoMensagemRegraDeNegocioException;
import com.votacao.repository.PautaRepository;
import com.votacao.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessaoService {

    @Value("${tempo.sessao.votacao.segundos}")
    private Integer tempoSessaoPadrao;

    private final PautaRepository pautaRepository;
    private final SessaoRepository sessaoRepository;

    public Optional<Pauta> getPauta(Integer id) {
        return pautaRepository.findById(id);
    }

    @Transactional
    public void iniciarSessaoVotacao(Integer idPauta, LocalDateTime dataFechamento) {
        Pauta pauta = getPauta(idPauta).orElseThrow(() -> new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.PAUTA_NAO_ENCONTRADA, HttpStatus.NOT_FOUND));

        if(Objects.requireNonNull(getSessaoVotacao(pauta)).isPresent()){
            throw new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.SESSAO_JA_EXISTE, HttpStatus.CONFLICT);
        }

        criaSessaoVotacao(pauta, dataFechamento);
    }

    private void criaSessaoVotacao(Pauta pauta, LocalDateTime dataFechamento) {
        SessaoVotacao sessaoVotacao = SessaoVotacao.builder()
                .dataAbertura(LocalDateTime.now())
                .dataFechamento(dataFechamento(dataFechamento))
                .pauta(pauta)
                .build();

        sessaoRepository.save(sessaoVotacao);
    }

    private LocalDateTime dataFechamento(LocalDateTime dataFechamento) {
        return dataFechamento == null ? LocalDateTime.now().plusSeconds(tempoSessaoPadrao) : dataFechamento;
    }

    private Optional<SessaoVotacao> getSessaoVotacao(Pauta pauta) {
        return sessaoRepository.findByPauta(pauta);
    }

    public Integer getTempoSessaoPadrao() {
        return tempoSessaoPadrao;
    }
}
