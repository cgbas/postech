package br.com.fiap.techchallenge.domain.eletrodomestico.service;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import br.com.fiap.techchallenge.domain.eletrodomestico.repository.IEletrodomesticoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class EletrodomesticoService {

    @Autowired
    private IEletrodomesticoRepository service;

    public Collection<Eletrodomestico> findAll() {
        return service.findAll();
    }

    public Optional<Eletrodomestico> findById(UUID id) {
        Optional<Eletrodomestico> eletrodomesticoBuscado = service.findById(id);
        if (eletrodomesticoBuscado.isPresent()) {
            Eletrodomestico eletrodomestico = eletrodomesticoBuscado.get();
            return Optional.of(eletrodomestico);
        }
        log.error("Eletrodomestico não encontrado.");
        return Optional.empty();
    }


    public Eletrodomestico save(Eletrodomestico eletrodomestico) {
        return service.save(eletrodomestico);
    }

    public Eletrodomestico update(UUID id, Eletrodomestico eletrodomestico) {
        var buscaEletrodomestico = service.getReferenceById(id);
        buscaEletrodomestico
                .setNome(eletrodomestico.getNome())
                .setModelo(eletrodomestico.getModelo())
                .setWatts(eletrodomestico.getWatts());
        buscaEletrodomestico = service.save(buscaEletrodomestico);
        return buscaEletrodomestico;
    }

    public void delete(UUID id) {
        service.deleteById(id);
    }
}
