package br.com.fbm.agenda.fbmagenda.repositories.singleton;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.fbm.agenda.fbmagenda.models.ContatoModel;

@Service
@Scope("singleton")
public class ContatosList {

    private List<ContatoModel> contatos;
    private List<Integer> numbers;

    private ContatosList(){
        contatos = new ArrayList<>();
    }

    public List<ContatoModel> getList(){
        return contatos;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
