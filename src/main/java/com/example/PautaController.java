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

    //@Autowired
    /*
    private PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

     */

    @GetMapping
    public List<Pauta> getAll() {
        //return pautaService.getAll();
        return pautaRepository.findAll();
    }
    

    @GetMapping(path = {"/{id}"})
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pautaRepository.getOne(id));
    }


    @PostMapping
    //TODO: alterar retorno para Pauta
    public Pauta create(@RequestBody Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity alterar(@PathVariable("id") Integer id,
                                 @RequestBody Pauta pauta) {
        Pauta pautaSalva = pautaRepository.getOne(id);
        pautaSalva.setNome(pauta.getNome());
        pautaSalva.setVotos(pauta.getVotos());
        return ResponseEntity.ok().body(pautaRepository.save(pautaSalva));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        pautaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    

}
