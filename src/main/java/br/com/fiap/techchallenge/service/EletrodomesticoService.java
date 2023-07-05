package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.EletrodomesticoDTO;
import br.com.fiap.techchallenge.entity.Eletrodomestico;
import br.com.fiap.techchallenge.repository.IEletrodomesticoRepository;
import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class EletrodomesticoService {

    @Autowired
    private IEletrodomesticoRepository repo;

    public Page<EletrodomesticoDTO> findAll(PageRequest pageRequest) {

        var buscaEletrodomestico = repo.findAll(pageRequest);
        return buscaEletrodomestico.map(EletrodomesticoDTO::new);
    }

    public EletrodomesticoDTO findById(UUID id) {
        var buscaEletrodomestico = repo.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Pessoa não encontrada"));
        return new EletrodomesticoDTO(buscaEletrodomestico);
    }


    public EletrodomesticoDTO save(EletrodomesticoDTO eletrodomestico) {
        Eletrodomestico salvaEletrodomestico = new Eletrodomestico()
                .setModelo(eletrodomestico.getModelo())
                .setWatts(eletrodomestico.getWatts())
                .setNome(eletrodomestico.getNome());
       salvaEletrodomestico = repo.save(salvaEletrodomestico);
       return new EletrodomesticoDTO(salvaEletrodomestico);
    }

    public EletrodomesticoDTO update(UUID id, EletrodomesticoDTO eletrodomestico) {
        try {
            var buscaEletrodomestico = repo.getReferenceById(id);
            buscaEletrodomestico
                    .setNome(eletrodomestico.getNome())
                    .setModelo(eletrodomestico.getModelo())
                    .setWatts(eletrodomestico.getWatts());
            buscaEletrodomestico = repo.save(buscaEletrodomestico);
            return new EletrodomesticoDTO(buscaEletrodomestico);
        } catch (EntityNotFoundException exception){
            throw new ControllerNotFoundException("Pessoa não encontrada pelo id: " + id);
        }

    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
