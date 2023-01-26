package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.oferta;

@Repository
public interface OfertaRepository extends JpaRepository<oferta,Long>{
	@Transactional
	@Modifying
	@Query("UPDATE oferta SET nombre_oferta = :nombre WHERE id = :id")
	int updatecategoria(@Param("nombre") String nombre,
						@Param("id") Long id);
}
