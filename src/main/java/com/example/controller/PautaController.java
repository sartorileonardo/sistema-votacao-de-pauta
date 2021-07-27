package com.example.controller;

import com.example.entity.Pauta;
import com.example.entity.Voto;
import com.example.repository.PautaRepository;
import com.example.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/pauta"})
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private VotoRepository votoRepository;

    @Cacheable(value = "pautas")
    @GetMapping
    public List<Pauta> getAll() {
        return pautaRepository.findAll();
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity getById(@PathVariable Integer id) {
        return pautaRepository.findById(id)
                .map(pauta -> ResponseEntity.ok().body(pauta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/{id}/votos"})
    public ResponseEntity getVotosByPauta(@PathVariable Integer id) {
        return pautaRepository.findById(id)
                .map(pauta -> ResponseEntity.ok().body(pauta.getVotos().stream().count()))
                .orElse(ResponseEntity.notFound().build());
    }


    @CacheEvict(value = "pautas", allEntries = true)
    @PostMapping
    public Pauta create(@RequestBody Pauta pauta) {
        pauta.getVotos().stream().forEach(v -> votoRepository.save(v));
        return pautaRepository.save(pauta);
    }

    @CacheEvict(value = "pautas", allEntries = true)
    @PostMapping(value = "/{id}/votar")
    public ResponseEntity votar(@PathVariable("id") Integer id, @RequestBody Voto voto) {

        Pauta pautaSalva= pautaRepository.findById(id).get();
        List<Voto> novaListaDeVotos = pautaSalva.getVotos();
        novaListaDeVotos.add(voto);
        Pauta novaPauta = new Pauta(pautaSalva.getId(), pautaSalva.getNome(), novaListaDeVotos);
        pautaRepository.save(novaPauta);

        return ResponseEntity.ok().body(novaPauta);
        /*
        return pautaRepository.findById(id)
                .map(p -> {
                    //p.setNome(pauta.getNome());
                    List<Voto> novaListaVotos = p.getVotos();
                    novaListaVotos.add(voto);

                    p.setNome(p.getNome());
                    p.setVotos(novaListaVotos);

                    Pauta pautaAtualizada = pautaRepository.save(p);

                    return ResponseEntity.ok().body(pautaAtualizada);
                }).orElse(ResponseEntity.notFound().build());

         */
    }

    @CacheEvict(value = "pautas", allEntries = true)
    @PutMapping(value = "/{id}")
    public ResponseEntity alterar(@PathVariable("id") Integer id,
                                 @RequestBody Pauta pauta) {
        return pautaRepository.findById(id)
                .map(p -> {
                    p.setNome(pauta.getNome());
                    p.setVotos(pauta.getVotos());
                    
                    Pauta pautaAtualizada = pautaRepository.save(p);

                    return ResponseEntity.ok().body(pautaAtualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @CacheEvict(value = "pautas", allEntries = true)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        pautaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    

}
