package br.com.fiap.techchallenge.domain.endereco.repository;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
public class EnderecoRepository implements IEnderecoRepository {

    private static final LinkedHashSet<Endereco> enderecos = new LinkedHashSet<>();
    public HashSet<Endereco> findAll() {
        log.info("Finding All" + enderecos);
        return enderecos;
    }

    public Optional<Endereco> findById(UUID id) {
        var enderecoById = enderecos.stream().filter(e -> e.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + enderecoById);
        return enderecoById;
    }

    public Endereco save(Endereco e) {
        e.setId(UUID.randomUUID());
        log.info("Saving: " + e);
        enderecos.add(e);
        return e;
    }

    public Endereco update(Endereco e) {
        Endereco enderecoUpdate = this.findById(e.getId()).get();
        log.info("Updating" + enderecoUpdate);
        enderecoUpdate
                    .setLogradouro(e.getLogradouro())
                    .setNumero(e.getNumero())
                    .setBairro(e.getBairro())
                    .setCidade(e.getCidade())
                    .setEstado(e.getEstado());

        return enderecoUpdate;
    }

    public void delete(UUID id) {
        log.info("Deleting ID: " + id);
        enderecos.removeIf(endereco -> endereco.getId().equals(id));
    }
}
