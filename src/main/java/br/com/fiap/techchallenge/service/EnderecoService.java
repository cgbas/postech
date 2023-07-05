package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.entity.Endereco;
import br.com.fiap.techchallenge.repository.IEnderecoRepository;
import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository repo;

    public Collection<Endereco> findAll(){
        return repo.findAll();
    }

    public Endereco findById(UUID id){
        return repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Endereço não encontrado."));
    }

    public Endereco save(Endereco endereco){
        return  repo.save(endereco);
    }

    public Endereco update(UUID id, Endereco endereco) {
        try {
            var buscaEndereco = repo.getReferenceById(id);
            buscaEndereco
                    .setLogradouro(endereco.getLogradouro())
                    .setNumero(endereco.getNumero())
                    .setBairro(endereco.getBairro())
                    .setCidade(endereco.getCidade())
                    .setEstado(endereco.getEstado());
            buscaEndereco = repo.save(buscaEndereco);
            return buscaEndereco;
        } catch(EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Endereço não encontrado.");
        }

    }


    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
