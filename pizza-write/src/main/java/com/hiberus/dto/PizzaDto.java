package com.hiberus.dto;

public class PizzaDto {
	
	private Integer id;
    private String nombre;
    
    public PizzaDto(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
    
	public PizzaDto() {
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
}
