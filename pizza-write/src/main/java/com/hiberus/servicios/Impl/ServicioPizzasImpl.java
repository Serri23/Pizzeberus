package com.hiberus.servicios.Impl;

import com.hiberus.modelos.Pizza;
import com.hiberus.repositorios.RepositorioPizza;
import com.hiberus.servicios.ServicioPizzas;

import java.util.Optional;

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

	@Override
	public Optional<Pizza> obtenerPizzaPorId(Integer id) {
		return repositorioPizza.findById(id);
	}


	@Override
	public Pizza modificarPizza(Optional<Pizza> pizza) {
		return repositorioPizza.save(pizza.get());
	}
}
