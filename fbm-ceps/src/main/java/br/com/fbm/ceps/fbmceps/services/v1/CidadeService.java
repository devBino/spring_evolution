package br.com.fbm.ceps.fbmceps.services.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.converter.ConverterVO;
import br.com.fbm.ceps.fbmceps.data.vo.v1.CidadeVO;
import br.com.fbm.ceps.fbmceps.models.CidadeModel;
import br.com.fbm.ceps.fbmceps.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository repository;

    public List<CidadeVO> listar(){
        return ConverterVO.parseListObjects(repository.findAll(), CidadeVO.class);
    }

    public CidadeVO buscarPorId(long pId){

        CidadeModel cidade = repository.findById(pId)
            .orElse(new CidadeModel());

        return ConverterVO.parseObject(cidade, CidadeVO.class);

    }

    public CidadeVO salvar(CidadeVO pCidadeVO){
        CidadeModel cidade = ConverterVO.parseObject(pCidadeVO, CidadeModel.class);
        return ConverterVO.parseObject(repository.save(cidade), CidadeVO.class);
    }

    public CidadeVO atualizar(CidadeVO pCidadeVO){

        CidadeModel registro = repository.findById(pCidadeVO.getId())
            .orElse(null);

        if( registro != null ){

            registro.setIbge( pCidadeVO.getIbge() );
            registro.setNomeCidade( pCidadeVO.getNomeCidade() );
            registro.setUf( pCidadeVO.getUf() );

            return ConverterVO.parseObject(repository.save(registro), CidadeVO.class);

        }

        return new CidadeVO();

    }

    public void deletar(long pId){

        CidadeModel registro = repository.findById(pId)
            .orElse(null);

        if( registro != null ){
            repository.deleteById(pId);
        }

    }

}
