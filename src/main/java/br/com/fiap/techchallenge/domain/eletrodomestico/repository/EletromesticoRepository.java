package br.com.fiap.techchallenge.domain.eletrodomestico.repository;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import br.com.fiap.techchallenge.domain.endereco.repository.IEnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;

@Repository
@Slf4j
public class EletromesticoRepository implements IEletrodomesticoRepository {

    private static HashSet<Eletrodomestico> eletrodomesticos = new HashSet<Eletrodomestico>();

    public HashSet<Eletrodomestico> findAll(){
        log.info(eletrodomesticos.toString());
        return eletrodomesticos;
    }

    public Optional<Eletrodomestico> findById(Long id) {
        var eletrodomesticoById = eletrodomesticos.stream().filter(e -> e.equals(id)).findFirst();
        log.info("findById: " + eletrodomesticoById);
        return eletrodomesticoById;
    }

    public  Eletrodomestico save(Eletrodomestico e) {
        e.setId(eletrodomesticos.size() + 1L);
        eletrodomesticos.add(e);
        log.info("save: " +  e);
        return e;
    }

    public Optional<Eletrodomestico> update(Eletrodomestico e) {
        Optional<Eletrodomestico> eletrodomesticoOptional = this.findById(e.getId());

        if (eletrodomesticoOptional.isPresent()) {
            Eletrodomestico eletrodomestico = eletrodomesticoOptional.get()
                    .setNome(e.getNome())
                    .setModelo(e.getModelo())
                    .setWatts(e.getWatts());

            return Optional.of(eletrodomestico);
        }

        return Optional.empty();

    }

    public void delete(Long id) {
        eletrodomesticos.remove(id);
    }

}
