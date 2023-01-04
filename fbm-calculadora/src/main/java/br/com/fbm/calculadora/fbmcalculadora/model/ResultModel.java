package br.com.fbm.calculadora.fbmcalculadora.model;

import java.io.Serializable;

public class ResultModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Double valor1;
    private Double valor2;
    private Double resultado;
    private Character operacao;

    public ResultModel(Double valor1, Double valor2, 
        Double resultado, Character operacao){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.resultado = resultado;
        this.operacao = operacao;
    }

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    

}
