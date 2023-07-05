package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entity.Eletrodomestico;

import java.util.UUID;

public class EletrodomesticoDTO {
    private UUID id;
    private String nome;
    private String modelo;
    private int watts;

    public EletrodomesticoDTO() {
    }

    public EletrodomesticoDTO(UUID id, String nome, String modelo, int watts) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.watts = watts;
    }

    public EletrodomesticoDTO(Eletrodomestico entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.modelo = entidade.getModelo();
        this.watts = entidade.getWatts();
    }

    public UUID getId() {
        return id;
    }

    public EletrodomesticoDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EletrodomesticoDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public EletrodomesticoDTO setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getWatts() {
        return watts;
    }

    public EletrodomesticoDTO setWatts(int watts) {
        this.watts = watts;
        return this;
    }
}
