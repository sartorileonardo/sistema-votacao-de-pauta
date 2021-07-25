package com.example;

import java.util.List;

public interface PautaService {
    Pauta inserir(Pauta pauta);
    Pauta alterar(Pauta pauta, Integer id);
    void excluir(Integer id);
    List<Pauta> getAll();
    Pauta get(Integer id);
    String votar(Integer idAssociado, Integer pauta);
    Long getVotos(Integer idPauta);
}
