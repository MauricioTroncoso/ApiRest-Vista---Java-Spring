package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.distribuidor;

@Repository
public interface DistribuidorRepository extends JpaRepository<distribuidor,Long>{
	@Transactional
	@Modifying
	@Query("UPDATE distribuidor SET nombre_distribuidor = :nombre WHERE id = :id")
	int updatecategoria(@Param("nombre") String nombre,
						@Param("id") Long id);
}
