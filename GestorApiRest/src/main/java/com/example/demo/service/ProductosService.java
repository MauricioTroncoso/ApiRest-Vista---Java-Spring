package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.producto;
import com.example.demo.repository.ProductosRepository;




@Service
public class ProductosService {

@Autowired
private ProductosRepository proRepo;

Logger logger = LogManager.getLogger(ProductosService.class);

public producto create(producto pro) {
	return proRepo.save(pro);
}

public List<producto> getAllUsers(){
	return proRepo.findAll();
}
public void delete(Long id) {
	proRepo.deleteById(id);
}
public Optional<producto> search(Long id){
	return proRepo.findById(id);
}
public void update(producto pro) {
	proRepo.updatecategoria(pro.getNombre(), pro.getValor(),pro.getStock(),pro.getId());
}


}