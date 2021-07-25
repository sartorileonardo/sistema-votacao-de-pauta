package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pauta"})
public class PautaController {
    @GetMapping
    public String hello(){
        return "Hello";
    }
}
