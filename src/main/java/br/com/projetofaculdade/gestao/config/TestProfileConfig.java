package br.com.projetofaculdade.gestao.config;

import br.com.projetofaculdade.gestao.entities.CargoModel;
import br.com.projetofaculdade.gestao.entities.Funcionario;
import br.com.projetofaculdade.gestao.repositories.CargoRepository;
import br.com.projetofaculdade.gestao.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestProfileConfig implements CommandLineRunner {

    private final FuncionarioRepository funcionarioRepository;

    private final CargoRepository cargoRepository;

    @Override
    public void run(String... args) throws Exception {
        LocalDate localDate = LocalDate.now();
        Funcionario funcionario = new Funcionario(null, "Rafael", "@gmail.com", localDate, "aaa", "aaa",null);
        CargoModel diretor = new CargoModel(null, "Diretor", BigDecimal.valueOf(10000), null);

        cargoRepository.save(diretor);

        List<CargoModel> cargoList = new ArrayList<>();
        cargoList.add(diretor);
        funcionario.setCargo(cargoList);
        funcionarioRepository.save(funcionario);
    }
}
