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


import com.example.demo.entity.distribuidor;
import com.example.demo.service.DistribuidorService;



@RestController
@RequestMapping("api/distribuidor")
public class DistribuidorController {
	
	@Autowired
	private DistribuidorService disService;
	Logger logger = LogManager.getLogger(DistribuidorController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<distribuidor> create (@RequestBody distribuidor newdis){

		try {
			distribuidor dis = disService.create(newdis);
			logger.info("distribuidor creado", dis);
			return ResponseEntity.created(new URI("distribuidor" + dis.getId())).body(dis);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<distribuidor>> index(){
		return ResponseEntity.ok(disService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<distribuidor>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando distribuidor ["+ id +"]");
		return ResponseEntity.ok(disService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody distribuidor dis){
		try {
			dis.setId(id);
			disService.update(dis);
			logger.info("Distribuidor Id["+id+"] actualizada", dis);
			return ResponseEntity.status(HttpStatus.OK).body("Distribuidor ["+ id +"] actualizado correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			disService.delete(id);
			logger.info("Distribuidor id["+id+"] eliminado", id);
			return ResponseEntity.status(HttpStatus.OK).body("Distribuidor ["+ id +"] eliminado satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}