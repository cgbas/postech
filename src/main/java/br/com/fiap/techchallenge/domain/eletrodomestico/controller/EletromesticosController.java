package br.com.fiap.techchallenge.domain.eletrodomestico.controller;

import br.com.fiap.techchallenge.domain.eletrodomestico.entity.Eletrodomestico;
import br.com.fiap.techchallenge.domain.eletrodomestico.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletromesticosController {

    @Autowired
    private EletrodomesticoService service;

    @GetMapping
    public ResponseEntity<Collection<Eletrodomestico>> findAll() {
        var eletrodomesticos = service.findAll();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Eletrodomestico>> findById(@PathVariable UUID id) {
        var eletrodomestico = service.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<Eletrodomestico> save(@RequestBody Eletrodomestico eletrodomestico) {
        var saveEletrodomestico = service.save(eletrodomestico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveEletrodomestico.getId()).toUri();
        return ResponseEntity.created(uri).body(saveEletrodomestico);
    }

    @PutMapping("{id}")
    public ResponseEntity<Eletrodomestico> update(@PathVariable UUID id, @RequestBody Eletrodomestico eletrodomestico) {
        var updateEletrodomestico = service.update(id, eletrodomestico);
        return ResponseEntity.ok(updateEletrodomestico);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
