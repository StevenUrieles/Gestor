package com.example.gestor_datos_personales.exception;

public class valueDoesNotExistException extends RuntimeException {
    public valueDoesNotExistException(String message) {
        super(message);
    }
}
