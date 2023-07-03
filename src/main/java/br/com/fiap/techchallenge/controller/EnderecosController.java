package br.com.fiap.techchallenge.controller;


import br.com.fiap.techchallenge.domain.Endereco;
import br.com.fiap.techchallenge.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecoRepository repo;

    @GetMapping
    public ResponseEntity<HashSet<Endereco>> findAll() {
        var enderecos = repo.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Endereco>> findById(@PathVariable Long id) {
        var endereco = repo.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco e) {
        repo.save(e);
        return ResponseEntity.ok(e);
    }

    @PutMapping
    public ResponseEntity<Optional<Endereco>> update(@RequestBody Endereco e) {
        Optional<Endereco> endereco = repo.update(e);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.delete(id);
    }
}
