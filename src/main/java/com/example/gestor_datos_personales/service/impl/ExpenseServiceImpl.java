package com.example.gestor_datos_personales.service.impl;

import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.mapper.ExpenseMapper;
import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.model.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.repository.ExpenseRepository;
import com.example.gestor_datos_personales.service.ExpenseService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private ExpenseMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Expense> expenseList() {
        return repository.findAll();
    }

    @Override
    public List<Expense> expenseListCategory(CategoryEnum categoryEnum) {
        return repository.findAll();
    }

    @Override
    public List<Expense> expenseListAmount(BigDecimal amount) {
        return repository.findAll();
    }

    @Override
    public List<Expense> expenseListDate(LocalDate date) {
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
    public ExpenseDto updateExpense(Long id, ExpenseDto dto) {
        return repository.findById(id).map(existingExpense -> {

            mapper.updateEntityFromDto(dto, existingExpense);

            Expense updatedExpense = repository.save(existingExpense);
            return mapper.toDto(updatedExpense);

        }).orElseThrow(() -> new RuntimeException("Gasto no encontrado con id: " + id));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
