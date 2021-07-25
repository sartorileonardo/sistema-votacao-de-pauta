package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PautaServiceImpl implements PautaService{

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public Pauta inserir(Pauta pauta) {
        //return "Pauta inserida com sucesso";
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta alterar(Pauta pauta, Integer id) {
        Pauta pautaSalva = pautaRepository.getOne(id);
        Pauta pessoaAlterada = Pauta.builder()
                .nome(pauta.getNome())
                .votos(pauta.getVotos())
                .build();
        return pautaRepository.save(pessoaAlterada);
    }

    @Override
    public void excluir(Integer id) {
        pautaRepository.deleteById(id);
    }

    @Override
    public List<Pauta> getAll() {

        /*
        Pauta p1 = Pauta.builder()
                .id(1)
                .nome("Cafe com leite")
                .votos(Arrays.asList(Voto.SIM, Voto.SIM, Voto.NAO))
                .build();

        Pauta p2 = Pauta.builder()
                .id(1)
                .nome("Cafe gourmet")
                .votos(Arrays.asList(Voto.SIM, Voto.NAO, Voto.NAO))
                .build();

        List<Pauta> pautas = Arrays.asList(p1, p2);

        return pautas;

         */
        return pautaRepository.findAll();
    }

    @Override
    public Pauta get(Integer id) {
/*
        Pauta pauta = Pauta.builder()
                .id(1)
                .nome("Trabalhar no feriado de natal")
                .votos(Arrays.asList(Voto.NAO, Voto.NAO, Voto.NAO))
                .build();

        return pauta;

 */
        return pautaRepository.findById(id).get();
    }

    @Override
    public String votar(Integer idAssociado, Integer pauta) {
        return "Voto Registrado com sucesso";
    }

    @Override
    public Long getVotos(Integer idPauta) {
        Pauta p = pautaRepository.findById(idPauta).get();
        return p.getVotos().stream().count();
    }
}
