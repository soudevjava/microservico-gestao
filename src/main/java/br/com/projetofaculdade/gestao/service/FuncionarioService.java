package br.com.projetofaculdade.gestao.service;

import br.com.projetofaculdade.gestao.dto.FuncionarioDto;
import br.com.projetofaculdade.gestao.entities.Funcionario;
import br.com.projetofaculdade.gestao.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    public final FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDto> findAll(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }
    public FuncionarioDto findById(Integer id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o id: " + id));
        return new FuncionarioDto(funcionario);
    }
    public void deleteById(Integer id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o id: " + id));
        funcionarioRepository.delete(funcionario);
    }

    public Funcionario update(Integer id, FuncionarioDto funcionarioDto) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o id: " + id));

        funcionario.setName(funcionarioDto.getName());
        funcionario.setEmail(funcionarioDto.getEmail());
        funcionario.setDepartamento(funcionarioDto.getDepartamento());

        return funcionarioRepository.save(funcionario);
    }
    public  Funcionario insert(Funcionario obj){
        return funcionarioRepository.save(obj);
    }




}
