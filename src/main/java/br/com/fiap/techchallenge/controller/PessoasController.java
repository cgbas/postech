package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Pessoa;
import br.com.fiap.techchallenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaRepository repo;

    @GetMapping
    public Collection<Pessoa> findAll(){
        var pessoas = repo.findAll();
        return pessoas;
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        var pessoa = repo.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa p){
        repo.save(p);
        return p;
    }

    @PutMapping
    public ResponseEntity<Optional<Pessoa>> update(@RequestBody Pessoa pessoa) {
        Optional<Pessoa> p = repo.update(pessoa);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.delete(id);
    }

}
