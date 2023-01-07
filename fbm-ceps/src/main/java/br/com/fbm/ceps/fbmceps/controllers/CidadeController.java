package br.com.fbm.ceps.fbmceps.controllers;

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

import br.com.fbm.ceps.fbmceps.data.vo.v1.CidadeVO;

import br.com.fbm.ceps.fbmceps.services.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {
    
    @Autowired
    CidadeService service;

    @GetMapping(value = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CidadeVO> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CidadeVO buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CidadeVO salvar(@RequestBody CidadeVO pCidadeVO){
        return service.salvar(pCidadeVO);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CidadeVO atualizar(@RequestBody CidadeVO pCidadeVO){
        return service.atualizar(pCidadeVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }

    
}
