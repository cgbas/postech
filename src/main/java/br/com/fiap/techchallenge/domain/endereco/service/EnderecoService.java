package br.com.fiap.techchallenge.domain.endereco.service;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import br.com.fiap.techchallenge.domain.endereco.repository.IEnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository repo;

    public Collection<Endereco> findAll(){
        return repo.findAll();
    }

    public Optional<Endereco> findById(UUID id){
        return repo.findById(id);
    }

    public Endereco save(Endereco endereco){
        return  repo.save(endereco);
    }

    public Endereco update(UUID id, Endereco endereco) {
        var buscaEndereco = repo.getReferenceById(id);
        buscaEndereco
                .setLogradouro(endereco.getLogradouro())
                .setNumero(endereco.getNumero())
                .setBairro(endereco.getBairro())
                .setCidade(endereco.getCidade())
                .setEstado(endereco.getEstado());
        buscaEndereco = repo.save(buscaEndereco);
        return buscaEndereco;

    }


    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
