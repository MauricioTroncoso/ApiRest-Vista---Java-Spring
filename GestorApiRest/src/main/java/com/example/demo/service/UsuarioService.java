package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.usuariorepository;

@Service
public class UsuarioService {

@Autowired
private usuariorepository userRepo;

public String getrol(String user, String pass) {
	return userRepo.findbyuserandpass(user, pass);
}

}

