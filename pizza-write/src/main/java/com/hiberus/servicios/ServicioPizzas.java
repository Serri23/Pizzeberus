package com.hiberus.servicios;

import com.hiberus.dto.PizzaDto;
import org.springframework.stereotype.Service;


@Service
public interface ServicioPizzas {

    PizzaDto crearPizza(Integer id,String nombre);

}
