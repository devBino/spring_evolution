package br.com.fbm.ceps.fbmceps.converter.custom;

import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.data.vo.v2.ProcessoVOV2;
import br.com.fbm.ceps.fbmceps.models.ProcessoModel;

@Service
public class ProcessoConverterV2 {
    
    public ProcessoVOV2 convertEntityToVo(ProcessoModel pProcessoModel){

        ProcessoVOV2 processoVO = new ProcessoVOV2();

        processoVO.setKey( pProcessoModel.getId() );
        processoVO.setIdFaixa( pProcessoModel.getIdFaixa() );
        processoVO.setDtInicio( pProcessoModel.getDtInicio() );
        processoVO.setDtFim( pProcessoModel.getDtFim() );
        processoVO.setDescStatus( pProcessoModel.getDescStatus() );
        //processoVO.setAtivo();

        return processoVO;

    }

    public ProcessoModel convertVoToEntity(ProcessoVOV2 pProcessoVO){

        ProcessoModel processoModel = new ProcessoModel();

        processoModel.setId( pProcessoVO.getKey() );
        processoModel.setIdFaixa( pProcessoVO.getIdFaixa() );
        processoModel.setDtInicio( pProcessoVO.getDtInicio() );
        processoModel.setDtFim( pProcessoVO.getDtFim() );
        processoModel.setDescStatus( pProcessoVO.getDescStatus() );

        return processoModel;

    }

}
