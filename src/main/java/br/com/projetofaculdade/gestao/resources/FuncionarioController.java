package br.com.projetofaculdade.gestao.resources;

import br.com.projetofaculdade.gestao.dto.FuncionarioDto;
import br.com.projetofaculdade.gestao.entities.Funcionario;
import br.com.projetofaculdade.gestao.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> findAll(){
        List<FuncionarioDto> funcionariosAchados = funcionarioService.findAll();
        return ResponseEntity.ok(funcionariosAchados);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDto> findById(@PathVariable Integer id){
        FuncionarioDto funcionarioAchado = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionarioAchado);
    }

    @PostMapping
    public ResponseEntity<Funcionario> insert(@RequestBody Funcionario obj){
        Funcionario funcionario = funcionarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFuncionario()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Integer id,@RequestBody FuncionarioDto funcionarioDto){
        Funcionario funcionarioAtualizado = funcionarioService.update(id, funcionarioDto);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

}
