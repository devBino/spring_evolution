package br.com.fbm.ceps.fbmceps.data.vo.v1;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProcessoVO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idFaixa;
    private Timestamp dtInicio;
    private Timestamp dtFim;
    private String descStatus;

    public ProcessoVO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFaixa() {
        return idFaixa;
    }

    public void setIdFaixa(Long idFaixa) {
        this.idFaixa = idFaixa;
    }

    public Timestamp getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Timestamp dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Timestamp getDtFim() {
        return dtFim;
    }

    public void setDtFim(Timestamp dtFim) {
        this.dtFim = dtFim;
    }

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }


}
