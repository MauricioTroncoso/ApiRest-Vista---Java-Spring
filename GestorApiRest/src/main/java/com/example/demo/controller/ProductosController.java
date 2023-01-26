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

import com.example.demo.entity.producto;
import com.example.demo.service.ProductosService;



@RestController
@RequestMapping("api/producto")
public class ProductosController {
	
	@Autowired
	private ProductosService proService;
	Logger logger = LogManager.getLogger(ProductosController.class);
	
	//Crear
	@PostMapping
	public ResponseEntity<producto> create (@RequestBody producto newpro){

		try {
			producto pro = proService.create(newpro);
			logger.info("producto creado", pro);
			return ResponseEntity.created(new URI("producto" + pro.getId())).body(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	//Leer 
	@GetMapping
	public ResponseEntity<List<producto>> index(){
		return ResponseEntity.ok(proService.getAllUsers());	
	}
	
	//Leer por ID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<producto>> read (@PathVariable(value= "id") Long id){
		logger.info("Mostrando producto ["+ id +"]");
		return ResponseEntity.ok(proService.search(id));
	}
	
	//Actualizar  por ID
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable(value= "id") Long id, @RequestBody producto pro){
		try {
			pro.setId(id);
			proService.update(pro);
			logger.info("producto Id["+id+"] actualizado", pro);
			return ResponseEntity.status(HttpStatus.OK).body("producto ["+ id +"] actualizado correctamete");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Borrar por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(value= "id") Long id){
		try {
			proService.delete(id);
			logger.info("producto id["+id+"] eliminado", id);
			return ResponseEntity.status(HttpStatus.OK).body("producto ["+ id +"] eliminado satisfactoriamente");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
