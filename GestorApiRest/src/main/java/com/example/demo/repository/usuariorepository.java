package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.usuario;

@Repository
public interface usuariorepository extends JpaRepository<usuario,Long>{

 public  usuario findByUser(String user); 
 
@Query(value="Select role FROM usuario WHERE user = :user and pass = :pass")
 	String findbyuserandpass(@Param("user") String user,@Param("pass") String pass);
}
