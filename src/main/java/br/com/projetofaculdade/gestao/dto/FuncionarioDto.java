package br.com.projetofaculdade.gestao.dto;

import br.com.projetofaculdade.gestao.entities.CargoModel;
import br.com.projetofaculdade.gestao.entities.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class FuncionarioDto {

    private String name;
    private String email;
    private String departamento;


    public Funcionario converterParaFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setName(this.name);
        funcionario.setEmail(this.email);
        funcionario.setDepartamento(this.departamento);
        return funcionario;
    }

    public FuncionarioDto(Funcionario funcionario) {
        name = funcionario.getName();
        email = funcionario.getEmail();
        departamento = funcionario.getDepartamento();
    }

}
