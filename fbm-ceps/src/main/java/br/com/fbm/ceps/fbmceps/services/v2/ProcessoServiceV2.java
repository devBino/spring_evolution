package br.com.fbm.ceps.fbmceps.services.v2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.controllers.v2.ProcessoControllerV2;
import br.com.fbm.ceps.fbmceps.converter.custom.ProcessoConverterV2;
import br.com.fbm.ceps.fbmceps.data.vo.v2.ProcessoVOV2;
import br.com.fbm.ceps.fbmceps.models.ProcessoModel;
import br.com.fbm.ceps.fbmceps.repository.ProcessoRepository;

@Service
public class ProcessoServiceV2 {

    @Autowired
    ProcessoRepository repository;

    @Autowired
    ProcessoConverterV2 converterVO;
    
    public List<ProcessoVOV2> listar(){
        
        List<ProcessoVOV2> processos = new ArrayList<>();

        repository
            .findAll()
            .stream()
            .forEach(p -> processos.add( converterVO.convertEntityToVo(p) ));

        return processos;

    }

    public ProcessoVOV2 buscarPorId(long pId){

        ProcessoModel registro = repository.findById(pId)
            .orElse(new ProcessoModel());

        ProcessoVOV2 processo = converterVO.convertEntityToVo(registro);

        processo.add(
            linkTo(methodOn(ProcessoControllerV2.class).buscarPorId(pId)).withSelfRel(),
            linkTo(methodOn(ProcessoControllerV2.class).listar()).withSelfRel()
            );

        return processo;

    }

    public ProcessoVOV2 salvar(ProcessoVOV2 pProcessoVOV2){
        ProcessoModel processo = converterVO.convertVoToEntity(pProcessoVOV2);
        return converterVO.convertEntityToVo(repository.save(processo));
    }

}
