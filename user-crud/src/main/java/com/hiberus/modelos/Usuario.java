package com.hiberus.modelos;

import java.util.ArrayList;

import javax.persistence.*;


@Table(name = "usuarios")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pizzasFavoritas")
    private ArrayList<Integer> pizzasFavoritas;
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
	public ArrayList<Integer> getPizzasFavoritas() {
		return pizzasFavoritas;
	}
	public void setPizzasFavoritas(ArrayList<Integer> pizzasFavoritas) {
		this.pizzasFavoritas = pizzasFavoritas;
	}
    
    

}