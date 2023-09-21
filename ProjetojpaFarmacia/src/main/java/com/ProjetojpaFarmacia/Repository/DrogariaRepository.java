package com.ProjetojpaFarmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaFarmacia.entities.Drogaria;

public interface DrogariaRepository extends JpaRepository<Drogaria, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}