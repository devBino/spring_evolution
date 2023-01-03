package br.com.fbm.calculadora.fbmcalculadora.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fbm.calculadora.fbmcalculadora.exception.ExceptionResponse;
import br.com.fbm.calculadora.fbmcalculadora.exception.UnsupportedCalcException;

@ControllerAdvice
@RestController
public class CustomizedCalcResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception pException, 
        WebRequest pRequest){
        
        ExceptionResponse exception = new ExceptionResponse(
            new Date(), pException.getMessage(), pRequest.getDescription(false), "Cause by Exception.class");

        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UnsupportedCalcException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception pException, 
        WebRequest pRequest){

            ExceptionResponse exception = new ExceptionResponse(
                new Date(), pException.getMessage(), pRequest.getDescription(false),
                "Caused by br.com.fbm.calculadora.fbmcalculadora.exception.UnsupportedCalcException");

            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

    }

}
