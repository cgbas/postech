package br.com.fiap.techchallenge.domain.pessoa.service;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import br.com.fiap.techchallenge.domain.pessoa.repository.IPessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
@Slf4j
@Service
public class PessoaService {

    @Qualifier("pessoaRepository")
    @Autowired
    private IPessoaRepository repo;

    public HashSet<br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa> findAll(){
        return repo.findAll();
    }

    public Optional<br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa> findById(Long id){
        Optional<br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa> pessoaBuscada = repo.findById(id);
        if (pessoaBuscada.isPresent()){
            br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa pessoa = pessoaBuscada.get();

            return Optional.of(pessoa);
        }
        log.error("Pessoa não encontrada.");
        return Optional.empty();
    }

    public br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa save(br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa pessoa){
       return  repo.save(pessoa);
    }

    public Optional<br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa> update(br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa pessoa) {
        Optional<br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa> pessoaBuscada = this.findById(pessoa.getId());
        if (pessoaBuscada.isPresent()) {
            var pessoaAtualizada = repo.update(pessoa);
            return Optional.of(pessoaAtualizada);
        }
        log.error("Pessoa não encontrada.");
        return Optional.empty();
    }


    public void delete(Long id) {
        Optional<Pessoa> pessoaDelete = this.findById(id);
        if (pessoaDelete.isPresent()){
            repo.delete(id);
        } else {
            log.error("Eletrodomestico não encontrado");
        }
    }
}
