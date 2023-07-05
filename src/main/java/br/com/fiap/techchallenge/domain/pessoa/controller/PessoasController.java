package br.com.fiap.techchallenge.domain.pessoa.controller;

import br.com.fiap.techchallenge.domain.pessoa.entity.Pessoa;
import br.com.fiap.techchallenge.domain.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Collection<Pessoa>> findAll(){
        var pessoas = service.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable UUID id) {
        var pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        var savePessoa = service.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savePessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(savePessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> update(@PathVariable UUID id, @RequestBody Pessoa pessoa) {
        var pessoaUpdate = service.update(id, pessoa);
        return ResponseEntity.ok(pessoaUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
