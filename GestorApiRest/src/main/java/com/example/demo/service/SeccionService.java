package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.seccion;
import com.example.demo.repository.SeccionRepository;




@Service
public class SeccionService {

@Autowired
private SeccionRepository seRepo;

Logger logger = LogManager.getLogger(CategoriaService.class);
public seccion create(seccion se) {
	return seRepo.save(se);
}

public List<seccion> getAllUsers(){
	return seRepo.findAll();
}
public void delete(Long id) {
	seRepo.deleteById(id);
}
public Optional<seccion> search(Long id){
	return seRepo.findById(id);
}
public void update(seccion se) {
	seRepo.updatecategoria(se.getNombre(),se.getId());
}


}
