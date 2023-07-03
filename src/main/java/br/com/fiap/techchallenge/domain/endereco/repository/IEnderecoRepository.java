package br.com.fiap.techchallenge.domain.endereco.repository;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;

import java.util.HashSet;
import java.util.Optional;

public interface IEnderecoRepository {
    public HashSet<Endereco> findAll();
    public Optional<Endereco> findById(Long id);
    public Endereco save(Endereco e);
    public Optional<Endereco> update(Endereco e);
    public void delete(Long id);
}
