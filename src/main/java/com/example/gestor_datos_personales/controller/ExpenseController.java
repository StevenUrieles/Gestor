package com.example.gestor_datos_personales.controller;
import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.exception.GlobalExceptionHandler;
import com.example.gestor_datos_personales.entity.Expense;
import com.example.gestor_datos_personales.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.exception.valueDoesNotExistException;
import com.example.gestor_datos_personales.service.ExpenseService;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerExceptionGlobal(GlobalExceptionHandler g){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(g.getMessage());
    }

    @GetMapping
    public List<ExpenseDto> expensesList(){
        return service.expenseList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> expenseById(@PathVariable Long id){
        Optional<ExpenseDto> expenseOptional = service.expenseById(id);

        if(expenseOptional.isPresent()){
            return ResponseEntity.ok(service.expenseById(id));
        }
        return (ResponseEntity<?>) ResponseEntity.notFound().build().getBody();
    }

    @GetMapping("/category/{category}")
    public List<ExpenseDto> expenseListCategoryEnum(@PathVariable CategoryEnum categoryEnum){
        return service.expenseListCategory(categoryEnum);
    }


    @GetMapping("/amount/{amount}")
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseListAmount(@PathVariable BigDecimal amount){
        return service.expenseListAmount(amount);
    }

    @GetMapping("/date/{date}")
    @Transactional(readOnly = true)
    public List<ExpenseDto> expenseListDate(@PathVariable LocalDate date){
        return service.expenseListDate(date);
    }

    @PostMapping
    public ResponseEntity<?> createNewExpense(@RequestBody  ExpenseDto dto) {

        Expense e = service.newExpense(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()       // Toma la URL actual (/expenses)
                .path("/{id}")              // Añade "/{id}" al final
                .buildAndExpand(e.getId())  // Reemplaza {id} con el id real
                .toUri();                   // Convierte todo en un objeto URI

        return ResponseEntity.created(location).body(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        return ResponseEntity.ok(service.updateExpense(id, expenseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
