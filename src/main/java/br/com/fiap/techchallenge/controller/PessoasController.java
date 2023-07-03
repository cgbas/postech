package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Pessoa;
import br.com.fiap.techchallenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaRepository repo;

    @GetMapping
    public ResponseEntity<HashSet<Pessoa>> findAll(){
        var pessoas = repo.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        var pessoa = repo.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa p){
        repo.save(p);
        return ResponseEntity.ok(p);
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
