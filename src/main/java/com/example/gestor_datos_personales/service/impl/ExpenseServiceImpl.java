package com.example.gestor_datos_personales.service.impl;

import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.mapper.ExpenseMapper;
import com.example.gestor_datos_personales.entity.Expense;
import com.example.gestor_datos_personales.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.repository.ExpenseRepository;
import com.example.gestor_datos_personales.service.ExpenseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;

    public ExpenseServiceImpl(ExpenseRepository repository, ExpenseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseList() {
        return repository.findAll()
                .stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseListCategory(CategoryEnum categoryEnum) {
        return repository.findAll()
                .stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseListAmount(BigDecimal amount) {
        return repository.findAll()
                .stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseListDate(LocalDate date) {
        return repository.findAll()
                .stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExpenseDto> expenseById(Long id) {
        return repository.findById(id)
                .map(mapper :: toDto);
    }

    @Override
    @Transactional
    public Expense newExpense(ExpenseDto dto) {

        Expense expense = mapper.toEntity(dto);

        return repository.save(expense);
    }

    @Override
    @Transactional
    public ExpenseDto updateExpense(Long id, ExpenseDto dto) {
        return repository.findById(id).map(existingExpense -> {

            mapper.updateEntityFromDto(dto, existingExpense);

            Expense updatedExpense = repository.save(existingExpense);
            return mapper.toDto(updatedExpense);

        }).orElseThrow(() -> new RuntimeException("Gasto no encontrado con id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
