package com.hiberus.servicios.Impl;

import com.hiberus.clientes.ClientePizzas;
import com.hiberus.dto.PizzaDto;
import com.hiberus.servicios.ServicioPizzas;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service("feign-pizzas")
public class ServicioPizzasImpl implements ServicioPizzas {
	Logger logger = Logger.getLogger(ServicioPizzas.class.getName());
	
    public ServicioPizzasImpl(ClientePizzas clientePizzas) {
		super();
		this.clientePizzas = clientePizzas;
	}

	private final ClientePizzas clientePizzas;

    @CircuitBreaker(name = "pizzas",fallbackMethod = "fallBackObtenerPizzas")
    @Override
	public List<PizzaDto> obtenerPizzas() {
		return clientePizzas.obtenerPizzas().getBody();
	}
    
    private List<PizzaDto> fallBackObtenerPizzas(Throwable throwable){
    	logger.info("Lista pizza por defecto");
        return new ArrayList<>();
    }
    
    @CircuitBreaker(name = "pizzas",fallbackMethod = "fallBackObtenerIdsPizzas")
	@Override
	public List<Integer> obtenerIdsPizzas() {
    	List<Integer> idsPizzas = new ArrayList<Integer>();
    	try {
    		idsPizzas = clientePizzas.obtenerIdsPizzas().getBody();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return idsPizzas;
	}
    
    private List<PizzaDto> fallBackObtenerIdsPizzas(Throwable throwable){
    	logger.info("Lista pizza por defecto");
        return new ArrayList<>();
    }
}
