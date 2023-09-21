package com.hiberus.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hiberus.dto.PizzaDto;
import com.hiberus.modelos.Pizza;

@Mapper
public interface PizzaMapper {

	PizzaMapper INSTANCIA= Mappers.getMapper(PizzaMapper.class);
	  
	PizzaDto pizzaToPizzaDto(Pizza pizza);
}
