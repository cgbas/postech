package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IPessoaRepository extends JpaRepository<Pessoa, UUID> {

}
