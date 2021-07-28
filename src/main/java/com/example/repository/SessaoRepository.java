package com.example.repository;

import com.example.entity.Pauta;
import com.example.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoVotacao, Integer> {
    Optional<SessaoVotacao> findByPauta(Pauta pauta);
}
