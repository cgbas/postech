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
public class Endereco {

    @Id
    @GeneratedValue
    private Long id;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
}
