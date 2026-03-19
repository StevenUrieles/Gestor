package com.example.gestor_datos_personales.repository;

import com.example.gestor_datos_personales.entity.Expense;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<@NotNull Expense, @NotNull Long> {

}
