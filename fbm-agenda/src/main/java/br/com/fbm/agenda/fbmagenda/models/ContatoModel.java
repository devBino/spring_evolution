package br.com.fbm.agenda.fbmagenda.models;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class ContatoModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public ContatoModel(){}

    public ContatoModel(String nome, String telefone, String email){
        
        AtomicInteger geradorId = new AtomicInteger();        
        this.id = geradorId.incrementAndGet();
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public ContatoModel(Integer id, String nome, String telefone, String email){
        
        AtomicInteger geradorId = new AtomicInteger();

        if( id != null ){
            this.id = id;
        }else{
            this.id = geradorId.incrementAndGet();
        }
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
