package com.example.gestor_datos_personales.service.impl;

import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.repository.ExpenseRepository;
import com.example.gestor_datos_personales.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

//Implementa el service e inyecta el repository(CRUD)
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Expense> expenseList() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Expense> expenseById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Expense newExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    @Transactional
    public void Eliminar(Long id) {
        repository.deleteById(id);
    }
}
