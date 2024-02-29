package com.hiberus.controladores;

import com.hiberus.dto.PizzaDto;
import com.hiberus.mappers.PizzaMapperImpl;
import com.hiberus.modelos.Pizza;
import com.hiberus.servicios.ServicioPizzas;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pizzas")
public class ControladorPizza {

    @Autowired
    ServicioPizzas servicioPizzas;

    @PostMapping(value = "/crearPizza")
    ResponseEntity<PizzaDto> crearPizza(@RequestBody Map<String,String> body){
    	Pizza pizza = servicioPizzas.crearPizza(body.get("nombre"));
    	PizzaDto pizzaDto = PizzaMapperImpl.INSTANCIA.pizzaToPizzaDto(pizza);
    	return new ResponseEntity<PizzaDto>(pizzaDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/modificarPizza/{id}")
    ResponseEntity<PizzaDto> modificarPizza(@PathVariable Integer id,@RequestBody Map<String,String> body) {
    	Optional<Pizza> pizza = servicioPizzas.obtenerPizzaPorId(id);
    	if(pizza.isEmpty()) {
    		return new ResponseEntity<PizzaDto>(new PizzaDto(), HttpStatus.NOT_FOUND);
    	}else {
    		pizza.get().setNombre(body.get("nombre"));
    		if(servicioPizzas.modificarPizza(pizza) != null){
    			PizzaDto pizzaDto = PizzaMapperImpl.INSTANCIA.pizzaToPizzaDto(pizza.get());
        		return new ResponseEntity<PizzaDto>(pizzaDto, HttpStatus.OK);
    		}else {
    			return new ResponseEntity<PizzaDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
}
