package com.example.gestor_datos_personales.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "expense")
public class Expense {


    //Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter @Setter
    private Long id;


    //Descripción del gasto
    @NotNull
    @Column(nullable = false, length = 200)
    @NotBlank
    @Size(min = 3, max = 200)
    private String description;


    //Monto del gasto
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;


    //Categoría del gasto
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;


    //Fecha del gasto
    @NotNull
    @Column(nullable = false)
    @PastOrPresent(message = "la fecha no puede ser futura")
    private LocalDate date;


    //Método de pago usado
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

}
