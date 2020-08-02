package com.petz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler({ClienteNotFound.class})
    public ResponseEntity<?> clienteNotFound(ClienteNotFound clienteNotFound){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteNotFound.getMessage());
    }

    @ExceptionHandler({PetNotFound.class})
    public ResponseEntity<?> petNotFound(PetNotFound petNotFound){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(petNotFound.getMessage());
    }
}
