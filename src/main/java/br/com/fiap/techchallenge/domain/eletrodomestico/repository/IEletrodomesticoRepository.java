package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;

import java.util.HashSet;
import java.util.Optional;

public interface IEletrodomesticoRepository {

    HashSet<Eletrodomestico> findAll();
    Optional<Eletrodomestico> findById(Long id);
    Eletrodomestico save(Eletrodomestico e);
    Eletrodomestico update(Eletrodomestico e);
    void delete(Long id);
}
