package br.com.fbm.calculadora.fbmcalculadora.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Date timestamp;
    private String message;
    private String details;
    private String cause;
    
    public ExceptionResponse(Date timestamp, String message, String details, String cause) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.cause = cause;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
