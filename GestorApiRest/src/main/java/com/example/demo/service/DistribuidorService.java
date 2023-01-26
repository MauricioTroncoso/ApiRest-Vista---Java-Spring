package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.distribuidor;
import com.example.demo.repository.DistribuidorRepository;




@Service
public class DistribuidorService {

@Autowired
private DistribuidorRepository disRepo;

Logger logger = LogManager.getLogger(DistribuidorService.class);

public distribuidor create(distribuidor dis) {
	return disRepo.save(dis);
}

public List<distribuidor> getAllUsers(){
	return disRepo.findAll();
}
public void delete(Long id) {
	disRepo.deleteById(id);
}
public Optional<distribuidor> search(Long id){
	return disRepo.findById(id);
}
public void update(distribuidor dis) {
	disRepo.updatecategoria(dis.getNombre(),dis.getId());
}


}
