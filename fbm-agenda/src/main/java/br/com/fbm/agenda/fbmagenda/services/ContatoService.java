package br.com.fbm.agenda.fbmagenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fbm.agenda.fbmagenda.exception.NotFoundRegisterException;
import br.com.fbm.agenda.fbmagenda.models.ContatoModelDB;
import br.com.fbm.agenda.fbmagenda.repositories.iface.ContatoModelDBRepository;

@Service
public class ContatoService {
    
    @Autowired
    ContatoModelDBRepository repository;

    public ContatoModelDB create(ContatoModelDB pContato){
        return repository.save(pContato);
    }

    public ContatoModelDB update(ContatoModelDB pContato){

        ContatoModelDB registro = repository.findById( pContato.getId() )
            .orElseThrow(()-> new NotFoundRegisterException());

        registro.setNome( pContato.getNome() );
        registro.setEmail( pContato.getEmail() );
        registro.setTelefone( pContato.getTelefone() );

        return repository.save(registro);

    }

    public void delete(long id){
        
        repository.findById(id)
            .orElseThrow(() -> new NotFoundRegisterException());

        repository.deleteById(id);

    }

    public List<ContatoModelDB> findAll() {
        return repository.findAll();
    }

    public ContatoModelDB findById(long id)
        throws NotFoundRegisterException {

        return repository.findById(id)
            .orElseThrow(()-> new NotFoundRegisterException());

    }

}
