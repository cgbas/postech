package br.com.fiap.techchallenge.domain.pessoa.repository;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@Slf4j
public class PessoaRepository implements IPessoaRepository {

    private static final HashSet<Pessoa> pessoas = new HashSet<>();

    public HashSet<Pessoa> findAll() {
        log.info("Finding All" + pessoas);
        return pessoas;
    }

    public Optional<Pessoa> findById(Long id) {
        var pessoaById = pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + pessoaById);
        return pessoaById;
    }

    public Pessoa save(Pessoa pessoa) {
        pessoa.setId(pessoas.size() + 1L);
        log.info("Saving: " +  pessoa);
        pessoas.add(pessoa);
        return pessoa;
    }

    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaUpdate = this.findById(pessoa.getId()).get();
        log.info("Updating: " +  pessoaUpdate);
        pessoaUpdate
                .setNome(pessoa.getNome())
                .setSexo(pessoa.getSexo())
                .setParentesco(pessoa.getParentesco())
                .setDataDeNascimento(pessoa.getDataDeNascimento());

        return pessoaUpdate;
    }

    public void delete(Long id) {
        log.info("Deleting ID: " + id);
        pessoas.removeIf(pessoa -> pessoa.getId().equals(id));
    }
}
