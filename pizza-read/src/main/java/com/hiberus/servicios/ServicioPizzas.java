package com.hiberus.servicios;

import com.hiberus.modelos.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServicioPizzas {

    List<Pizza> obtenerPizzas();

	Optional<Pizza> obtenerPizzaPorId(Integer id);

    //List<Pizza> obtenerPizzasPorIdUsuario(Integer idUsuario);
}
