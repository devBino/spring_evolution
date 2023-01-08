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

import br.com.fbm.ceps.fbmceps.data.vo.v1.FaixaVO;
import br.com.fbm.ceps.fbmceps.services.v1.FaixaService;

@RestController
@RequestMapping(value = "/faixa/v1")
public class FaixaController {
    
    @Autowired
    FaixaService service;

    @GetMapping(
        value = "/faixas", 
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<FaixaVO> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FaixaVO buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FaixaVO salvar(@RequestBody FaixaVO pFaixaVO){
        return service.salvar(pFaixaVO);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FaixaVO alterar(@RequestBody FaixaVO pFaixaVO){
        return service.atualizar(pFaixaVO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }


}
