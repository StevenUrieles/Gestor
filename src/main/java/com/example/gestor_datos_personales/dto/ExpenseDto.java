package com.example.gestor_datos_personales.dto;

import com.example.gestor_datos_personales.model.entity.Expense;
import com.example.gestor_datos_personales.model.entity.enumerador.CategoryEnum;
import com.example.gestor_datos_personales.model.entity.enumerador.PaymentMethodEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class ExpenseDto extends Expense {
    private String description;
    private BigDecimal amount;
    private CategoryEnum category;
    private LocalDate date;
    private PaymentMethodEnum paymentMethod;
}
