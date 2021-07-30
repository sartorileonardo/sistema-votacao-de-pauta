package com.votacao.repository;

import com.votacao.entity.SessaoVotacao;
import com.votacao.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, String> {
    Boolean existsBySessaoVotacaoAndCpfEleitor(SessaoVotacao sessaoVotacao, String cpfEleitor);
}
