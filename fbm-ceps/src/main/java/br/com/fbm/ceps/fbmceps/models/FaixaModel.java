package br.com.fbm.ceps.fbmceps.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_faixa")
public class FaixaModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "idCidade", nullable = false)
    private Long idCidade;

    @Column(name = "faixaInicial", nullable = false, length = 10)
    private String faixaInicial;

    @Column(name = "faixaFinal", nullable = false, length = 10)
    private String faixaFinal;

    public FaixaModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getFaixaInicial() {
        return faixaInicial;
    }

    public void setFaixaInicial(String faixaInicial) {
        this.faixaInicial = faixaInicial;
    }

    public String getFaixaFinal() {
        return faixaFinal;
    }

    public void setFaixaFinal(String faixaFinal) {
        this.faixaFinal = faixaFinal;
    }

    

}
