package com.contactUs.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    private HttpStatus status;
    private String message;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYY hh:mm:ss")
    private LocalDateTime timestamp;


    //Constructor of BadRequest
    public EntityNotFoundException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

     public EntityNotFoundException(String message) {
        this.message = message;
    }

     public EntityNotFoundException(HttpStatus status) {
        this.status = status;
    }
    
}
