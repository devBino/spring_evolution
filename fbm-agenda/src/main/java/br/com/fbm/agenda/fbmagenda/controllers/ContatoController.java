package br.com.fbm.agenda.fbmagenda.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fbm.agenda.fbmagenda.models.ContatoModel;
import br.com.fbm.agenda.fbmagenda.repositories.singleton.ContatosList;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatosList contatos;

    @RequestMapping(
        method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModel registrar(@RequestBody ContatoModel pContato){

        final int id = new AtomicInteger( contatos.getList().size()).incrementAndGet();

        ContatoModel contatoModel = new ContatoModel(
            id,
            pContato.getNome(),
            pContato.getTelefone(),
            pContato.getEmail()
        );

        contatos.getList().add( contatoModel );

        return contatoModel;

    }    

    @RequestMapping(
        method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModel atualizar(@RequestBody ContatoModel pContato){

        contatos.getList()
            .stream()
            .filter(contato -> contato.getId() == pContato.getId())
            .forEach(contato -> {
                contato.setNome( pContato.getNome() );
                contato.setTelefone( pContato.getTelefone() );
                contato.setEmail( pContato.getEmail() );
            });

        return pContato;

    }

    @RequestMapping(value = "/{id}",
        method = RequestMethod.DELETE)
    public void deletar(@PathVariable(value = "id") int id){
        
        List<ContatoModel> listaContatos = contatos.getList()
            .stream()
            .filter(contato -> contato.getId() == id)
            .collect(Collectors.toList());

        if(listaContatos.isEmpty()){
            //erro aqui
        }

        contatos.getList().remove( listaContatos.get(0) );

    }

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ContatoModel listaPorId(@PathVariable(value = "id") int id){

        List<ContatoModel> listaContatos = contatos.getList()
            .stream()
            .filter(contato -> contato.getId() == id)
            .collect(Collectors.toList());

        if( listaContatos.isEmpty() ){
            //erro aqui
        }

        return listaContatos.get(0);

    }

    @RequestMapping(value="/contatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContatoModel> listar(){
        return contatos.getList();
    }

}
