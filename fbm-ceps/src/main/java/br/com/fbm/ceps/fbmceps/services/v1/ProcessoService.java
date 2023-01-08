package br.com.fbm.ceps.fbmceps.services.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.converter.ConverterVO;
import br.com.fbm.ceps.fbmceps.converter.custom.ProcessoConverterV2;
import br.com.fbm.ceps.fbmceps.data.vo.v1.ProcessoVO;
import br.com.fbm.ceps.fbmceps.data.vo.v2.ProcessoVOV2;
import br.com.fbm.ceps.fbmceps.models.ProcessoModel;
import br.com.fbm.ceps.fbmceps.repository.ProcessoRepository;

@Service
public class ProcessoService {
    
    @Autowired
    ProcessoRepository repository;

    @Autowired
    ProcessoConverterV2 converterVO;

    public List<ProcessoVO> listar(){
        return ConverterVO.parseListObjects(repository.findAll(), ProcessoVO.class);
    }

    public ProcessoVO buscarPorId(long pId){

        ProcessoModel registro = repository.findById(pId)
            .orElse(new ProcessoModel());

        return ConverterVO.parseObject(registro, ProcessoVO.class);

    }

    public ProcessoVO salvar(ProcessoVO pProcessoVO){
        ProcessoModel processo = ConverterVO.parseObject(pProcessoVO, ProcessoModel.class);
        return ConverterVO.parseObject(repository.save(processo), ProcessoVO.class);
    }

    public ProcessoVO atualizar(ProcessoVO pProcessoVO){

        ProcessoModel registro = repository.findById(pProcessoVO.getId())
            .orElse(null);

        if( registro != null ){

            registro.setIdFaixa( pProcessoVO.getIdFaixa() );
            registro.setDtInicio( pProcessoVO.getDtInicio() );
            registro.setDtFim( pProcessoVO.getDtFim() );
            registro.setDescStatus( pProcessoVO.getDescStatus() );

            return ConverterVO.parseObject(repository.save(registro), ProcessoVO.class);

        }

        return new ProcessoVO();

    }

    public void deletar(long pId){

        ProcessoModel registro = repository.findById(pId)
            .orElse(null);

        if( registro != null ){
            repository.deleteById(pId);
        }

    }
    

}
