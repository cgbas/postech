package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.entity.Pessoa;
import br.com.fiap.techchallenge.repository.IPessoaRepository;
import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private IPessoaRepository repo;

    public Collection<Pessoa> findAll(){
        return repo.findAll();
    }

    public Pessoa findById(UUID id){
       return repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
    }

    public Pessoa save(Pessoa pessoa){

        return  repo.save(pessoa);
    }

    public Pessoa update(UUID id, Pessoa pessoa) {
        try {
            var buscaPessoa = repo.getReferenceById(id);
            buscaPessoa
                    .setNome(pessoa.getNome())
                    .setSexo(pessoa.getSexo())
                    .setParentesco(pessoa.getParentesco())
                    .setDataDeNascimento(pessoa.getDataDeNascimento());

            buscaPessoa = repo.save(buscaPessoa);
            return buscaPessoa;
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Produto não encontrado pelo id: " + id);
        }
    }


    public void delete(UUID id) {
      repo.deleteById(id);
    }
}
