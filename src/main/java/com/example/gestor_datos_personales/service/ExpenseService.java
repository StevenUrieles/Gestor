package com.example.gestor_datos_personales.service;

import com.example.gestor_datos_personales.model.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    //Métodos de lectura
    List<Expense> expenseList();
    Optional<Expense> expenseById(Long id);

    //Métodos de escritura
    //Crear nuevo valor
    Expense newExpense (Expense expense);

    //Eliminar Valor
    void delete(Long lid);




}
