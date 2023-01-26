package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.oferta;
import com.example.demo.repository.OfertaRepository;




@Service
public class OfertaService {

@Autowired
private OfertaRepository ofRepo;

Logger logger = LogManager.getLogger(CategoriaService.class);
public oferta create(oferta of) {
	return ofRepo.save(of);
}

public List<oferta> getAllUsers(){
	return ofRepo.findAll();
}
public void delete(Long id) {
	ofRepo.deleteById(id);
}
public Optional<oferta> search(Long id){
	return ofRepo.findById(id);
}
public void update(oferta of) {
	ofRepo.updatecategoria(of.getNombre(),of.getId());
}


}
