package br.com.fbm.ceps.fbmceps.services.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public ProcessoVOV2 salvar(ProcessoVOV2 pProcessoVOV2){
        ProcessoModel processo = converterVO.convertVoToEntity(pProcessoVOV2);
        return converterVO.convertEntityToVo(repository.save(processo));
    }

}
