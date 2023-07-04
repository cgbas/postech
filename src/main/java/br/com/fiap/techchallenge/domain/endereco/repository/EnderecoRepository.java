package br.com.fiap.techchallenge.domain.endereco.repository;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
@Slf4j
@Repository
public class EnderecoRepository implements IEnderecoRepository {

    private static final HashSet<Endereco> enderecos = new HashSet<>();
    public HashSet<Endereco> findAll() {
        log.info("Finding All" + enderecos);
        return enderecos;
    }

    public Optional<Endereco> findById(Long id) {
        var enderecoById = enderecos.stream().filter(e -> e.getId().equals(id)).findFirst();
        log.info("Finding by Id: " + enderecoById);
        return enderecoById;
    }

    public Endereco save(Endereco e) {
        e.setId(enderecos.size() + 1L);
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

    public void delete(Long id) {
        log.info("Deleting ID: " + id);
        enderecos.removeIf(endereco -> endereco.getId().equals(id));
    }
}
