package br.com.fbm.agenda.fbmagenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fbm.agenda.fbmagenda.exception.NotFoundRegisterException;
import br.com.fbm.agenda.fbmagenda.models.ContatoModelDB;
import br.com.fbm.agenda.fbmagenda.services.ContatoService;

@RestController
@RequestMapping(value = "/contato-db")
public class ContatoControllerDB {

    @Autowired
    ContatoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModelDB registrar(@RequestBody ContatoModelDB pContato){

        return service.create(pContato);
        
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModelDB atualizar(@RequestBody ContatoModelDB pContato)
        throws NotFoundRegisterException {
        
        return service.update(pContato);

    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModelDB recuperPorId(@PathVariable(value = "id") long id)
        throws NotFoundRegisterException {

        return service.findById(id);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/contatos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContatoModelDB> listar(){
        return service.findAll();
    }
    
}
