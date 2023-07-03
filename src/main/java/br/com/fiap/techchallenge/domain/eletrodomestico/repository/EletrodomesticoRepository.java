package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;

@Repository
@Slf4j
public class EletrodomesticoRepository implements IEletrodomesticoRepository {

    private static HashSet<Eletrodomestico> eletrodomesticos = new HashSet<Eletrodomestico>();

    public HashSet<Eletrodomestico> findAll(){
        log.info("Finding All");
        return eletrodomesticos;
    }

    public Optional<Eletrodomestico> findById(Long id) {
        var eletrodomesticoById = eletrodomesticos.stream().filter(e -> e.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + eletrodomesticoById.toString());
        return eletrodomesticoById;
    }

    public  Eletrodomestico save(Eletrodomestico e) {
        e.setId(eletrodomesticos.size() + 1L);
        eletrodomesticos.add(e);
        log.info("Saving: " +  e.toString());
        return e;
    }

    public Eletrodomestico update(Eletrodomestico eletrodomestico) {
        Eletrodomestico eletrodomesticoUpdate = this.findById(eletrodomestico.getId()).get();
        eletrodomesticoUpdate.setNome(eletrodomestico.getNome()).setModelo(eletrodomestico.getModelo()).setWatts(eletrodomestico.getWatts());
        log.info("Updating: " +  eletrodomesticoUpdate);
        return eletrodomesticoUpdate;
    }

    public void delete(Long id) {
        log.info("Deleting ID: " + id);
        eletrodomesticos.remove(id);
    }

}
