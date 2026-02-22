package com.example.gestor_datos_personales.exception;

public class ExpenseController extends RuntimeException {
    public ExpenseController(String message) {
        super(message);
    }
}
