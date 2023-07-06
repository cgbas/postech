# Tech Challenge - Etapa 1

Aluno: Christian Bernini

## Objetivos

Criar CRUDs para os primeiros endpoints da aplicação que desenvolveremos ao longo do curso. Nesse primeiro momento não há relacionamento entre as entidade ou APIs.

## APIs

Há uma collection do insomnia com exemplos de chamada disponível [aqui](Insomnia_export.json)

### Pessoas

#### GET /pessoas

Retorna todas as pessoas ou uma lista vazia caso não exista nenhuma. 
Resultado está paginado.

**Exemplo de ResponseBody**:

```json
{
	"content": [
		{
			"id": "1f061460-4c97-4252-9ba2-60060b5c3306",
			"nome": "Juliana Silva",
			"dataDeNascimento": "1990-09-13",
			"sexo": "FEMININO",
			"parentesco": "Tia"
		},
		{
			"id": "35ab0b61-81c4-400b-99f7-8704a8e2be23",
			"nome": "Paulo Silva",
			"dataDeNascimento": "1982-09-13",
			"sexo": "MASCULINO",
			"parentesco": "Tio"
		}
	],
	"pageable": {
		"sort": {
			"empty": true,
			"sorted": false,
			"unsorted": true
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
		"sorted": false,
		"unsorted": true
	},
	"numberOfElements": 2,
	"empty": false
}
```

#### GET /pessoas/{id}
Retorna uma pessoa específica caso o ID seja válido.

**Exemplo de URL:**

```shell
#url
http://localhost:8080/pessoas/1f061460-4c97-4252-9ba2-60060b5c3306
```

**Exemplo de ResponseBody**:

```json
{
  "id": "1f061460-4c97-4252-9ba2-60060b5c3306",
  "nome": "Juliana Silva",
  "dataDeNascimento": "1990-09-13",
  "sexo": "FEMININO",
  "parentesco": "Tia"
}
```

#### POST /pessoas
Insere uma nova pessoa no sistema.

**Campos obrigatórios:**
- nome (String)
- dataDeNascimento (LocalDate)
  - Formato: _YYYY-MM-DD_
- sexo (Enum)
  - 0 = masculino
  - 1 = feminino
  - 2 = outro
- parentesco (String)

**Exemplo de RequestBody:**

```json
{
  "nome": "Paulo Silva",
  "dataDeNascimento": "1982-09-13",
  "sexo": 0,
  "parentesco": "Tio"
}
```
**Exemplo de ResponseBody**: 

```json
{
  "id": "35ab0b61-81c4-400b-99f7-8704a8e2be23",
  "nome": "Paulo Silva",
  "dataDeNascimento": "1982-09-13",
  "sexo": "MASCULINO",
  "parentesco": "Tia"
}
```

#### PUT /pessoas/{id}

Atualiza um registro de pessoa caso o ID seja válido.

**Campos obrigatórios:**
- nome (String)
- dataDeNascimento (LocalDate)
    - Formato: _YYYY-MM-DD_
- sexo (Enum)
    - 0 = masculino
    - 1 = feminino
    - 2 = outro
- parentesco (String)

**Exemplo de URL e RequestBody:**
```shell
#url
http://localhost:8080/pessoas/7da3de20-c8fb-45ca-807e-89a8d95ba769
```


```json
{
    "nome": "Bruna Maria",
    "sexo": 1,
    "dataDeNascimento": "1983-12-21",
    "parentesco": "Esposa"
}
```
**Exemplo de ResponseBody**:

```json
{
	"id": "7da3de20-c8fb-45ca-807e-89a8d95ba769",
	"nome": "Bruna Lanzoni Muñoz",
	"dataDeNascimento": "1993-12-21",
	"sexo": "FEMININO",
	"parentesco": "Esposa"
}
```

#### DELETE /pessoas/{id}

Remove uma pessoa específica caso o ID seja válido.

**Exemplo de URL:**
```shell
#url
http://localhost:8080/pessoas/7da3de20-c8fb-45ca-807e-89a8d95ba769
```

### Endereços

#### GET /enderecos

Retorna todas os endereços ou uma lista vazia caso não exista nenhum.
Resultado está paginado.

**Exemplo de ResponseBody**:

