package com.votacao.repository;

import com.votacao.entity.Pauta;
import com.votacao.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoVotacao, Integer> {
    Optional<SessaoVotacao> findByPauta(Pauta pauta);
}
