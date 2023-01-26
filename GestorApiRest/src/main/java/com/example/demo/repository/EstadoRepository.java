package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.estado;

@Repository
public interface EstadoRepository extends JpaRepository<estado,Long>{
	@Transactional
	@Modifying
	@Query("UPDATE estado SET nombre_estado = :nombre WHERE id = :id")
	int updatecategoria(@Param("nombre") String nombre,
						@Param("id") Long id);
}
