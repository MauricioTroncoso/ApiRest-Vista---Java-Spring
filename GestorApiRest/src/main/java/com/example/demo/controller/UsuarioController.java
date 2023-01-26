package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")

public class UsuarioController {
	@Autowired
	private UsuarioService userService;
	@PostMapping
	public ResponseEntity<usuario> create (@RequestBody usuario newuser){
		return null;
	}
	@GetMapping("get/usuario/{user}/{pass}")
	public String getrole(@PathVariable String user,@PathVariable String pass) {
	 return userService.getrol(user, pass);
		
	}
}

