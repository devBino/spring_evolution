package br.com.fbm.ceps.fbmceps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.ceps.fbmceps.models.CepModel;
import br.com.fbm.ceps.fbmceps.repository.CepRepository;

@Service
public class CepService {
    
    @Autowired
    CepRepository repository;

    public List<CepModel> listar(){
        return repository.findAll();
    }

    public CepModel buscarPorId(long id){

        CepModel registro = repository.findById(id).orElse(null);

        if( registro != null ){
            return registro;
        }

        return new CepModel();

    }

    public CepModel salvar(CepModel pCep){
        return repository.save(pCep);
    }

    public CepModel atualizar(CepModel pCep){

        CepModel registro = repository.findById(pCep.getId()).orElse(null);

        if( registro != null ){

            registro.setBairro( pCep.getBairro() );
            registro.setCep( pCep.getCep() );
            registro.setComplemento( pCep.getComplemento() );
            registro.setDdd( pCep.getDdd() );
            registro.setGia( pCep.getGia() );
            registro.setIbge( pCep.getIbge() );
            registro.setLocalidade( pCep.getLocalidade() );
            registro.setLogradouro( pCep.getLogradouro() );
            registro.setSiafi( pCep.getSiafi() );
            registro.setUf( pCep.getUf() );

            repository.save(registro);

            return registro;

        }

        return new CepModel();

    }

    public void deletar(long id){

        CepModel registro = repository.findById(id).orElse(null);

        if(registro != null){
            repository.deleteById(id);
        }

    }


}
