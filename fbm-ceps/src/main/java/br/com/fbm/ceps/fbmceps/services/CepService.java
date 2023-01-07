package br.com.fbm.ceps.fbmceps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.converter.ConverterVO;
import br.com.fbm.ceps.fbmceps.data.vo.v1.CepVO;
import br.com.fbm.ceps.fbmceps.models.CepModel;
import br.com.fbm.ceps.fbmceps.repository.CepRepository;

@Service
public class CepService {
    
    @Autowired
    CepRepository repository;

    public List<CepVO> listar(){
        return ConverterVO.parseListObjects(repository.findAll(), CepVO.class);
    }

    public CepVO buscarPorId(long pId){

        CepModel registro = repository.findById(pId)
            .orElse(new CepModel());

        return ConverterVO.parseObject(registro, CepVO.class);
        
    }

    public CepVO salvar(CepVO pCepVO){
        CepModel cep = ConverterVO.parseObject(pCepVO, CepModel.class);
        return ConverterVO.parseObject(repository.save(cep), CepVO.class);
    }

    public CepVO atualizar(CepVO pCepVO){

        CepModel registro = repository.findById(pCepVO.getId()).orElse(null);

        if( registro != null ){

            registro.setBairro( pCepVO.getBairro() );
            registro.setCep( pCepVO.getCep() );
            registro.setComplemento( pCepVO.getComplemento() );
            registro.setDdd( pCepVO.getDdd() );
            registro.setGia( pCepVO.getGia() );
            registro.setIbge( pCepVO.getIbge() );
            registro.setLocalidade( pCepVO.getLocalidade() );
            registro.setLogradouro( pCepVO.getLogradouro() );
            registro.setSiafi( pCepVO.getSiafi() );
            registro.setUf( pCepVO.getUf() );

            return ConverterVO.parseObject(repository.save(registro), CepVO.class);

        }

        return new CepVO();

    }

    public void deletar(long pId){

        CepModel registro = repository.findById(pId).orElse(null);

        if(registro != null){
            repository.deleteById(pId);
        }

    }


}
