package com.hiberus.servicios.Impl;

import com.hiberus.modelos.Pizza;
import com.hiberus.repositorios.RepositorioPizza;
import com.hiberus.servicios.ServicioPizzas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPizzasImpl implements ServicioPizzas {

    @Autowired
    RepositorioPizza repositorioPizza;

    @Override
    public List<Pizza> obtenerPizzas() {
        return repositorioPizza.findAll();
    }

	@Override
	public Optional<Pizza> obtenerPizzaPorId(Integer id) {
		Optional<Pizza> pizza = repositorioPizza.findById(id);
		return pizza;
	}

//    @Override
//    public List<Pizza> obtenerPizzasPorIdUsuario(Integer idUsuario) {
//        return repositorioPizza.findByIdUsuario(idUsuario);
//    }
}
