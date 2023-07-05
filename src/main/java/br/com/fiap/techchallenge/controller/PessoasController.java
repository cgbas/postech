package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.PessoaDTO;
import br.com.fiap.techchallenge.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var pessoas = service.findAll(pageRequest);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable UUID id) {
        var pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> save(@Valid @RequestBody PessoaDTO pessoa){
        var savePessoa = service.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savePessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(savePessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaDTO> update(@Valid @PathVariable UUID id, @RequestBody PessoaDTO pessoa) {
        var pessoaUpdate = service.update(id, pessoa);
        return ResponseEntity.ok(pessoaUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
