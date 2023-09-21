package com.hiberus.clientes;

import com.hiberus.dto.PizzaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "pizza-read")
public interface ClientePizzas {

    @GetMapping(value = "/pizzas/obtenerPizzas")
	ResponseEntity<List<PizzaDto>> obtenerPizzas();
    
    @GetMapping(value = "/pizzas/obtenerIdsPizzas")
	ResponseEntity<List<Integer>> obtenerIdsPizzas();
}
