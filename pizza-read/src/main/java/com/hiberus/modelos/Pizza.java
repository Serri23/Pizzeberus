package com.hiberus.modelos;

import lombok.*;

import javax.persistence.*;

public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Setter
    @Column(name = "nombre")
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
	public Pizza(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

    
}
