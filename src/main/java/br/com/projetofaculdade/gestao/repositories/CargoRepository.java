package br.com.projetofaculdade.gestao.repositories;

import br.com.projetofaculdade.gestao.entities.Cargo;
import br.com.projetofaculdade.gestao.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
