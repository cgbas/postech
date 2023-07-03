package br.com.fiap.techchallenge.domain.pessoa.controller;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import br.com.fiap.techchallenge.domain.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;


@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<HashSet<Pessoa>> findAll(){
        var pessoas = service.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        var pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa p){
        service.save(p);
        return ResponseEntity.ok(p);
    }

    @PutMapping
    public ResponseEntity<Optional<Pessoa>> update(@RequestBody Pessoa pessoa) {
        Optional<Pessoa> p = service.update(pessoa);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
