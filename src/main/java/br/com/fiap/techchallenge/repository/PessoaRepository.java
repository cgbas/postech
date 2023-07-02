package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PessoaRepository {

    static private Set<Pessoa> pessoas = new LinkedHashSet<Pessoa>();

    static {

        Pessoa p1 = new Pessoa();
        p1.setNome("Benefrancis do Nascimento").setDataDeNascimento(LocalDate.of(1977, 3, 8));

        Pessoa p2 = new Pessoa();
        p2.setNome("Bruno Sudré do Nascimento").setDataDeNascimento(LocalDate.of(2000, 5, 15));

        save(p1);
        save(p2);
    }

    public Collection<Pessoa> findAll() {
        return pessoas;
    }
    public Optional<Pessoa> findById(Long id) {
      return pessoas.stream().filter(p -> p.id().equals(id)).findFirst();
    }

    public static Pessoa save(Pessoa p) {
        p.setId(pessoas.size() + 1L);
        pessoas.add(p);
        return p;
    }


    public Optional<Pessoa> update(Pessoa p) {
        Optional<Pessoa> pessoaBuscada = this.findById(p.id());

        if (pessoaBuscada.isPresent()) {
            Pessoa pessoa  = pessoaBuscada.get();
            pessoa.
                    setNome(p.nome()).
                    setSexo(p.sexo()).
                    setParentesco(p.parentesco()).
                    setDataDeNascimento(p.dataDeNascimento());
        }

        return  Optional.empty();
    }

    public void delete(Long id) {
        pessoas.removeIf(pessoa -> pessoa.id().equals(id));
    }
}
