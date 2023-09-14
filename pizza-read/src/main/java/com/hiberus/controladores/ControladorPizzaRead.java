package com.hiberus.controladores;

import com.hiberus.dto.PizzaDto;
import com.hiberus.modelos.Pizza;
import com.hiberus.servicios.ServicioPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pizzas")
public class ControladorPizza {

    @Autowired
    ServicioPizzas servicioPizzas;

    @GetMapping(value = "/obtenerPizzas")
    ResponseEntity<List<PizzaDto>> obtenerPizzas(){
        List<Pizza> listaPizzas = servicioPizzas.obtenerPizzas();
        List<PizzaDto> listaPizzasDto = new ArrayList<>();
        for(Pizza pizza : listaPizzas){
            PizzaDto pizzaDto = PizzaDto.builder()
                    .id(pizza.getId())
                    .nombre(pizza.getNombre())
                    .talla(pizza.getTalla())
                    .color(pizza.getColor())
                    .idUsuario(pizza.getIdUsuario())
                    .build();
            listaPizzasDto.add(pizzaDto);
        }
        return new ResponseEntity<>(listaPizzasDto, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerPizzasPorUsuario")
    ResponseEntity<List<PizzaDto>> obtenerPizzasPorUsuario(@RequestParam Integer idUsuario){
        List<Pizza> listaPizzas = servicioPizzas.obtenerPizzasPorIdUsuario(idUsuario);
        List<PizzaDto> listaPizzasDto = new ArrayList<>();
        for(Pizza pizza : listaPizzas){
            PizzaDto pizzaDto = PizzaDto.builder()
                    .id(pizza.getId())
                    .nombre(pizza.getNombre())
                    .talla(pizza.getTalla())
                    .color(pizza.getColor())
                    .idUsuario(pizza.getIdUsuario())
                    .build();
            listaPizzasDto.add(pizzaDto);
        }
        return new ResponseEntity<>(listaPizzasDto, HttpStatus.OK);
    }

}