```json
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

#### GET /enderecos/{id}

Retorna um endereço específico caso o ID seja válido.

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

#### POST /enderecos

Insere um novo endereço no sistema.

Campos obrigatórios:
- logradouro (String)
- número (int)
- bairro (String)
- cidade (String)
- estado (String)


**Exemplo de RequestBody:**

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

#### PUT /enderecos/{id}

Atualiza um endereço caso o ID seja válido.

**Campos obrigatórios**:
- logradouro (String)
- número (int)
- bairro (String)
- cidade (String)
- estado (String)

**Exemplo de RequestBody:**
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

#### DELETE /enderecos/{id}

Remove uma endereço específico caso o ID seja válido.

**Exemplo de URL**
```shell
#url
http://localhost:8080/enderecos/7da3de20-c8fb-45ca-807e-89a8d95ba769
```

### Eletrodomésticos

#### GET /eletrodomesticos
- Retorna todas os eletrodomésticos ou uma lista vazia caso não exista nenhum.
- Resultado está paginado.


Exemplo de resposta:

```json
{
  "content": [
    {
      "id": "11a05bc1-cc36-454f-9285-ca89aaee71cb",
      "nome": "Furadeira Xing",
      "modelo": "HT1678DX",
      "watts": 900
    },
    {
      "id": "d26addb7-5a89-4ac4-876e-c2cf588622bc",
      "nome": "Furadeira ASDFG",
      "modelo": "HP1666K",
      "watts": 500
    },
    {
      "id": "15c7a4e2-e12b-47e2-81c9-ee9cc71b4e9d",
      "nome": "Furadeira Makita",
      "modelo": "HP1630K",
      "watts": 710
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 10,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 3,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 3,
  "empty": false
}
```

#### GET /eletrodomesticos/{id}
Retorna uma eletrodoméstico específico caso o ID seja válido.

**Exemplo de URL**
```shell
#url
http://localhost:8080/eletrodomesticos/11a05bc1-cc36-454f-9285-ca89aaee71cb
```

**Resposta**:

```json
{
	"id": "11a05bc1-cc36-454f-9285-ca89aaee71cb",
	"nome": "Furadeira Makita",
	"modelo": "HP1630K",
	"watts": 710
}
```

#### POST /eletrodomesticos
- Insere uma novo eletrodoméstico no sistema.

**Campos obrigatórios:**
- Nome (String)
- Modelo (String)
- Watts (Integer)

**Exemplo de RequestBody:**

```json
{
    "nome": "Furadeira Makita",
    "modelo": "HP1630K",
    "watts": 710
}
```
**Resposta**:

```json
{
	"id": "bd623d98-223a-45f8-81a5-bb7dd7212577",
	"nome": "Furadeira Makita",
	"modelo": "HP1630K",
	"watts": 710
}
```

#### PUT /eletrodomesticos/{id}
Atualiza um registro de eletrodoméstico.

**Campos obrigatórios:**
- Nome (String)
- Modelo (String)
- Watts (Integer)

**Exemplo de URL e RequestBody**:

```shell
#url
http://localhost:8080/eletrodomesticos/bd623d98-223a-45f8-81a5-bb7dd7212577
```

```json
{
	"nome": "Furadeira Black & Decker",
	"modelo": "HP1630K",
	"watts": 500
}
```
**Resposta**:

```json
{
	"id": "bd623d98-223a-45f8-81a5-bb7dd7212577",
	"nome": "Furadeira Black & Decker",
	"modelo": "TM500KB9",
	"watts": 500
}
```

#### DELETE /eletrodomesticos/{id}

Remove um eletrodoméstico específico caso o ID seja válido.

**Exemplo de URL**:

```shell
#url
http://localhost:8080/eletrodomesticos/bd623d98-223a-45f8-81a5-bb7dd7212577
```

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

### Dificuldades encontradas

#### Persistência

A utilização do H2 e JPA surgiu após perceber a quantidade de código que acabei gerando em duplicidade na camada de repository, que poderia ser abstraído com JPA e H2.

#### IDs Únicos

Decidi pela utilização de UUIDs, mas inicialmente havia implementado com um _Long id_ e comecei a perceber problemas após testes com a chamada do delete (antes de implementar persistência) pois havia necessidade de tratar IDs uma vez que ao remover um ID a utilização de _\<nome do HashSet\>.size()_ deixaria de funcionar, bloqueando novas inserções. Dessa forma também, a aplicação passa a ter IDs verdadeiros que não estão amarrados a alguma ideia de ordenação.
