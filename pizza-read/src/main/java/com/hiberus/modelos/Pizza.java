package com.hiberus.modelos;

import javax.persistence.*;

@Table(name = "pizzas")
@Entity
public class Pizza {

	public Pizza() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
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
