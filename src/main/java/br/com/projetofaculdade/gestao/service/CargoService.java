package br.com.projetofaculdade.gestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetofaculdade.gestao.entities.CargoModel;
import br.com.projetofaculdade.gestao.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	public CargoRepository cargoRepository;

	public void Cargoservice(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public List<CargoModel> findAll() {
		return cargoRepository.findAll();
	}

	public CargoModel insert(CargoModel cargoModel) {
		return cargoRepository.save(cargoModel);
	}

	public Optional<CargoModel> findById(Integer id) {
		return cargoRepository.findById(id);																		
	}

	public void delete(CargoModel cargoModel) {						
		cargoRepository.delete(cargoModel);
	}

	public CargoModel update(Integer id, CargoModel newCargoModel) {
		CargoModel cargoModel = cargoRepository.findById(id).get();
		cargoModel.setNomeCargo(newCargoModel.getNomeCargo());
		cargoModel.setSalarioBase(newCargoModel.getSalarioBase());
		return cargoRepository.save(cargoModel);
	}

}
