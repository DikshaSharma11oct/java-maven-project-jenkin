package com.contactUs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
public class GlobalExceptionhandler  {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handlebadrequest(BadRequestException badRequestEx){
        return new ResponseEntity<String>("Inputfields are empty", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlebadrequest(EntityNotFoundException EntityNotFoundEx){
        return new ResponseEntity<String>("Inputfields are empty", HttpStatus.BAD_REQUEST);

    }






    // @ExceptionHandler
    // public 




    
}
