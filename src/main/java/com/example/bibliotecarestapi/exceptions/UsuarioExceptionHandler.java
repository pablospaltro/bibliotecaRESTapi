package com.example.bibliotecarestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioExceptionHandler {

    @ExceptionHandler(value = {UsuarioNotFoundException.class})
    public ResponseEntity<Object> handleBibliotecarioNotFoundException (UsuarioNotFoundException bibliotecarioNotFoundException){
                UsuarioException bibliotecarioException = new UsuarioException(
                bibliotecarioNotFoundException.getMessage(),
                bibliotecarioNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
                );

        return new ResponseEntity<>(bibliotecarioNotFoundException, HttpStatus.NOT_FOUND);
    }
}
