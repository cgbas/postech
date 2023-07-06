package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entity.Pessoa;
import br.com.fiap.techchallenge.enums.Sexo;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public class PessoaDTO {

    private UUID id;
    @NotBlank(message = "Informe o nome.")
    @NotNull(message = "Campo obrigatório.")
    private String nome;
    @PastOrPresent(message = "Informe uma data de nascimento válida.")
    @NotNull(message = "Campo obrigatório.")
    private LocalDate dataDeNascimento;

    @NotNull(message = "Sexo não pode ser nulo.")
    @NotNull(message = "Campo obrigatório.")
    private Sexo sexo;
    @NotBlank(message = "Informe o parentesco.")
    @NotNull(message = "Campo obrigatório.")
    private String parentesco;

    public PessoaDTO() {
    }

    public PessoaDTO(UUID id, String nome, LocalDate dataDeNascimento, Sexo sexo, String parentesco) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }

    public PessoaDTO(Pessoa entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.dataDeNascimento = entidade.getDataDeNascimento();
        this.sexo = entidade.getSexo();
        this.parentesco = entidade.getParentesco();
    }

    public UUID getId() {
        return id;
    }

    public PessoaDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PessoaDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public PessoaDTO setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public PessoaDTO setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getParentesco() {
        return parentesco;
    }

    public PessoaDTO setParentesco(String parentesco) {
        this.parentesco = parentesco;
        return this;
    }
}
