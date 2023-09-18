package com.hiberus.dto;

public class PizzaDto {
	public PizzaDto(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	private Integer id;
    private String nombre;
    
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
}
