package com.example.gestor_datos_personales.entity;
import com.example.gestor_datos_personales.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.entity.enumerador.PaymentMethodEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "expense")
public class Expense {


    //Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    //Descripción del gasto
    @NotBlank(message = "Los valores no pueden ser nulos o blancos")
    @Size(min = 3, max = 200)
    private String description;


    //Monto del gasto
    @NotNull(message = "Los valores no pueden ser nulos o blancos")
    @DecimalMin(value = "0.01", inclusive = true)
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


