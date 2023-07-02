package br.com.fiap.techchallenge.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Eletrodomestico {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String modelo;
    private int potenciaEmWatts;

}
