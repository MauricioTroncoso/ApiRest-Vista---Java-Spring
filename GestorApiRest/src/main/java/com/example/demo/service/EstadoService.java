package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.estado;
import com.example.demo.repository.EstadoRepository;




@Service
public class EstadoService {

@Autowired
private EstadoRepository esRepo;

Logger logger = LogManager.getLogger(EstadoService.class);

public estado create(estado es) {
	return esRepo.save(es);
}

public List<estado> getAllUsers(){
	return esRepo.findAll();
}
public void delete(Long id) {
	esRepo.deleteById(id);
}
public Optional<estado> search(Long id){
	return esRepo.findById(id);
}
public void update(estado es) {
	esRepo.updatecategoria(es.getNombre(),es.getId());
}


}
