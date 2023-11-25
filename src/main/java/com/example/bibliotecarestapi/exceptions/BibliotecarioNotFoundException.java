package com.example.bibliotecarestapi.exceptions;

public class BibliotecarioNotFoundException extends RuntimeException{

    public BibliotecarioNotFoundException (String message){
        super(message);
    }

    public BibliotecarioNotFoundException (String message, Throwable cause){
        super(message, cause);
    }
}
