package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IEletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {}
