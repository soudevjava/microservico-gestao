package br.com.projetofaculdade.gestao.resources;

import java.util.List;
import java.util.Optional;

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

import br.com.projetofaculdade.gestao.entities.CargoModel;
import br.com.projetofaculdade.gestao.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	public CargoService cargoService;

	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	@GetMapping
	private ResponseEntity<List<CargoModel>> listaDeCargos() {
		return ResponseEntity.status(HttpStatus.OK).body(cargoService.findAll());
	}

	@PostMapping
	private ResponseEntity<CargoModel> criar(@RequestBody CargoModel cargoModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.insert(cargoModel));
	}

	@GetMapping("/{id}")
	private ResponseEntity<Object> findById(@PathVariable Integer id) {
		Optional<CargoModel> optional = cargoService.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo " + id + " Não encontrado!");
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Object> delete(@PathVariable Integer id) {
		Optional<CargoModel> optional = cargoService.findById(id);
		if (optional.isPresent()) {
			cargoService.delete(optional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Deletado com Sucesso!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo não encontrado!");

	}

	@PutMapping("/{id}")
	private ResponseEntity<CargoModel> update(@PathVariable Integer id, @RequestBody CargoModel cargoModel) {
		return ResponseEntity.status(HttpStatus.OK).body(cargoService.update(id, cargoModel));

	}

}
