package br.com.fiap.techchallenge.domain.endereco.repository;

import br.com.fiap.techchallenge.domain.endereco.entity.Endereco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
@Slf4j
@Repository
public class EnderecoRepository implements IEnderecoRepository {

    private static HashSet<Endereco> repo = new HashSet<Endereco>();
    public HashSet<Endereco> findAll() {
        return repo;
    }

    public Optional<Endereco> findById(Long id) {
        var enderecoById = repo.stream().filter(e -> e.getId().equals(id)).findFirst();
        log.info(enderecoById.toString());
        return enderecoById;
    }

    public Endereco save(Endereco e) {
        e.setId(repo.size() + 1L);
        repo.add(e);
        return e;
    }

    public Optional<Endereco> update(Endereco e) {
        Optional<Endereco> enderecoOptional = findById(e.getId());

        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get()
                    .setLogradouro(e.getLogradouro())
                    .setNumero(e.getNumero())
                    .setBairro(e.getBairro())
                    .setCidade(e.getCidade())
                    .setEstado(e.getEstado());

            return Optional.of(endereco);
        }

        return Optional.empty();
    }

    public void delete(Long id) {
        repo.remove(id);
    }
}
