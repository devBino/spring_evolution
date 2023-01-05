package br.com.fbm.ceps.fbmceps.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import br.com.fbm.ceps.fbmceps.models.CepModel;
import br.com.fbm.ceps.fbmceps.services.CepService;

@RestController
@RequestMapping(value = "/cep")
public class CepController {
    
    @Autowired
    CepService service;

    @GetMapping(value = "/ceps", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CepModel> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CepModel buscarPorId(@PathVariable(value = "id") long id){
        return service.buscarPorId(id);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public CepModel salvar(@RequestBody CepModel pCep){
        return service.salvar(pCep);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CepModel atualizar(@RequestBody CepModel pCep){
        return service.atualizar(pCep);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
