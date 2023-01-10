package br.com.fbm.ceps.fbmceps.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fbm.ceps.fbmceps.exceptions.ExceptionResponse;
import br.com.fbm.ceps.fbmceps.exceptions.InvalidJwtAuthenticationException;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(InvalidJwtAuthenticationException pException,
        WebRequest pRequest){

            ExceptionResponse exception = new ExceptionResponse(
                pException.getMessage(), pRequest.getDescription(false), pException.getCause().getMessage());

            return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
            
    }

}
