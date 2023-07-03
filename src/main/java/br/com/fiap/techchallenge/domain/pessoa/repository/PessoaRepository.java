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
        log.info(pessoas.toString());
        return pessoas;
    }

    public Optional<Pessoa> findById(Long id) {
        var pessoaById = pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
        log.info(pessoaById.toString());
        return pessoaById;
    }

    public Pessoa save(Pessoa p) {
        p.setId(pessoas.size() + 1L);
        pessoas.add(p);
        return p;
    }

    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaUpdate = this.findById(pessoa.getId()).get();
        pessoaUpdate.setNome(pessoa.getNome()).setSexo(pessoa.getSexo()).setParentesco(pessoa.getParentesco()).setDataDeNascimento(pessoa.getDataDeNascimento());
        return pessoaUpdate;
    }

    public void delete(Long id) {
        pessoas.removeIf(pessoa -> pessoa.getId().equals(id));
    }
}
