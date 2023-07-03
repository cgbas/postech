package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.domain.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@Slf4j
public class PessoaRepository {

    private HashSet<Pessoa> pessoas = new HashSet<Pessoa>();

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


    public Optional<Pessoa> update(Pessoa p) {
        Optional<Pessoa> pessoaOptional = findById(p.getId());

        if (pessoaOptional.isPresent()) {
            Pessoa pessoa  = pessoaOptional.get();
            pessoa.
                    setNome(p.getNome()).
                    setSexo(p.getSexo()).
                    setParentesco(p.getParentesco()).
                    setDataDeNascimento(p.getDataDeNascimento());

            return Optional.of(pessoa);
        }

        return  Optional.empty();
    }

    public void delete(Long id) {
        pessoas.remove(id);
    }
}
