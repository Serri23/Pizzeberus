package com.hiberus.config;

import com.hiberus.modelos.Pizza;
import com.hiberus.repositorios.RepositorioPizza;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigData {
    @Bean("ConfigData")
    CommandLineRunner commandLineRunner(RepositorioPizza repositorioPizza) {
        return args -> {
//            Pizza pizza1 = new Pizza(1,"Margarita");
//
//            Pizza pizza2 = new Pizza(2,"Diabola");
//
//            repositorioPizza.saveAll(List.of(pizza1, pizza2));
        };
    }
}
