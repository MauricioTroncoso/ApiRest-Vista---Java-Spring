package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.categoria;
import com.example.demo.repository.CategoriaRepository;




@Service
public class CategoriaService {

@Autowired
private CategoriaRepository catRepo;

Logger logger = LogManager.getLogger(CategoriaService.class);
public categoria create(categoria cat) {
	return catRepo.save(cat);
}

public List<categoria> getAllUsers(){
	return catRepo.findAll();
}
public void delete(Long id) {
	catRepo.deleteById(id);
}
public Optional<categoria> search(Long id){
	return catRepo.findById(id);
}
public void update(categoria cat) {
	catRepo.updatecategoria(cat.getNombre(),cat.getId());
}
public categoria save(categoria cat) {
	return catRepo.save(cat);	
	
}

}
