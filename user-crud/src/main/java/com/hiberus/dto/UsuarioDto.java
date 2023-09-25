package com.hiberus.dto;

import java.util.ArrayList;

public class UsuarioDto {
    
	private Integer id;
    private String nombre;
    private ArrayList<Integer> pizzasFavoritas;
    
    public UsuarioDto(Integer id, String nombre, ArrayList<Integer> pizzasFavoritas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pizzasFavoritas = pizzasFavoritas;
	}
    
	public UsuarioDto() {
		// TODO Auto-generated constructor stub
	}

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
