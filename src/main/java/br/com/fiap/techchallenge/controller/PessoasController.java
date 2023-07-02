package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Pessoa;
import br.com.fiap.techchallenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    //TODO: está retornando vazio
    @GetMapping
    public ResponseEntity<Collection<Pessoa>> findAll(){
        var pessoas = repo.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        var pessoa = this.repo.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Pessoa pessoa){
        repo.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Optional<Pessoa>> update(@RequestBody Pessoa pessoa) {
        Optional<Pessoa> p = this.repo.update(pessoa);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.repo.delete(id);
    }

}
