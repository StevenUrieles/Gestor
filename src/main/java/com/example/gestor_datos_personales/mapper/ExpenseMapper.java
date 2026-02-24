package com.example.gestor_datos_personales.mapper;


import com.example.gestor_datos_personales.dto.ExpenseDto;
import com.example.gestor_datos_personales.model.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseDto dto(Expense expense);

    ExpenseDto toDto(Expense expense);
    Expense toEntity(ExpenseDto dto);
    void updateEntityFromDto(ExpenseDto dto, @MappingTarget Expense entity);

}
