package br.com.fiap.techchallenge.domain.eletrodomestico.service;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Pessoa;
import br.com.fiap.techchallenge.domain.eletrodomestico.repository.IEletrodomesticoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
@Slf4j
@Service
public class EletrodomesticoService {


    @Qualifier("eletrodomesticoRepository")
    @Autowired
    private IEletrodomesticoRepository repo;

    public HashSet<Pessoa> findAll() {
        return repo.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        Optional<Pessoa> eletrodomesticoBuscado = repo.findById(id);
        if (eletrodomesticoBuscado.isPresent()) {
            Pessoa eletrodomestico = eletrodomesticoBuscado.get();
            return Optional.of(eletrodomestico);
        }
        log.error("Eletrodomestico não encontrado.");
        return Optional.empty();
    }


    public Pessoa save(Pessoa e) {
        return repo.save(e);
    }

    public Optional<Pessoa> update(Pessoa e) {
        Optional<Pessoa> eletrodomesticoBuscado = this.findById(e.getId());
        if (eletrodomesticoBuscado.isPresent()) {
           var eletrodomesticoAtualizado = repo.update(e);
           return Optional.of(eletrodomesticoAtualizado);
        }
        log.error("Eletrodomestico não encontrado.");
        return Optional.empty();
    }

    public void delete(Long id) {
        Optional<Pessoa> eletrodomesticoDelete = this.findById(id);
        if (eletrodomesticoDelete.isPresent()){
            repo.delete(id);
        } else {
            log.error("Eletrodomestico não encontrado");
        }

    }
}
