package com.ProjetojpaFarmacia.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaFarmacia.Repository.DrogariaRepository;
import com.ProjetojpaFarmacia.entities.Drogaria;



@Service
public class DrogariaService {
	private final DrogariaRepository DrogariaRepository;
	
	@Autowired
	public DrogariaService(DrogariaRepository DrogariaRepository) {
		this.DrogariaRepository = DrogariaRepository;
	}

	public List<Drogaria> buscaTodosDrogaria() {
		return DrogariaRepository.findAll();
	}

	public Drogaria buscaDrogariaId(long id) {
		Optional<Drogaria> drogaria = DrogariaRepository.findById(id);
		return drogaria.orElse(null);
	}

	
	public Drogaria salvaDrogaria(Drogaria drogaria) {
		return DrogariaRepository.save(drogaria);
	}

	public Drogaria alterarDrogaria(long id, Drogaria alterarDrog) {
		Optional<Drogaria> existeDrogaria = DrogariaRepository.findById(id);
		if (existeDrogaria.isPresent()) {
			alterarDrog.setId(id);
			return DrogariaRepository.save(alterarDrog);

		}
		return null;
	}
	public boolean apagarDrogaria(long id) {
		Optional<Drogaria> existeDrogaria = DrogariaRepository.findById(id);
		if (existeDrogaria.isPresent() ) {
			DrogariaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

