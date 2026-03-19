package com.example.gestor_datos_personales.service;

import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.entity.Expense;
import com.example.gestor_datos_personales.entity.enumerador.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    List<ExpenseDto> expenseList();
    List<ExpenseDto> expenseListCategory(CategoryEnum categoryEnum);
    List<ExpenseDto> expenseListAmount(BigDecimal amount);
    List<ExpenseDto> expenseListDate(LocalDate date);
    Optional<ExpenseDto> expenseById(Long id);

    Expense newExpense (ExpenseDto dto);

    ExpenseDto updateExpense(Long id, ExpenseDto dto);

    void delete(Long lid);




}
