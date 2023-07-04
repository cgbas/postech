package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class EletrodomesticoRepository implements IEletrodomesticoRepository {

    private static final LinkedHashSet<Eletrodomestico> eletrodomesticos = new LinkedHashSet<>();

    public HashSet<Eletrodomestico> findAll(){
        log.info("Finding All" + eletrodomesticos);
        return eletrodomesticos;
    }

    public Optional<Eletrodomestico> findById(UUID id) {
        var eletrodomesticoById = eletrodomesticos.stream().filter(eletrodomestico -> eletrodomestico.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + eletrodomesticoById);
        return eletrodomesticoById;
    }

    public Eletrodomestico save(Eletrodomestico e) {
        e.setId(UUID.randomUUID());
        log.info("Saving: " +  e);
        eletrodomesticos.add(e);
        return e;
    }

    public Eletrodomestico update(Eletrodomestico eletrodomestico) {
        Eletrodomestico eletrodomesticoUpdate = this.findById(eletrodomestico.getId()).get();
        log.info("Updating: " +  eletrodomesticoUpdate);
        eletrodomesticoUpdate
                .setNome(eletrodomestico.getNome())
                .setModelo(eletrodomestico.getModelo())
                .setWatts(eletrodomestico.getWatts());

        return eletrodomesticoUpdate;
    }

    public void delete(UUID id) {
        log.info("Deleting ID: " + id);
        eletrodomesticos.removeIf(eletrodomestico -> eletrodomestico.getId().equals(id));
    }

}
