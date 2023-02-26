package br.com.projetofaculdade.gestao.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonProperty("id_funcionario")
    private Integer idFuncionario;
    private String name;
    private String email;
    @Column(name = "dt_de_nascimento")
    @JsonProperty("dt_de_nascimento")
    private LocalDate dtDeNascimento;
    private String departamento;
    private String endereco;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_funcionario_cargo", joinColumns = @JoinColumn(name = "idFuncionario"), inverseJoinColumns = @JoinColumn(name = "idCargo"))
    private List<CargoModel> cargo;// = new ArrayList<>();

}
