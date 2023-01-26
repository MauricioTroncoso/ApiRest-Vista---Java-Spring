package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.producto;

@Repository
public interface ProductosRepository extends JpaRepository<producto,Long>{
	@Transactional
	@Modifying
	@Query("UPDATE producto SET nombre_producto = :nombre, precio= :valor, stock= :stock WHERE id = :id")
	int updatecategoria(@Param("nombre") String nombre,
						@Param("valor") int valor,
						@Param("stock") int stock,
						@Param("id") Long id);
}
