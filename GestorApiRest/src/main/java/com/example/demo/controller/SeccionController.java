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



import com.example.demo.entity.seccion;
import com.example.demo.service.SeccionService;



@RestController
@RequestMapping("api/seccion")
public class SeccionController {
	
	@Autowired
	private SeccionService seService;
	Logger logger = LogManager.getLogger(SeccionController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<seccion> create (@RequestBody seccion newse){

		try {
			seccion se = seService.create(newse);
			logger.info("seccion creada", se);
			return ResponseEntity.created(new URI("seccion" + se.getId())).body(se);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<seccion>> index(){
		return ResponseEntity.ok(seService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<seccion>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando Seccion ["+ id +"]");
		return ResponseEntity.ok(seService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody seccion se){
		try {
			se.setId(id);
			seService.update(se);
			logger.info("seccion Id["+id+"] actualizada", se);
			return ResponseEntity.status(HttpStatus.OK).body("seccion ["+ id +"] actualizada correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			seService.delete(id);
			logger.info("seccion id["+id+"] eliminada", id);
			return ResponseEntity.status(HttpStatus.OK).body("seccion ["+ id +"] eliminada satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}