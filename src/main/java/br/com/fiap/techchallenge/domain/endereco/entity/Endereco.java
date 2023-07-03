package br.com.fiap.techchallenge.domain.endereco.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Endereco {


    //TODO: Alterar para UUID
    @Id
    @GeneratedValue
    private Long id;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, int numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Endereco setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Endereco setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Endereco setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
