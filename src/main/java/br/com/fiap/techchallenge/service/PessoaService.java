package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.PessoaDTO;
import br.com.fiap.techchallenge.entity.Pessoa;
import br.com.fiap.techchallenge.repository.IPessoaRepository;
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
public class PessoaService {

    @Autowired
    private IPessoaRepository repo;

    public Page<PessoaDTO> findAll(PageRequest pageRequest){
        var buscaPessoa = repo.findAll(pageRequest);
        return buscaPessoa.map(PessoaDTO::new);
    }

    public PessoaDTO findById(UUID id){
       var buscaPessoa = repo.findById(id)
               .orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
       return new PessoaDTO(buscaPessoa);
    }

    public PessoaDTO save(PessoaDTO pessoa){
        var salvaPessoa = new Pessoa()
                .setNome(pessoa.getNome())
                .setDataDeNascimento(pessoa.getDataDeNascimento())
                .setSexo(pessoa.getSexo())
                .setParentesco(pessoa.getParentesco());
        salvaPessoa = repo.save(salvaPessoa);
        return new PessoaDTO(salvaPessoa);
    }

    public PessoaDTO update(UUID id, PessoaDTO pessoa) {
        try {
            var buscaPessoa = repo.getReferenceById(id);
            buscaPessoa
                    .setNome(pessoa.getNome())
                    .setSexo(pessoa.getSexo())
                    .setParentesco(pessoa.getParentesco())
                    .setDataDeNascimento(pessoa.getDataDeNascimento());

            buscaPessoa = repo.save(buscaPessoa);
            return new PessoaDTO(buscaPessoa);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Produto não encontrado pelo id: " + id);
        }
    }


    public void delete(UUID id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Eletrodoméstico não encontrado pelo id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade da base");
        }
    }
}
