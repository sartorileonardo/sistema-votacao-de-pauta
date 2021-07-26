package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/pauta"})
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @GetMapping
    public List<Pauta> getAll() {
        //return pautaService.getAll();
        return pautaRepository.findAll();
    }
    

    @GetMapping(path = {"/{id}"})
    public ResponseEntity getById(@PathVariable Integer id) {
        return pautaRepository.findById(id)
                .map(pauta -> ResponseEntity.ok().body(pauta))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    //TODO: alterar retorno para Pauta
    public Pauta create(@RequestBody Pauta pauta) {
        return pautaRepository.save(pauta);
    }

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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        pautaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    

}
