package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class estado {
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="id", unique =true ,nullable=false)
private Long id;
@Column(name="nombre_estado", length=20, nullable=false)
private String Nombre;


public estado() {
	super();
}
public estado(Long id, String nombre) {
	super();
	this.id = id;
	Nombre = nombre;
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
	Nombre = nombre;
}




}