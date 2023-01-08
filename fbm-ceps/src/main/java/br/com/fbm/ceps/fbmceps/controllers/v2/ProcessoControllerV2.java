package br.com.fbm.ceps.fbmceps.controllers.v2;

import java.util.List;

import javax.print.attribute.standard.Media;

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

import br.com.fbm.ceps.fbmceps.data.vo.v2.ProcessoVOV2;
import br.com.fbm.ceps.fbmceps.services.v2.ProcessoServiceV2;

@RestController
@RequestMapping(value = "/processo/v2")
public class ProcessoControllerV2 {
    
    @Autowired
    ProcessoServiceV2 service;

    @GetMapping(
        value = "/processos", 
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<ProcessoVOV2> listar(){
        return service.listar();
    }

    @GetMapping(
        value = "/{id}",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ProcessoVOV2 buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ProcessoVOV2 salvar(@RequestBody ProcessoVOV2 pProcessoVOV2){
        return service.salvar(pProcessoVOV2);
    }

    @PutMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ProcessoVOV2 atualizar(@RequestBody ProcessoVOV2 pProcessoVOV2){
        return service.atualizar(pProcessoVOV2);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }

}
