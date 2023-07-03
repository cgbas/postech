package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;

@Repository
@Slf4j
public class EletrodomesticoRepository implements IEletrodomesticoRepository {

    private static final HashSet<Pessoa> eletrodomesticos = new HashSet<>();

    public HashSet<Pessoa> findAll(){
        log.info("Finding All" + eletrodomesticos);
        return eletrodomesticos;
    }

    public Optional<Pessoa> findById(Long id) {
        var eletrodomesticoById = eletrodomesticos.stream().filter(eletrodomestico -> eletrodomestico.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + eletrodomesticoById);
        return eletrodomesticoById;
    }

    public Pessoa save(Pessoa e) {
        e.setId(eletrodomesticos.size() + 1L);
        log.info("Saving: " +  e);
        eletrodomesticos.add(e);
        return e;
    }

    public Pessoa update(Pessoa eletrodomestico) {
        Pessoa eletrodomesticoUpdate = this.findById(eletrodomestico.getId()).get();
        eletrodomesticoUpdate.setNome(eletrodomestico.getNome()).setModelo(eletrodomestico.getModelo()).setWatts(eletrodomestico.getWatts());
        log.info("Updating: " +  eletrodomesticoUpdate);
        return eletrodomesticoUpdate;
    }

    public void delete(Long id) {
        log.info("Deleting ID: " + id);
        eletrodomesticos.removeIf(eletrodomestico -> eletrodomestico.getId().equals(id));
    }

}
