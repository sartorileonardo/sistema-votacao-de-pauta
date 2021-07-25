package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PautaServiceImpl implements PautaService{

    @Override
    public String inserir(Pauta pauta) {
        return "Pauta inserida com sucesso";
    }

    @Override
    public String alterar(Pauta pauta, Integer id) {
        return "Pauta alterada com sucesso";
    }

    @Override
    public String excluir(Integer id) {
        return "Pauta removida com sucesso";
    }

    @Override
    public List<Pauta> getAll() {

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
    }

    @Override
    public Pauta get(Integer id) {

        Pauta pauta = Pauta.builder()
                .id(1)
                .nome("Trabalhar no feriado de natal")
                .votos(Arrays.asList(Voto.NAO, Voto.NAO, Voto.NAO))
                .build();

        return pauta;
    }

    @Override
    public String votar(Integer idAssociado, Integer pauta) {
        return "Voto Registrado com sucesso";
    }

    @Override
    public Integer getVotos(Integer pauta) {
        return new Date().getSeconds();
    }
}
