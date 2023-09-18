package com.hiberus.servicios.Impl;

import com.hiberus.modelos.Pizza;
import com.hiberus.repositorios.RepositorioPizza;
import com.hiberus.servicios.ServicioPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioPizzasImpl implements ServicioPizzas {

    @Autowired
    RepositorioPizza repositorioPizza;

	@Override
	public Pizza crearPizza(Integer id, String nombre) {
		Pizza pizza = new Pizza();
		pizza.setId(id);
		pizza.setNombre(nombre);
		return repositorioPizza.save(pizza);
	}
}
