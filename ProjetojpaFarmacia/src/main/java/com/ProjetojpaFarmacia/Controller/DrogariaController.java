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

import com.ProjetojpaFarmacia.Services.DrogariaService;
import com.ProjetojpaFarmacia.entities.Drogaria;



@RestController
@RequestMapping("/Drogaria")
public class DrogariaController {
	private final DrogariaService DrogariaService;

	@Autowired
	public DrogariaController(DrogariaService drogariaService) {
		this.DrogariaService = drogariaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> buscaDrogariaControlId(@PathVariable long id) {
		Drogaria drogaria = DrogariaService.buscaDrogariaId(id);
		if (drogaria != null)
			return ResponseEntity.ok(drogaria);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> buscaTodosDrogariaControl() {
		List<Drogaria> Drogaria = DrogariaService.buscaTodosDrogaria();
		return ResponseEntity.ok(Drogaria);
	}

	@PostMapping("/")
	public ResponseEntity<Drogaria> salvaDrogariaControl(@RequestBody Drogaria drogaria) {
		Drogaria salvaDrogaria = DrogariaService.salvaDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDrogaria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> alteraDrogariaControl(@PathVariable long id, @RequestBody Drogaria drogaria) {
		Drogaria alteraDrogaria = DrogariaService.alterarDrogaria(id, drogaria);
		if (alteraDrogaria != null) {
			return ResponseEntity.ok(drogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaDrogariaControl(@PathVariable long id) {
		boolean apagar = DrogariaService.apagarDrogaria(id);
		if (apagar) {
			return ResponseEntity.ok().body("a Drogaria foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
