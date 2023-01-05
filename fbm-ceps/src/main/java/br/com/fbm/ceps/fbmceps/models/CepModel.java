package br.com.fbm.ceps.fbmceps.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cep")
public class CepModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cep", nullable = false, length = 8)
    private int cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "complemento", length = 80)
    private String complemento;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "localidade", nullable = false)
    private String localidade;

    @Column(name = "uf", nullable = false, length = 2)
    private String uf;

    @Column(name = "ibge", nullable = false, length = 10)
    private int ibge;

    @Column(name = "gia", length = 50)
    private String gia;

    @Column(name = "ddd", nullable = false, length = 10)
    private int ddd;

    @Column(name = "siafi", length = 10)
    private String siafi;

    public CepModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    


}
