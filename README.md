# sistema-votacao-de-pauta

O sistema permite: cadastrar uma nova pauta, iniciar uma nova sessão, votar e consultar o resultado da votação.

## Regras de Negócio
Ao utilizar API, deve-se usar a ordem lógica de operações:
- Criar uma pauta;
- Abrir a sessão de votação;
- Realizar as votações dentro do tempo padrão de um minuto;
- Listas as pautas com seus resultados;

## Documentação de API disponível no Heroku

A documentação de API com os padrões de comunicação está disponível em:

- [Swagger Documentation API](https://sistema-votacao-de-pauta.herokuapp.com/swagger-ui.html#/pauta-controller)

## Tecnologias
Para construção do sistema foram utilizadas as tecnologias:
- Java 8;
- Spring Boot Framework;
- Heroku Cloud;

## Licença de software
Como este projeto é dedicado a estudos e não é um projeto com objetivo comercial, não há cobrança, direitos ou restrições em seu uso. (MIT License).

## Running Locally

Com Java 8, Maven e Heroku CLI instalado, siga as instruções:[Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/heroku/sistema-votacao-de-pauta.git
$ cd sistema-votacao-de-pauta
$ mvn install
$ heroku local:start
```

Seu app heroku será executado localmente em [localhost:5000](http://localhost:5000/).

Se deseja seguir com banco de dados, use `.env` arquivo de configuração:

```
JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/java_database_name
```

## Fazendo deploy no Heroku

```sh
$ heroku create
$ git push heroku main
$ heroku open
```


## Postman collection test

Caminho: /postman/postman_collection_to_test_requests.json
