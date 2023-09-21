package com.hiberus.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.modelos.Pizza;


@Repository
public interface RepositorioPizza extends JpaRepository<Pizza,Integer> {
    //List<Pizza> findByIdUsuario(Integer idUsuario);
}
