package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;

import java.util.HashSet;
import java.util.Optional;

public interface IEletrodomesticoRepository {

    public HashSet<Eletrodomestico> findAll();
    public Optional<Eletrodomestico> findById(Long id);
    public Eletrodomestico save(Eletrodomestico e);
    public Eletrodomestico update(Eletrodomestico e);
    public void delete(Long id);
}
