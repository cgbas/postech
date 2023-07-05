package br.com.fiap.techchallenge.controller;


import br.com.fiap.techchallenge.entity.Endereco;
import br.com.fiap.techchallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<Collection<Endereco>> findAll() {
        var enderecos = service.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Endereco> findById(@PathVariable UUID id) {
        var endereco = service.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        var saveEndereco = service.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveEndereco.getId()).toUri();
        return ResponseEntity.created(uri).body(saveEndereco);
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> update(@PathVariable UUID id, @RequestBody Endereco endereco) {
        var updateEndereco = service.update(id, endereco);
        return ResponseEntity.ok(updateEndereco);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
