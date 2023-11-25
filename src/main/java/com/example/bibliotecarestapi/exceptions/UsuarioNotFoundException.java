package com.example.bibliotecarestapi.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String message){
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
