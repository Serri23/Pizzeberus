package com.hiberus.controladores;

import com.hiberus.dto.PizzaDto;
import com.hiberus.mappers.PizzaMapperImpl;
import com.hiberus.modelos.Pizza;
import com.hiberus.servicios.ServicioPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pizzas")
public class ControladorPizza {

    @Autowired
    ServicioPizzas servicioPizzas;

    @GetMapping(value = "/obtenerPizzas")
    ResponseEntity<List<PizzaDto>> obtenerPizzas(){
        List<Pizza> listaPizzas = servicioPizzas.obtenerPizzas();
        if(listaPizzas != null) {
        	List<PizzaDto> listaPizzasDto = new ArrayList<>();
            for(Pizza pizza : listaPizzas){
            	PizzaDto pizzaDto = PizzaMapperImpl.INSTANCIA.pizzaToPizzaDto(pizza);
                listaPizzasDto.add(pizzaDto);
            }
            return new ResponseEntity<>(listaPizzasDto, HttpStatus.OK);
        }else {
        	return new ResponseEntity<List<PizzaDto>>(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping(value = "/obtenerPizza/{id}")
    ResponseEntity<PizzaDto> obtenerPizza(@PathVariable Integer id) {
    	Optional<Pizza> pizza = servicioPizzas.obtenerPizzaPorId(id);
    	if(!pizza.isEmpty()) {
    		PizzaDto pizzaDto = PizzaMapperImpl.INSTANCIA.pizzaToPizzaDto(pizza.get());
	    	return new ResponseEntity<PizzaDto>(pizzaDto, HttpStatus.OK);
    	}else {
    		return new ResponseEntity<PizzaDto>(new PizzaDto(), HttpStatus.NOT_FOUND);
    	}
    }

    @GetMapping(value = "/obtenerIdsPizzas")
    ResponseEntity<List<Integer>> obtenerIdsPizzas(){
        List<Pizza> listaPizzas = servicioPizzas.obtenerPizzas();
        if(!listaPizzas.isEmpty()) {
        	List<Integer> listaIds = new ArrayList<>();
            for(Pizza pizza : listaPizzas){
                listaIds.add(pizza.getId());
            }
            return new ResponseEntity<>(listaIds, HttpStatus.OK);
        }else {
        	return new ResponseEntity<List<Integer>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        
    }

}
