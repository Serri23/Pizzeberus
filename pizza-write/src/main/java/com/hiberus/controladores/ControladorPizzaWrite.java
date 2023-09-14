package com.hiberus.controladores;

import com.hiberus.dto.PizzaDto;
import com.hiberus.modelos.Pizza;
import com.hiberus.servicios.ServicioPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pizzas")
public class ControladorPizzaWrite {

    @Autowired
    ServicioPizzas servicioPizzas;

    @PostMapping(value = "/crearPizza")
    ResponseEntity<PizzaDto> crearPizza(Integer id, String nombre){
        PizzaDto pizzaDto = servicioPizzas.crearPizza(id,nombre);
        return new ResponseEntity<PizzaDto>(pizzaDto, HttpStatus.CREATED);
    }

}
