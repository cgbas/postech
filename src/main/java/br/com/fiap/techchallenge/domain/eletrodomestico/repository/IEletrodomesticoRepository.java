package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

public interface IEletrodomesticoRepository {

    HashSet<Eletrodomestico> findAll();
    Optional<Eletrodomestico> findById(UUID id);
    Eletrodomestico save(Eletrodomestico e);
    Eletrodomestico update(Eletrodomestico e);
    void delete(UUID id);
}
