package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.seccion;

@Repository
public interface SeccionRepository extends JpaRepository<seccion,Long>{
	@Transactional
	@Modifying
	@Query("UPDATE seccion SET nombre_seccion = :nombre WHERE id = :id")
	int updatecategoria(@Param("nombre") String nombre,
						@Param("id") Long id);
}
