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

import com.example.demo.entity.categoria;
import com.example.demo.service.CategoriaService;



@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	Logger logger = LogManager.getLogger(CategoriaController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<categoria> create (@RequestBody categoria newcat){

		try {
			categoria cat = catService.create(newcat);
			logger.info("Categoria creada", cat);
			return ResponseEntity.created(new URI("categoria" + cat.getId())).body(cat);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<categoria>> index(){
		return ResponseEntity.ok(catService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<categoria>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando Categoria ["+ id +"]");
		return ResponseEntity.ok(catService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody categoria cat){
		try {
			cat.setId(id);
			catService.update(cat);
			logger.info("Categoria Id["+id+"] actualizada", cat);
			return ResponseEntity.status(HttpStatus.OK).body("Categorira ["+ id +"] actualizada correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			catService.delete(id);
			logger.info("Categoria id["+id+"] eliminada", id);
			return ResponseEntity.status(HttpStatus.OK).body("Categoria ["+ id +"] eliminada satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
