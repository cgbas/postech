package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Eletrodomestico;
import br.com.fiap.techchallenge.repository.EletromesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletromesticosController {

    @Autowired
    private EletromesticoRepository repo;

    @GetMapping
    public Collection<Eletrodomestico> findAll() {
        var eletrodomesticos = repo.findAll();
        return eletrodomesticos;
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Eletrodomestico>> findById(@PathVariable Long id) {
        var eletrodomestico = repo.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public Eletrodomestico save(@RequestBody Eletrodomestico e) {
        repo.save(e);
        return e;
    }

    @PutMapping
    public ResponseEntity<Optional<Eletrodomestico>> update(@RequestBody Eletrodomestico e) {
        Optional<Eletrodomestico> eletrodomestico = repo.update(e);
        return ResponseEntity.ok(eletrodomestico);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repo.delete(id);
    }
}
