package br.com.fbm.calculadora.fbmcalculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedCalcException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public UnsupportedCalcException(String pMessage){
        super(pMessage);
    }

}

