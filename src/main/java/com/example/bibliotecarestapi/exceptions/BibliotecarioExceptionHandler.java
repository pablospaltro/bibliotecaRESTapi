package com.example.bibliotecarestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BibliotecarioExceptionHandler {

    @ExceptionHandler(value = {BibliotecarioNotFoundException.class})
    public ResponseEntity<Object> handleBibliotecarioNotFoundException (BibliotecarioNotFoundException bibliotecarioNotFoundException){
                BibliotecarioException bibliotecarioException = new BibliotecarioException(
                bibliotecarioNotFoundException.getMessage(),
                bibliotecarioNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
                );

        return new ResponseEntity<>(bibliotecarioNotFoundException, HttpStatus.NOT_FOUND);
    }
}
