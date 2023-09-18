package com.hiberus.servicios.Impl;

import com.hiberus.clientes.ClientePizzas;
import com.hiberus.dto.PizzaDto;
import com.hiberus.servicios.ServicioPizzas;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("feign-pizzas")
public class ServicioPizzasImpl implements ServicioPizzas {
	Logger log;
	
    public ServicioPizzasImpl(ClientePizzas clientePizzas) {
		super();
		this.clientePizzas = clientePizzas;
	}

	private final ClientePizzas clientePizzas;

    @CircuitBreaker(name = "pizzas",fallbackMethod = "fallBackObtenerPizzasPorUsuario")
    @Override
    public List<PizzaDto> obtenerPizzasPorUsuario(Integer idUsuario) {
        return clientePizzas.obtenerPizzasPorUsuario(idUsuario).getBody();
    }

    private List<PizzaDto> fallBackObtenerPizzasPorUsuario(Integer idUsuario, Throwable throwable){
        log.info("Lista pizza por defecto");
        return new ArrayList<>();
    }
}
