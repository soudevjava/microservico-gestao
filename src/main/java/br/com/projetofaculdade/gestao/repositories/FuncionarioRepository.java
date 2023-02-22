package br.com.projetofaculdade.gestao.repositories;

import br.com.projetofaculdade.gestao.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
