package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distribuidores")
public class distribuidor {
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="id", unique =true ,nullable=false)
private Long id;
@Column(name="nombre_distribuidor", length=20, nullable=false)
private String Nombre;
public distribuidor() {
	super();
}
public distribuidor(Long id, String nombre) {
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
