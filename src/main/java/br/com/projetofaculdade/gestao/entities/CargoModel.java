package br.com.projetofaculdade.gestao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cargo")
public class CargoModel {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idCargo;
    @Column(name = "nome_Cargo")
    private String nomeCargo;
    @Column(name = "salario_Base")
    private BigDecimal salarioBase;
    @ManyToMany(mappedBy = "cargo")
    @JsonIgnore
    private Set<Funcionario> listFuncionarios;//= new HashSet<>();


}
