# Tech Challenge - Etapa 1

Aluno: Christian Bernini

## Objetivos

Criar CRUDs para os primeiros endpoints da aplicação que desenvolveremos ao longo do curso. Nesse primeiro momento não há relacionamento entre as entidade ou APIs.

## APIs

Há uma collection do insomnia com exemplos de chamada disponível [aqui](Insomnia_export.json)

### Pessoas

#### GET /pessoas
#### GET /pessoas/{id}
#### POST /pessoas
#### PUT /pessoas/{id}
#### DELETE /pessoas/{id}

### Endereços

#### GET /enderecos
#### GET /enderecos/{id}
#### POST /enderecos
#### PUT /enderecos/{id}
#### DELETE /enderecos/{id}

### Eletrodomésticos

#### GET /eletrodomesticos
#### GET /eletrodomesticos/{id}
#### POST /eletrodomesticos
#### PUT /eletrodomesticos/{id}
#### DELETE /eletrodomesticos/{id}

## Outros

### /h2-console

Como referenciado nas [Tecnologias Utilizadas](#tecnologias-utilizadas), optei por utilizar h2 já
nesse primeiro momento devido à facilidade de incluir aspectos de persistência de dados na próxima fase.

Os dados de conexão (url, username e password) podem ser encontrados [aqui](src/main/resources/application-test.properties)


## Tecnologias utilizadas

- SpringBoot
- SpringMVC (Web)
- Validations (Jakarta)
- SpringData
- H2
- Maven 3.1.1
- Java17 (corretto)
- Spring Actuator

### Dificuldades encontradas

#### Persistência

A utilização do H2 e JPA surgiu após perceber a quantidade de código que acabei gerando em duplicidade na camada de repository, que poderia ser abstraído com JPA e H2.

#### IDs Únicos

Decidi pela utilização de UUIDs, mas inicialmente havia implementado com um _Long id_ e comecei a perceber problemas após testes com a chamada do delete (antes de implementar persistência) pois havia necessidade de tratar IDs uma vez que ao remover um ID a utilização de _\<nome do HashSet\>.size()_ deixaria de funcionar, bloqueando novas inserções. Dessa forma também, a aplicação passa a ter IDs verdadeiros que não estão amarrados a alguma ideia de ordenação.
