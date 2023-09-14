package com.hiberus.dto;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private ArrayList<String> pizzasFavoritas;
}
