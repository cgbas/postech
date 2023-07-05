package br.com.fiap.techchallenge.domain.pessoa.service;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import br.com.fiap.techchallenge.domain.pessoa.repository.IPessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private IPessoaRepository repo;

    public Collection<Pessoa> findAll(){
        return repo.findAll();
    }

    public Optional<Pessoa> findById(UUID id){
       return repo.findById(id);
    }

    public Pessoa save(Pessoa pessoa){

        return  repo.save(pessoa);
    }

    public Pessoa update(UUID id, Pessoa pessoa) {
        var buscaPessoa = repo.getReferenceById(id);
        buscaPessoa
                .setNome(pessoa.getNome())
                .setSexo(pessoa.getSexo())
                .setParentesco(pessoa.getParentesco())
                .setDataDeNascimento(pessoa.getDataDeNascimento());

         buscaPessoa = repo.save(buscaPessoa);
         return buscaPessoa;
    }


    public void delete(UUID id) {
      repo.deleteById(id);
    }
}
