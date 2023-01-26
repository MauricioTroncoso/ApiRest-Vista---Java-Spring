package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.estado;
import com.example.demo.service.EstadoService;



@RestController
@RequestMapping("api/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService esService;
	Logger logger = LogManager.getLogger(EstadoController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<estado> create (@RequestBody estado newes){

		try {
			estado es = esService.create(newes);
			logger.info("estado creado", es);
			return ResponseEntity.created(new URI("estado" + es.getId())).body(es);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<estado>> index(){
		return ResponseEntity.ok(esService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<estado>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando estado ["+ id +"]");
		return ResponseEntity.ok(esService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody estado es){
		try {
			es.setId(id);
			esService.update(es);
			logger.info("estado Id["+id+"] actualizado", es);
			return ResponseEntity.status(HttpStatus.OK).body("estado ["+ id +"] actualizado correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			esService.delete(id);
			logger.info("estado id["+id+"] eliminado", id);
			return ResponseEntity.status(HttpStatus.OK).body("estado ["+ id +"] eliminado satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}