package br.com.fbm.ceps.fbmceps.data.vo.v1;

import java.io.Serializable;

public class FaixaVO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idCidade;
    private String faixaInicial;
    private String faixaFinal;

    public FaixaVO(){}

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
