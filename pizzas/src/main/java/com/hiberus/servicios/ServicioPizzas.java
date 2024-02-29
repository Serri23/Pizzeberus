package com.hiberus.servicios;

import com.hiberus.modelos.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioPizzas {

    List<Pizza> obtenerPizzas();

    List<Pizza> obtenerPizzasPorIdUsuario(Integer idUsuario);
}
