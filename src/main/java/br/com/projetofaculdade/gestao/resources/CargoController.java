package br.com.projetofaculdade.gestao.resources;

import br.com.projetofaculdade.gestao.entities.Cargo;
import br.com.projetofaculdade.gestao.service.CargoService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    public CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    private ResponseEntity<List<Cargo>> listaDeCargos() {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Cargo> criar(@RequestBody Cargo cargo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.insert(cargo));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> findById(@PathVariable Integer id) {
        Optional<Cargo> optional = cargoService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo " + id + " Não encontrado!");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Optional<Cargo> optional = cargoService.findById(id);
            if (optional.isPresent()) {
                cargoService.delete(optional.get());
                return ResponseEntity.status(HttpStatus.OK).body("Deletado com Sucesso!");
            }
        } catch (DataIntegrityViolationException e) {
            System.out.println("Criar LOGS aqui");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Você não pode deletar Cargos que possuam funcionarios!");
        }
        System.out.println("Criar LOGS aqui");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo não encontrado!");

    }

    @PutMapping("/{id}")
    private ResponseEntity<Cargo> update(@PathVariable Integer id, @RequestBody Cargo cargo) {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.update(id, cargo));

    }

}
