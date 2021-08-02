package com.votacao.service;

import com.votacao.entity.Pauta;
import com.votacao.entity.SessaoVotacao;
import com.votacao.entity.Voto;
import com.votacao.exception.RegraDeNegocioException;
import com.votacao.exception.TipoMensagemRegraDeNegocioException;
import com.votacao.repository.PautaRepository;
import com.votacao.repository.SessaoRepository;
import com.votacao.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final PautaRepository pautaRepository;
    private final SessaoRepository sessaoRepository;
    private final VotoRepository votoRepository;

    public Optional<Pauta> getPauta(Integer id) {
        return pautaRepository.findById(id);
    }

    private Optional<SessaoVotacao> getSessaoVotacao(Pauta pauta) {
        return sessaoRepository.findByPauta(pauta);
    }

    @Transactional
    public void votar(Integer idPauta, Voto voto) {
        SessaoVotacao sessaoVotacao = getSessaoVotacao(getPauta(idPauta)
                .orElseThrow(() -> new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.PAUTA_NAO_ENCONTRADA, HttpStatus.NOT_FOUND)))
                .orElseThrow(() -> new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.SESSAO_NAO_ENCONTRADA, HttpStatus.NOT_FOUND));

        if (LocalDateTime.now().isAfter(sessaoVotacao.getDataFechamento())) {
            throw new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.SESSAO_FECHADA, HttpStatus.BAD_REQUEST);
        }

        voto.setSessaoVotacao(sessaoVotacao);
        voto.setDataHora(LocalDateTime.now());

        if(votoRepository.existsBySessaoVotacaoAndCpfEleitor(sessaoVotacao, voto.getCpfEleitor())) {
            throw new RegraDeNegocioException(TipoMensagemRegraDeNegocioException.VOTO_JA_REGISTRADO, HttpStatus.BAD_REQUEST);
        }

        votoRepository.save(voto);
    }

}
