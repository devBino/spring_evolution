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

    public void setRepository(ProcessoRepository pRepository){
        repository = pRepository;
    }

    public void setConverter(ProcessoConverterV2 pConverterV2){
        converterVO = pConverterV2;
    }
    
    public List<ProcessoVOV2> listar(){
        
        List<ProcessoVOV2> processos = new ArrayList<>();

        repository
            .findAll()
            .stream()
            .forEach(p -> {
                
                ProcessoVOV2 pVOV2 = converterVO.convertEntityToVo(p);
                addLinks(pVOV2);
                processos.add(pVOV2);

            });

        return processos;

    }

    public ProcessoVOV2 buscarPorId(long pId){

        ProcessoModel registro = repository.findById(pId)
            .orElse(new ProcessoModel());

        ProcessoVOV2 processo = converterVO.convertEntityToVo(registro);
        addLinks(processo);
        return processo;

    }

    public ProcessoVOV2 salvar(ProcessoVOV2 pProcessoVOV2){
        
        ProcessoModel processo = converterVO.convertVoToEntity(pProcessoVOV2);
        
        ProcessoVOV2 processoVOV2 = converterVO.convertEntityToVo(repository.save(processo));
        addLinks(processoVOV2);

        return processoVOV2;

    }

    public ProcessoVOV2 atualizar(ProcessoVOV2 pProcessoVOV2){

        ProcessoModel registro = repository.findById( pProcessoVOV2.getKey() )
            .orElse(new ProcessoModel());

        ProcessoVOV2 processo = new ProcessoVOV2();

        if( registro.getId() != null ){

            registro.setIdFaixa( pProcessoVOV2.getIdFaixa() );
            registro.setDescStatus( pProcessoVOV2.getDescStatus() );
            registro.setDtInicio( pProcessoVOV2.getDtInicio() );
            registro.setDtFim( pProcessoVOV2.getDtFim() );

            processo = converterVO.convertEntityToVo( 
                repository.save(registro) );

            addLinks(processo);

            return processo;

        }

        return processo;

    }

    public void deletar(long pId){

        ProcessoModel registro = repository.findById(pId)
            .orElse(null);

        if( registro != null ){
            repository.deleteById(registro.getId());
        }

    }

    private void addLinks(ProcessoVOV2 pProcessoVOV2){

        pProcessoVOV2.add( linkTo(methodOn(ProcessoControllerV2.class).listar()).withSelfRel() );
        pProcessoVOV2.add( linkTo(methodOn(ProcessoControllerV2.class).atualizar(pProcessoVOV2)).withSelfRel() );

        if( pProcessoVOV2.getKey() != null ){
            pProcessoVOV2.add( linkTo(methodOn(ProcessoControllerV2.class).buscarPorId(pProcessoVOV2.getKey())).withSelfRel() );
            pProcessoVOV2.add( linkTo(methodOn(ProcessoControllerV2.class).deletar(pProcessoVOV2.getKey())).withSelfRel() );
        }



    }

}
