package com.ProjetojpaFarmacia.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaFarmacia.Repository.MedicamentoRepository;
import com.ProjetojpaFarmacia.entities.Medicamento;





@Service
public class MedicamentoService {
	private final MedicamentoRepository medicamentoRepository;
	
	@Autowired
	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	public List<Medicamento> buscaTodosMedicamento() {
		return medicamentoRepository.findAll();
	}

	public Medicamento buscaMedicamentoId(long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		return medicamento.orElse(null);
	}

	
	public Medicamento salvaMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	public Medicamento alterarMedicamento(long id, Medicamento alterarMedi) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			alterarMedi.setId(id);
			return medicamentoRepository.save(alterarMedi);

		}
		return null;
	}
	public boolean apagarMedicamento(long id) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent() ) {
			medicamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}


