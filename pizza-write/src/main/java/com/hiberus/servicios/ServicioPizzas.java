package com.hiberus.servicios;

import com.hiberus.modelos.Pizza;

import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public interface ServicioPizzas {

    Pizza crearPizza(Integer id,String nombre);

	Optional<Pizza> obtenerPizzaPorId(Integer id);

	Pizza modificarPizza(Optional<Pizza> pizza);

}
