package br.com.projetofaculdade.gestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetofaculdade.gestao.entities.Cargo;
import br.com.projetofaculdade.gestao.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	public CargoRepository cargoRepository;

	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	public Cargo insert(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	public Optional<Cargo> findById(Integer id) {
		return cargoRepository.findById(id);																		
	}

	public void delete(Cargo cargo) {
		cargoRepository.delete(cargo);
	}

	public Cargo update(Integer id, Cargo newCargo) {
		Cargo cargo = cargoRepository.findById(id).get();
		cargo.setNomeCargo(newCargo.getNomeCargo());
		cargo.setSalarioBase(newCargo.getSalarioBase());
		return cargoRepository.save(cargo);
	}

}
