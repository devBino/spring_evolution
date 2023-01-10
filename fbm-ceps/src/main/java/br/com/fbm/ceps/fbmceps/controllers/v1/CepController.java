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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/cep/v1")
@Tag(name = "Cep", description = "Cadastro de Ceps")
public class CepController {
    
    @Autowired
    CepService service;

    @GetMapping(
        value = "/ceps", 
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(summary = "Busca todos os ceps", description = "Busca todos os ceps")
    public List<CepVO> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca um cep pelo id", description = "Busca um cep pelo id")
    public CepVO buscarPorId(@PathVariable(value = "id") long pId){
        return service.buscarPorId(pId);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary  = "Cria um novo Cep", description = "Cria um novo Cep")
    public CepVO salvar(@RequestBody CepVO pCepVO){
        return service.salvar(pCepVO);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary  = "Atualiza um Cep existente", description = "Atualiza um Cep existente")
    public CepVO atualizar(@RequestBody CepVO pCepVO){
        return service.atualizar(pCepVO);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um cep pelo id", description = "Deleta um cep pelo id")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") long pId){
        service.deletar(pId);
        return ResponseEntity.noContent().build();
    }

}
