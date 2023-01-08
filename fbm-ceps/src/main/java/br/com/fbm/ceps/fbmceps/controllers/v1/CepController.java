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

import br.com.fbm.ceps.fbmceps.data.vo.v1.CepVO;
import br.com.fbm.ceps.fbmceps.services.v1.CepService;

@RestController
@RequestMapping(value = "/cep/v1")
public class CepController {
    
    @Autowired
    CepService service;

    @GetMapping(
        value = "/ceps", 
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<CepVO> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CepVO buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public CepVO salvar(@RequestBody CepVO pCepVO){
        return service.salvar(pCepVO);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CepVO atualizar(@RequestBody CepVO pCepVO){
        return service.atualizar(pCepVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }

}
