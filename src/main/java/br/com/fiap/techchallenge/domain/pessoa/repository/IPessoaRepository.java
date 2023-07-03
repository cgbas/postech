package br.com.fiap.techchallenge.domain.pessoa.repository;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;

import java.util.HashSet;
import java.util.Optional;

public interface IPessoaRepository {
    public HashSet<Pessoa> findAll();
    public Optional<Pessoa> findById(Long id);

    public Pessoa save(Pessoa p);
    public Optional<Pessoa> update(Pessoa p);

    public void delete(Long id);

}
