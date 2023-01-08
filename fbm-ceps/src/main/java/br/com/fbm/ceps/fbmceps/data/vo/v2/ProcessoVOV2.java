package br.com.fbm.ceps.fbmceps.data.vo.v2;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"key", "idFaixa", "descStatus","ativo","dtInicio","dtFim"})
public class ProcessoVOV2 extends RepresentationModel<ProcessoVOV2> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;

    @JsonProperty("id_faixa")
    private Long idFaixa;

    @JsonProperty("data_inicio")
    private Timestamp dtInicio;

    @JsonProperty("data_final")
    private Timestamp dtFim;

    @JsonProperty("descricao_status")
    private String descStatus;

    @JsonIgnore
    private Boolean ativo;

    public ProcessoVOV2(){}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    

}
