package com.hiberus.servicios;

import com.hiberus.modelos.Pizza;

import org.springframework.stereotype.Service;


@Service
public interface ServicioPizzas {

    Pizza crearPizza(Integer id,String nombre);

}
