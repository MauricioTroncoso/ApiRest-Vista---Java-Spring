package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class producto {
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="id", unique =true ,nullable=false)
private Long id;
@Column(name="nombre_producto", length=20, nullable=false)
private String Nombre;
@Column(name="precio",length=20, nullable=false)
private int valor;
@Column(name="stock",length=20,nullable=false)
private int stock;
public producto() {
	super();
}
public producto(Long id, String nombre, int valor, int stock) {
	super();
	this.id = id;
	Nombre = nombre;
	this.valor = valor;
	this.stock = stock;
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
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}





}