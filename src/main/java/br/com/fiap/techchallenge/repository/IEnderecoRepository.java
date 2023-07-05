package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IEnderecoRepository extends JpaRepository<Endereco, UUID> {}
