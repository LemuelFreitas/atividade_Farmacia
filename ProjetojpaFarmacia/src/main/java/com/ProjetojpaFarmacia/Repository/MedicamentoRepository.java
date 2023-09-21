package com.ProjetojpaFarmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaFarmacia.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}