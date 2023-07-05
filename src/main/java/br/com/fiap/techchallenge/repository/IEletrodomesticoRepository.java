package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entity.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IEletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {}
