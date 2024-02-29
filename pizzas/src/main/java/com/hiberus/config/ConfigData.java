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
            Pizza pizza1 = Pizza.builder()
                    .nombre("Camiseta")
                    .talla("L")
                    .color("Rojo")
                    .idUsuario(1)
                    .build();

            Pizza pizza2 = Pizza.builder()
                    .nombre("Polo")
                    .talla("L")
                    .color("Negro")
                    .idUsuario(1)
                    .build();

            Pizza pizza3 = Pizza.builder()
                    .nombre("Pantalón de deporte")
                    .talla("M")
                    .color("Blanco")
                    .idUsuario(2)
                    .build();

            Pizza pizza4 = Pizza.builder()
                    .nombre("Gorro")
                    .talla("S")
                    .color("Naranja")
                    .idUsuario(3)
                    .build();

            repositorioPizza.saveAll(List.of(pizza1, pizza2, pizza3, pizza4));
        };
    }
}
