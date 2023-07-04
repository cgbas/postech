package br.com.fiap.techchallenge.domain.endereco.controller;


import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import br.com.fiap.techchallenge.domain.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<HashSet<Endereco>> findAll() {
        var enderecos = service.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Endereco>> findById(@PathVariable UUID id) {
        var endereco = service.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco e) {
        service.save(e);
        return ResponseEntity.ok(e);
    }

    @PutMapping
    public ResponseEntity<Optional<Endereco>> update(@RequestBody Endereco e) {
        Optional<Endereco> endereco = service.update(e);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
