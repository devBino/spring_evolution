package br.com.fbm.ceps.fbmceps.exceptions;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String message;
    private String details;
    private String cause;

    public ExceptionResponse(String message, String details, String cause){
        this.message = message;
        this.details = details;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    

}
