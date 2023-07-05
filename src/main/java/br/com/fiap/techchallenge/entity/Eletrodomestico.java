package br.com.fiap.techchallenge.entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_eletrodomesticos")
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String modelo;
    private int watts;

    public Eletrodomestico() {
    }

    public UUID getId() {
        return id;
    }

    public Eletrodomestico setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Eletrodomestico setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Eletrodomestico setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getWatts() {
        return watts;
    }

    public Eletrodomestico setWatts(int watts) {
        this.watts = watts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eletrodomestico that = (Eletrodomestico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Eletrodomestico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", watts=" + watts +
                '}';
    }
}
