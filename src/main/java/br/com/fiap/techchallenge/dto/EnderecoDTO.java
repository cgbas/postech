package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class EnderecoDTO {
    private UUID id;
    @NotBlank(message = "Informe o Nome.")
    private String logradouro;
    @Positive(message = "Número deve ser positivo.")
    @NotBlank(message = "Informe o Número.")
    private int numero;
    @NotBlank(message = "Informe o Bairro.")
    private String bairro;
    @NotBlank(message = "Informe a Cidade.")
    private String cidade;
    @NotBlank(message = "Informe o Estado.")
    private String estado;

    public EnderecoDTO() {
    }

    public EnderecoDTO(UUID id, String logradouro, int numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoDTO(Endereco entidade) {
        this.id = entidade.getId();
        this.logradouro = entidade.getLogradouro();
        this.numero = entidade.getNumero();
        this.bairro = entidade.getBairro();
        this.cidade = entidade.getCidade();
        this.estado = entidade.getEstado();
    }

    public UUID getId() {
        return id;
    }

    public EnderecoDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public EnderecoDTO setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public EnderecoDTO setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public EnderecoDTO setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public EnderecoDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public EnderecoDTO setEstado(String estado) {
        this.estado = estado;
        return this;
    }
}
