package com.example.gestor_datos_personales.mapper;


import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    ExpenseDto toDto(Expense expense);

    Expense toEntity(ExpenseDto dto);

    void updateEntityFromDto(ExpenseDto dto, @MappingTarget Expense entity);

}

