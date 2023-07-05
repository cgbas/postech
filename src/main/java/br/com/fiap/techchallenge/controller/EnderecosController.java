package br.com.fiap.techchallenge.controller;


import br.com.fiap.techchallenge.dto.EnderecoDTO;
import br.com.fiap.techchallenge.service.EnderecoService;
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
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<Page<EnderecoDTO>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var enderecos = service.findAll(pageRequest);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable UUID id) {
        var endereco = service.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO endereco) {
        var saveEndereco = service.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveEndereco.getId()).toUri();
        return ResponseEntity.created(uri).body(saveEndereco);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoDTO> update(@Valid @PathVariable UUID id, @RequestBody EnderecoDTO endereco) {
        var updateEndereco = service.update(id, endereco);
        return ResponseEntity.ok(updateEndereco);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
