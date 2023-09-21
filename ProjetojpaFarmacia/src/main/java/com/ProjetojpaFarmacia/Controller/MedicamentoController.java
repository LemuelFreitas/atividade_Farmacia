package com.ProjetojpaFarmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetojpaFarmacia.Services.MedicamentoService;
import com.ProjetojpaFarmacia.entities.Medicamento;



@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {
	private final MedicamentoService MedicamentoService;

	@Autowired
	public MedicamentoController(MedicamentoService medicamentoService) {
		this.MedicamentoService = medicamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> buscaMedicamentoControlId(@PathVariable long id) {
		Medicamento medicamento = MedicamentoService.buscaMedicamentoId(id);
		if (medicamento != null)
			return ResponseEntity.ok(medicamento);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> buscaTodosMedicamentoControl() {
		List<Medicamento> Medicamento = MedicamentoService.buscaTodosMedicamento();
		return ResponseEntity.ok(Medicamento);
	}

	@PostMapping("/")
	public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento) {
		Medicamento salvaMedicamento = MedicamentoService.salvaMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> alteraMedicamentoControl(@PathVariable long id, @RequestBody Medicamento medicamento) {
		Medicamento alteraMedicamento = MedicamentoService.alterarMedicamento(id, medicamento);
		if (alteraMedicamento != null) {
			return ResponseEntity.ok(medicamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaMedicamentoControl(@PathVariable long id) {
		boolean apagar = MedicamentoService.apagarMedicamento(id);
		if (apagar) {
			return ResponseEntity.ok().body("o Medicamento foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
