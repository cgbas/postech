package br.com.fiap.techchallenge.domain.pessoa.repository;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;

import java.util.HashSet;
import java.util.Optional;

public interface IPessoaRepository {
    HashSet<Pessoa> findAll();
    Optional<Pessoa> findById(Long id);

    Pessoa save(Pessoa p);
    Pessoa update(Pessoa p);

    void delete(Long id);

}
