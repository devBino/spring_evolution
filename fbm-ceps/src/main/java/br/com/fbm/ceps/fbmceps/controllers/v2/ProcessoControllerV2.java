package br.com.fbm.ceps.fbmceps.controllers.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProcessoVOV2 salvar(@RequestBody ProcessoVOV2 pProcessoVOV2){
        return service.salvar(pProcessoVOV2);
    }

}
