package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.EletrodomesticoDTO;
import br.com.fiap.techchallenge.service.EletrodomesticoService;
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
@RequestMapping("/eletrodomesticos")
public class EletromesticosController {

    @Autowired
    private EletrodomesticoService service;

    @GetMapping
    public ResponseEntity<Page<EletrodomesticoDTO>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var eletrodomesticos = service.findAll(pageRequest);
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("{id}")
    public ResponseEntity<EletrodomesticoDTO> findById(@PathVariable UUID id) {
        var eletrodomestico = service.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<EletrodomesticoDTO> save(@Valid @RequestBody EletrodomesticoDTO eletrodomestico) {
        var saveEletrodomestico = service.save(eletrodomestico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saveEletrodomestico.getId()).toUri();
        return ResponseEntity.created(uri).body(saveEletrodomestico);
    }

    @PutMapping("{id}")
    public ResponseEntity<EletrodomesticoDTO> update(@Valid @PathVariable UUID id, @RequestBody EletrodomesticoDTO eletrodomestico) {
        var updateEletrodomestico = service.update(id, eletrodomestico);
        return ResponseEntity.ok(updateEletrodomestico);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
