package br.com.fbm.ceps.fbmceps.controllers.v1;

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

import br.com.fbm.ceps.fbmceps.data.vo.v1.ProcessoVO;

import br.com.fbm.ceps.fbmceps.services.v1.ProcessoService;

@RestController
@RequestMapping(value = "/processo/v1")
public class ProcessoController {
    
    @Autowired
    ProcessoService service;

    @GetMapping(
        value = "/processos", 
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<ProcessoVO> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProcessoVO buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProcessoVO salvar(@RequestBody ProcessoVO pProcessoVO){
        return service.salvar(pProcessoVO);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProcessoVO atualizar(@RequestBody ProcessoVO pProcessoVO){
        return service.atualizar(pProcessoVO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }

}
