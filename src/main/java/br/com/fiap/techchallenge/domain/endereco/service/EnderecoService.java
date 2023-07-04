package br.com.fiap.techchallenge.domain.endereco.service;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import br.com.fiap.techchallenge.domain.endereco.repository.IEnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class EnderecoService {

    @Qualifier("enderecoRepository")
    @Autowired
    private IEnderecoRepository repo;

    public HashSet<Endereco> findAll(){
        return repo.findAll();
    }

    public Optional<Endereco> findById(UUID id){
        Optional<Endereco> enderecoBuscado = repo.findById(id);
        if (enderecoBuscado.isPresent()){
            Endereco endereco = enderecoBuscado.get();

            return Optional.of(endereco);
        }
        log.error("Endereço não encontrado.");
        return Optional.empty();
    }

    public Endereco save(Endereco endereco){
        return  repo.save(endereco);
    }

    public Optional<Endereco> update(Endereco endereco) {
        Optional<Endereco> enderecoBuscado = this.findById(endereco.getId());
        if (enderecoBuscado.isPresent()) {
            var enderecoAtualizado = repo.update(endereco);
            return Optional.of(enderecoAtualizado);
        }
        log.error("Endereço não encontrado");
        return Optional.empty();
    }


    public void delete(UUID id) {
        Optional<Endereco> enderecoDelete = this.findById(id);
        if (enderecoDelete.isPresent()){
            repo.delete(id);
        } else {
            log.error("Endereço não encontrado");
        }
    }
}
