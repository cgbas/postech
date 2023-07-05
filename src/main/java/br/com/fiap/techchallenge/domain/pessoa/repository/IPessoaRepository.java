package br.com.fiap.techchallenge.domain.pessoa.repository;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IPessoaRepository extends JpaRepository<Pessoa, UUID> {

}
