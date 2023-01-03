package br.com.fbm.agenda.fbmagenda.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fbm.agenda.fbmagenda.models.PessoaModel;

@RestController
public class PessoaController {
    
    private final AtomicLong longTelefone = new AtomicLong(10);

    @GetMapping(value = "/pessoa")
    public PessoaModel getPessoal(){
        int i = 1;
        long l = 10;
        double d = 20;
        PessoaModel p =  new PessoaModel("Fernando", String.valueOf(longTelefone.incrementAndGet()), "fer@gmail.com");

        return p;
    }

}
