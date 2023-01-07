package br.com.fbm.ceps.fbmceps.data.vo.v1;

import java.io.Serializable;

public class CidadeVO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer ibge;
    private String nomeCidade;
    private String uf;

    public CidadeVO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
