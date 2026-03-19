package com.example.gestor_datos_personales.dto;

import com.example.gestor_datos_personales.entity.Expense;
import com.example.gestor_datos_personales.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.entity.enumerador.PaymentMethodEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class ExpenseDto{

    @NotBlank(message = "Los valores no pueden ser nulos o blancos")
    @Size(min = 3, max = 200)
    private String description;


    //Monto del gasto
    @NotNull(message = "Los valores no pueden ser nulos o blancos")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;


    //Categoría del gasto
    @NotNull(message = "Los valores no pueden ser nulos o blancos")
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;


    //Fecha del gasto
    @NotNull(message = "Los valores no pueden ser nulos o blancos")
    @FutureOrPresent(message = "la fecha no puede ser pasada")
    private LocalDate date;


    //Método de pago usado
    @NotNull(message = "Los valores no pueden ser nulos o blancos")
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;
}
