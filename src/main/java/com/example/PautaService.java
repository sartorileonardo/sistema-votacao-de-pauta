package com.example;

import java.util.List;

public interface PautaService {
    String inserir(Pauta pauta);
    String alterar(Pauta pauta, Integer id);
    String excluir(Integer id);
    List<Pauta> getAll();
    Pauta get(Integer id);
    String votar(Integer idAssociado, Integer pauta);
    Integer getVotos(Integer pauta);
}
