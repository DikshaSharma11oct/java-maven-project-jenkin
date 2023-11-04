package com.contactUs.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidationException extends RuntimeException{

    private static final long serialVersionUID=1L;

    private HttpStatus status;
    private String message;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYY hh:mm:ss")
    private LocalDateTime timestamp;


    //Constructor of BadRequest
    public ValidationException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

     public ValidationException(String message) {
        this.message = message;
    }

     public ValidationException(HttpStatus status) {
        this.status = status;
    }
    
    
    
}
