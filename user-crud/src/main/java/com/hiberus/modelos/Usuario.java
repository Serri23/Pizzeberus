package com.hiberus.modelos;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
@Entity
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Setter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Column(name = "pizzasFavoritas")
    private ArrayList<String> pizzasFavoritas;

}