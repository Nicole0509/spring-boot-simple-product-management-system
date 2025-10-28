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

    @ExceptionHandler(value={ResourceNotFound.class})
    public ResponseEntity<String> handleResourceNotFoundException (ResourceNotFound resourceNotFound){
        return new ResponseEntity<>(resourceNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={BadRequest.class})
    public ResponseEntity<String> handleBadRequestException (BadRequest badRequest){
        return new ResponseEntity<>(badRequest.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
