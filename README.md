# Tech Challenge - Etapa 1

Aluno: Christian Bernini

## Objetivos

Criar CRUDs para os primeiros endpoints da aplicação que desenvolveremos ao longo do curso. Nesse primeiro momento não há relacionamento entre as entidade ou APIs.

## APIs

Há uma collection do insomnia com exemplos de chamada disponível [aqui](Insomnia_export.json)

### Pessoas

#### GET /pessoas
- Retorna todas as pessoas ou uma lista vazia caso não exista nenhuma pessoa cadastrada. 
- Resultado está paginado.

Exemplo de chamada:

http://localhost:8080/pessoas/

Exemplo de resposta:

```
{
	"content": [
		{
			"id": "95d542c9-71e3-412e-80f5-98eb5468de2b",
			"logradouro": "Avenida Feliz",
			"numero": 150,
			"bairro": "Atacama",
			"cidade": "São Paulo",
			"estado": "São Paulo"
		},
		{
			"id": "4f6dc92a-7598-4b9f-a8c4-8a27a751d685",
			"logradouro": "Avenida Salem",
			"numero": 150,
			"bairro": "Jd. Monte Verde",
			"cidade": "São José dos Fields",
			"estado": "São Paulo"
		}
	],
	"pageable": {
		"sort": {
			"empty": true,
			"unsorted": true,
			"sorted": false
		},
		"offset": 0,
		"pageNumber": 0,
		"pageSize": 10,
		"paged": true,
		"unpaged": false
	},
	"last": true,
	"totalPages": 1,
	"totalElements": 2,
	"first": true,
	"size": 10,
	"number": 0,
	"sort": {
		"empty": true,
		"unsorted": true,
		"sorted": false
	},
	"numberOfElements": 2,
	"empty": false
}
```

#### GET /pessoas/{id}
- Retorna uma pessoa específica.

**Request**:

http://localhost:8080/pessoas/e211d266-fa4a-494c-8448-4831d1c02cdd

**Resposta**:

```json
{
			"id": "4f6dc92a-7598-4b9f-a8c4-8a27a751d685",
			"logradouro": "Avenida Salem",
			"numero": 150,
			"bairro": "Jd. Monte Verde",
			"cidade": "São José dos Fields",
			"estado": "São Paulo"
}
```

#### POST /pessoas
- Insere uma nova pessoa no sistema.

Campos obrigatórios:
- logradouro (String)
- número (int)
- bairro (String)
- cidade (String)
- estado (String)


**Exemplo de Request:**

http://localhost:8080/pessoas

```json
{
			"logradouro": "Avenida Salem",
			"numero": 150,
			"bairro": "Jd. Monte Verde",
			"cidade": "São José dos Fields",
			"estado": "São Paulo"
}
```
**Resposta**: 

```json
{
    "id": "4f6dc92a-7598-4b9f-a8c4-8a27a751d685", 
    "logradouro": "Avenida Salmao",
    "numero": "150",
    "bairro": "bla",
    "cidade": "São José dos Campos",
    "estado": "São Paulo"
}
```

#### PUT /pessoas/{id}
- Atualiza um registro de pessoa.

**Exemplo de Request:**

http://localhost:8080/e211d266-fa4a-494c-8448-4831d1c02cdd

```json
{
  "logradouro": "Avenida Tubarão",
  "numero": 100,
  "cidade": "São José dos Campos",
  "estado": "São Paulo"
}
```
**Resposta**:

```json
{
    "id": "4f6dc92a-7598-4b9f-a8c4-8a27a751d685", 
    "logradouro": "Avenida Salmao",
    "numero": "150",
    "bairro": "bla",
    "cidade": "São José dos Campos",
    "estado": "São Paulo"
}
```

#### DELETE /pessoas/{id}

- Remove uma pessoa específica.

**Request**:

http://localhost:8080/pessoas/e211d266-fa4a-494c-8448-4831d1c02cdd


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
