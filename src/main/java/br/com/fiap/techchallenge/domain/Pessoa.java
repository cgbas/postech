package br.com.fiap.techchallenge.domain;

import br.com.fiap.techchallenge.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Sexo sexo;
    private String parentesco;

}
