package br.com.fbm.ceps.fbmceps.services.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.converter.ConverterVO;
import br.com.fbm.ceps.fbmceps.data.vo.v1.FaixaVO;
import br.com.fbm.ceps.fbmceps.models.FaixaModel;
import br.com.fbm.ceps.fbmceps.repository.FaixaRepository;

@Service
public class FaixaService {
    
    @Autowired
    FaixaRepository repository;

    public List<FaixaVO> listar(){
        return ConverterVO.parseListObjects(repository.findAll(), FaixaVO.class);
    }

    public FaixaVO buscarPorId(long pId){
        
        FaixaModel registro = repository.findById(pId)
            .orElse(new FaixaModel());

        return ConverterVO.parseObject(registro, FaixaVO.class);

    }

    public FaixaVO salvar(FaixaVO pFaixaVO){
        FaixaModel faixa = ConverterVO.parseObject(pFaixaVO, FaixaModel.class);
        return ConverterVO.parseObject(repository.save(faixa), FaixaVO.class);
    }

    public FaixaVO atualizar(FaixaVO pFaixaVO){

        FaixaModel faixa = repository.findById(pFaixaVO.getId())
            .orElse(null);

        if( faixa != null ){

            faixa.setIdCidade( pFaixaVO.getId() );
            faixa.setFaixaInicial( pFaixaVO.getFaixaInicial() );
            faixa.setFaixaFinal( pFaixaVO.getFaixaFinal() );

            return ConverterVO.parseObject(repository.save(faixa), FaixaVO.class);

        }

        return new FaixaVO();

    }

    public void deletar(long pId){

        FaixaModel faixa = repository.findById(pId)
            .orElse(null);

        if( faixa != null ){
            repository.deleteById(pId);
        }

    }


}
