package br.com.fiap.techchallenge.domain.pessoa.entity;

import br.com.fiap.techchallenge.domain.pessoa.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Pessoa {

    //TODO: Alterar para UUID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Sexo sexo;
    private String parentesco;

    public Pessoa(Long id, String nome, LocalDate dataDeNascimento, Sexo sexo, String parentesco) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Pessoa setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Pessoa setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getParentesco() {
        return parentesco;
    }

    public Pessoa setParentesco(String parentesco) {
        this.parentesco = parentesco;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", sexo=" + sexo +
                ", parentesco='" + parentesco + '\'' +
                '}';
    }
}