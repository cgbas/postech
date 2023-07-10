
# Entregáveis

- API de Endereços
- API de Eletrodomésticos
- API de Pessoas
- Requisitos não funcionais
  - dockerbuild
  - docker-compose
  - deploy AWS (ECS)
  - github actions
  - ADR: DDD e Relacionamentos
    - `pessoa 1:N endereço`
    - `usuario 1:N pessoa`
    - `usuario 1:N aparelho`
  - ADR: Domain Storytelling
  - ADR: convenções de nome 
    - (usuário, pessoa)
    - (dispositivo, eletrodoméstico, aparelho)

## API: Endereços (/enderecos)

A API de endereços tem como objetivo permitir o gerenciamento de informações sobre os endereços cadastrados em nosso sistema.

### Características da API
  - O verbo POST deve ser alterado para gravar os dados recebidos no um banco de dados seguro, associando o endereço ao usuário que está cadastrando-o. 
  - Os verbos GET, PUT e DELETE devem ser desenvolvidos para receber os dados, alterar os dados e remover os dados respectivamente;
  - Caso haja algum erro, a API deve retornar uma mensagem de erro indicando o problema encontrado.
  - A atualização de informações deve permitir a edição de qualquer informação sobre o endereço.
  - As informações devem ser validadas para garantir que elas estão no formato correto e que são válidas.
  - Cada usuário pode ter mais de um endereço cadastrado em nosso sistema.
    - `Pessoa 1 : N Endereço`
  - A busca deve ser capaz de filtrar as informações por rua, bairro, cidade ou outra informação relevante.
  - Essa API deve ser capaz de identificar as pessoas associadas a cada endereço cadastrado
    - Isso permitirá a criação de relacionamentos familiares entre os membros da casa e seus respectivos endereços.
  - Essa API deve ser capaz de identificar as pessoas associadas a cada endereço e vice-versa. 

## API: Eletrodomésticos (/eletrodomesticos)

A API de eletrodomésticos tem como objetivo permitir o cadastro e gerenciamento de informações sobre os aparelhos eletrônicos dos usuários cadastrados em nosso sistema.

### Características da API
- O verbo POST deve ser alterado para gravar os dados recebidos no um banco de dados seguro, associando o aparelho ao usuário que está cadastrando-o.
- As informações devem ser validadas para garantir que elas estão no formato correto e que são válidas.

- Caso haja algum erro, a API deve retornar uma mensagem de erro indicando o problema encontrado.
- Os verbos GET, PUT e DELETE devem ser desenvolvidos para receber os dados, alterar os dados e remover os dados respectivamente;
- Cada usuário pode ter várias pessoas relacionadas cadastradas em nosso sistema.
  - `Usuário 1 :  N Pessoa`
- Cada usuário pode ter vários aparelhos eletrônicos cadastrados em nosso sistema.
  - `Usuário 1 : N Aparelho`
- A busca deve ser capaz de filtrar as informações por nome, modelo, potência ou outra informação relevante.
- A atualização de informações deve permitir a edição de qualquer informação sobre o aparelho eletrônico.
- A API de gestão de eletrodomésticos deve:
  - ser capaz de identificar os consumos de energia dos aparelhos eletrônicos cadastrados, com base no tempo de uso reportado pelo adaptador.
    - Em caso de temos relações 1-1 ou 1-N, listar os usuários que utilizam os dispositivos e os usuários.
      - ```json
        {
            "uuid": "uuid_usuario",
            "aparelho": [
            {
                {"uuid": "uuid_aparelho1"},
                {"uuid": "uuid_aparelho2"},
                {"uuid": "uuid_aparelhoN"}
            }],
        }
      - ```json
        {
            "uuid": "uuid_dispositivo",
            "usuarios": [
            {
                {"uuid": "uuid_usuario1"},
                {"uuid": "uuid_usuario2"},
                {"uuid": "uuid_usuarioN"}
            }],
        }

## API: Pessoas (/pessoas)

A API de gestão de pessoas tem como objetivo permitir o cadastro e gerenciamento de informações sobre as pessoas relacionadas aos usuários cadastrados em nosso sistema. 

### Características da API

- O verbo POST deve ser alterado para gravar os dados recebidos no um banco de dados seguro, associando a pessoa ao usuário que está cadastrando-a.
- As informações devem ser validadas para garantir que elas estão no formato correto e que são válidas.
- Cada usuário pode ter várias pessoas relacionadas cadastradas em nosso sistema.
  - `Usuario 1 : N Pessoas`
- Os verbos GET, PUT e DELETE devem ser desenvolvidos para receber os dados, alterar os dados e remover os dados respectivamente;
- A busca deve ser capaz de filtrar as informações por nome, parentesco, sexo ou outra informação relevante.
- A atualização de informações deve permitir a edição de qualquer informação sobre a pessoa.
- **A API deve ser capaz de identificar os relacionamentos entre as pessoas cadastradas**. 
  - Isso permitirá a criação de relacionamentos familiares entre os membros da casa, como pai, mãe, irmão, etc.
- **A API deve ser capaz de identificar os relacionamentos e gerar outros relacionamentos automaticamente, com base na lógica de relacionamentos**.
  - hipótese: máquina de estado

