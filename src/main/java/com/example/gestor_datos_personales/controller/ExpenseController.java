package com.example.gestor_datos_personales.controller;
import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.exception.GlobalExceptionHandler;
import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.model.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @ExceptionHandler
    public ResponseEntity<?> handlerExceptionGlobal(GlobalExceptionHandler g){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(g.getMessage());
    }

    @GetMapping
    @Transactional(readOnly = true)//solo lectura
    public List<Expense> expensesList(){
        return service.expenseList();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)//solo lectura
    public ResponseEntity<?> expenseById(@PathVariable Long id){
        Optional<Expense> expenseOptional = service.expenseById(id);

        if(expenseOptional.isPresent()){
            return ResponseEntity.ok().build();
        }
        return (ResponseEntity<?>) ResponseEntity.notFound().build().getBody();
    }

    @GetMapping("/{categoryEnum}")
    @Transactional(readOnly = true)
    public List<Expense> expenseListCategoryEnum(@PathVariable CategoryEnum categoryEnum){
        return service.expenseListCategory(categoryEnum);
    }


    @GetMapping("/{amount}")
    @Transactional(readOnly = true)
    public List<Expense> expenseListAmount(@PathVariable BigDecimal amount){
        return service.expenseListAmount(amount);
    }

    @GetMapping("/{date}")
    @Transactional(readOnly = true)
    public List<Expense> expenseListDate(@PathVariable LocalDate date){
        return service.expenseListDate(date);
    }

    @PostMapping("/expenses")
    @Transactional
    public ResponseEntity<?> createNewExpense(@RequestBody  Expense expense) {

            Expense e = service.newExpense(expense);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()       // Toma la URL actual (/expenses)
                .path("/{id}")              // Añade "/{id}" al final
                .buildAndExpand(e.getId())  // Reemplaza {id} con el id real
                .toUri();                   // Convierte todo en un objeto URI

        return ResponseEntity.created(location).body(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        try {
            ExpenseDto result = (ExpenseDto) service.updateExpense(id, expenseDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            // Si el Service lanza la excepción porque no encontró el ID
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
