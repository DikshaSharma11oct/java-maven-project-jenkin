package com.contactUs.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {

    private HttpStatus status;
    private String message;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYY hh:mm:ss")
    private LocalDateTime timestamp;

     //Constructor of BadRequest
     public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

     public ErrorMessage(String message) {
        this.message = message;
    }

     public ErrorMessage(HttpStatus status) {
        this.status = status;
    }

    
}
