package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.entity.Eletrodomestico;
import br.com.fiap.techchallenge.repository.IEletrodomesticoRepository;
import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@Service
public class EletrodomesticoService {

    @Autowired
    private IEletrodomesticoRepository service;

    public Collection<Eletrodomestico> findAll() {
        return service.findAll();
    }

    public Eletrodomestico findById(UUID id) {
        return service.findById(id).orElseThrow(() -> new ControllerNotFoundException("Pessoa não encontrada"));
    }


    public Eletrodomestico save(Eletrodomestico eletrodomestico) {
        return service.save(eletrodomestico);
    }

    public Eletrodomestico update(UUID id, Eletrodomestico eletrodomestico) {
        try {
            var buscaEletrodomestico = service.getReferenceById(id);
            buscaEletrodomestico
                    .setNome(eletrodomestico.getNome())
                    .setModelo(eletrodomestico.getModelo())
                    .setWatts(eletrodomestico.getWatts());
            buscaEletrodomestico = service.save(buscaEletrodomestico);
            return buscaEletrodomestico;
        } catch (EntityNotFoundException exception){
            throw new ControllerNotFoundException("Pessoa não encontrada pelo id: " + id);
        }

    }

    public void delete(UUID id) {
        service.deleteById(id);
    }
}
