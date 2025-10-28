package org.example.productmanagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value={ResourceAlreadyExists.class})
    public ResponseEntity<String> handleResourceAlreadyExistsException (ResourceAlreadyExists resourceAlreadyExists){
        return new ResponseEntity<>(resourceAlreadyExists.getMessage(), HttpStatus.CONFLICT);
    }
}
