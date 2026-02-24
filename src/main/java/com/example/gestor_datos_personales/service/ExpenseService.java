package com.example.gestor_datos_personales.service;

import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.model.entity.enumerador.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    List<Expense> expenseList();
    List<Expense> expenseListCategory(CategoryEnum categoryEnum);
    List<Expense> expenseListAmount(BigDecimal amount);
    List<Expense> expenseListDate(LocalDate date);
    Optional<Expense> expenseById(Long id);

    Expense newExpense (Expense expense);

    Expense updateExpense(Long id, ExpenseDto dto);

    void delete(Long lid);




}
