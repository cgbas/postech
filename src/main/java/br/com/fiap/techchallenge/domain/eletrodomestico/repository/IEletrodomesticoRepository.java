package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Pessoa;

import java.util.HashSet;
import java.util.Optional;

public interface IEletrodomesticoRepository {

    HashSet<Pessoa> findAll();
    Optional<Pessoa> findById(Long id);
    Pessoa save(Pessoa e);
    Pessoa update(Pessoa e);
    void delete(Long id);
}
