package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.EnderecoDTO;
import br.com.fiap.techchallenge.entity.Endereco;
import br.com.fiap.techchallenge.repository.IEnderecoRepository;
import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.service.exception.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository repo;

    public Page<EnderecoDTO> findAll(PageRequest pageRequest){
        var buscaEndereco = repo.findAll(pageRequest);
        return buscaEndereco.map(EnderecoDTO::new);
    }

    public EnderecoDTO findById(UUID id){
        var buscaEndereco = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Endereço não encontrado."));
        return new EnderecoDTO(buscaEndereco);
    }

    public EnderecoDTO save(EnderecoDTO endereco){
        var salvaEndereco = new Endereco()
                .setLogradouro(endereco.getLogradouro())
                .setNumero(endereco.getNumero())
                .setBairro(endereco.getBairro())
                .setCidade(endereco.getCidade())
                .setEstado(endereco.getEstado());

        salvaEndereco = repo.save(salvaEndereco);
        return new EnderecoDTO(salvaEndereco);
    }

    public EnderecoDTO update(UUID id, EnderecoDTO endereco) {
        try {
            var buscaEndereco = repo.getReferenceById(id);
            buscaEndereco
                    .setLogradouro(endereco.getLogradouro())
                    .setNumero(endereco.getNumero())
                    .setBairro(endereco.getBairro())
                    .setCidade(endereco.getCidade())
                    .setEstado(endereco.getEstado());
            buscaEndereco = repo.save(buscaEndereco);
            return new EnderecoDTO(buscaEndereco);
        } catch(EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Endereço não encontrado.");
        }

    }


    public void deleteById(UUID id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Eletrodoméstico não encontrado pelo id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade da base");
        }
    }
}
