package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class categoria {
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="id", unique =true ,nullable=false)
private Long id;
@Column(name="nombre_categoria", length=20, nullable=false)
private String Nombre;

public categoria() {
	super();
}



public categoria(Long id, String nombre) {
	super();
	this.id = id;
	this.Nombre = nombre;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getNombre() {
	return Nombre;
}



public void setNombre(String nombre) {
	this.Nombre  = nombre;
}


}
