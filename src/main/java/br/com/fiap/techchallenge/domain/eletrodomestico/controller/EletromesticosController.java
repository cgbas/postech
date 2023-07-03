package br.com.fiap.techchallenge.domain.eletrodomestico.controller;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Pessoa;
import br.com.fiap.techchallenge.domain.eletrodomestico.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletromesticosController {

    @Autowired
    private EletrodomesticoService repo;

    @GetMapping
    public ResponseEntity<HashSet<Pessoa>> findAll() {
        var eletrodomesticos = repo.findAll();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        var eletrodomestico = repo.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa e) {
        repo.save(e);
        return ResponseEntity.ok(e);
    }

    @PutMapping
    public ResponseEntity<Optional<Pessoa>> update(@RequestBody Pessoa e) {
        Optional<Pessoa> eletrodomestico = repo.update(e);
        return ResponseEntity.ok(eletrodomestico);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.delete(id);
    }
}
