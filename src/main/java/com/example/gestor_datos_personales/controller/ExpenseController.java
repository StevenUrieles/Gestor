package com.example.gestor_datos_personales.controller;
import com.example.gestor_datos_personales.exception.GlobalExceptionHandler;
import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
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
        return ResponseEntity.notFound().build();
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
    public ResponseEntity<?> updateExpense(@PathVariable Long id,@RequestBody Expense expense){

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
