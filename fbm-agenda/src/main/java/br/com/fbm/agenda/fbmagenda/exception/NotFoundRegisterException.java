package br.com.fbm.agenda.fbmagenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundRegisterException extends RuntimeException {
    
    private final static long serialVersionUID = 1L;

    public NotFoundRegisterException(){
        super("Nenhum registro encontrado...");
    }

    public NotFoundRegisterException(String message){
        super(message);
    }

}
