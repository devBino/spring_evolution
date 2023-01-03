package br.com.fbm.agenda.fbmagenda.models;

public class PessoaModel {
    
    private String nome;
    private String telefone;
    private String email;

    public PessoaModel(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

}
