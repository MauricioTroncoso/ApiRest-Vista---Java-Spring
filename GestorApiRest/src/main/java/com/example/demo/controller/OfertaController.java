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

import com.example.demo.entity.oferta;
import com.example.demo.service.OfertaService;




@RestController
@RequestMapping("api/oferta")
public class OfertaController {
	
	@Autowired
	private OfertaService ofService;
	Logger logger = LogManager.getLogger(OfertaController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<oferta> create (@RequestBody oferta newof){

		try {
			oferta of = ofService.create(newof);
			logger.info("oferta creada", of);
			return ResponseEntity.created(new URI("oferta" + of.getId())).body(of);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<oferta>> index(){
		return ResponseEntity.ok(ofService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<oferta>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando oferta ["+ id +"]");
		return ResponseEntity.ok(ofService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody oferta of){
		try {
			of.setId(id);
			ofService.update(of);
			logger.info("oferta Id["+id+"] actualizada", of);
			return ResponseEntity.status(HttpStatus.OK).body("oferta ["+ id +"] actualizada correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			ofService.delete(id);
			logger.info("oferta id["+id+"] eliminada", id);
			return ResponseEntity.status(HttpStatus.OK).body("oferta ["+ id +"] eliminada satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}