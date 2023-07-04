package br.com.fiap.techchallenge.domain.eletrodomestico.controller;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import br.com.fiap.techchallenge.domain.eletrodomestico.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletromesticosController {

    @Autowired
    private EletrodomesticoService service;

    @GetMapping
    public ResponseEntity<HashSet<Eletrodomestico>> findAll() {
        var eletrodomesticos = service.findAll();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Eletrodomestico>> findById(@PathVariable UUID id) {
        var eletrodomestico = service.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<Eletrodomestico> save(@RequestBody Eletrodomestico e) {
        service.save(e);
        return ResponseEntity.ok(e);
    }

    @PutMapping
    public ResponseEntity<Optional<Eletrodomestico>> update(@RequestBody Eletrodomestico e) {
        Optional<Eletrodomestico> eletrodomestico = service.update(e);
        return ResponseEntity.ok(eletrodomestico);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
