package br.com.fbm.ceps.fbmceps.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_processo")
public class ProcessoModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "idFaixa", nullable = false)
    private Long idFaixa;

    @Column(name = "dtInicio", nullable = false)
    private Timestamp dtInicio;

    @Column(name = "dtFim", nullable = false)
    private Timestamp dtFim;

    @Column(name = "descStatus", nullable = false)
    private String descStatus;

    public ProcessoModel(){}

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
