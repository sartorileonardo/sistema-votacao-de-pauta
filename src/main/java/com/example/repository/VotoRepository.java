package com.example.repository;

import com.example.entity.SessaoVotacao;
import com.example.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, String> {
    Boolean existsBySessaoVotacaoAndCpfEleitor(SessaoVotacao sessaoVotacao, String cpfEleitor);
}
