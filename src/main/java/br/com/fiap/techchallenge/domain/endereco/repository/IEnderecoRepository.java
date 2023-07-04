package br.com.fiap.techchallenge.domain.endereco.repository;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

public interface IEnderecoRepository {
    HashSet<Endereco> findAll();
    Optional<Endereco> findById(UUID id);
    Endereco save(Endereco e);
    Endereco update(Endereco e);
    void delete(UUID id);
}
