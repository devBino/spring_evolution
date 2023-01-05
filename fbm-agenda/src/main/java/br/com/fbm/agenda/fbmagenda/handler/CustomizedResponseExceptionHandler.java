package br.com.fbm.agenda.fbmagenda.handler;

import org.apache.catalina.connector.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fbm.agenda.fbmagenda.exception.ExceptionResponse;
import br.com.fbm.agenda.fbmagenda.exception.NotFoundRegisterException;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericException(Exception pException,
        WebRequest pRequest){

            ExceptionResponse exception = new ExceptionResponse(
                pException.getMessage(), pRequest.getDescription(false), pException.getCause().getMessage());

            return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NotFoundRegisterException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundRegisterException(NotFoundRegisterException pException, 
        WebRequest pRequest){

            ExceptionResponse exception = new ExceptionResponse(
                pException.getMessage(), pRequest.getDescription(false), pException.getCause().getMessage());

            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);

    }

}
