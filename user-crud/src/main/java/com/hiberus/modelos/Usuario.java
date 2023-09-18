package com.hiberus.modelos;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;


@Table(name = "usuarios")
@Entity
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getPizzasFavoritas() {
		return pizzasFavoritas;
	}
	public void setPizzasFavoritas(ArrayList<String> pizzasFavoritas) {
		this.pizzasFavoritas = pizzasFavoritas;
	}
    
    

}