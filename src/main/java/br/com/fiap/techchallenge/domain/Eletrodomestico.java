package br.com.fiap.techchallenge.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
public class Eletrodomestico {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String modelo;
    private int watts;

    public Eletrodomestico() {
    }

    public Eletrodomestico(Long id, String nome, String modelo, int watts) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.watts = watts;
    }

    public Long getId() {
        return id;
    }

    public Eletrodomestico setId(Long id) {
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
}
