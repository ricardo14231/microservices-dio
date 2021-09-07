# API com arquitetura de microsserviços usando Spring Clound. 

# Sobre o projeto

Está API foi desenvolvida na arquitetura de microsserviços durante o Bootcamp full stack Santander, oferecida pela plataforma Digital Innovation One.

A API representa uma simples criação e adição de produtos em um carrinho de compras. É possível criar um produto e adicionar o produto no carrinho.

Foram desenvolvidos os testes na classe de serviço.

## Pré-requisitos para executar o projeto:

Java: 11 ou superior.  
Maven: 3.8.1  
JUnit 5.   
Redis.   
ElasticSearch.   

## Para executar a aplicação:

No diretório de cada microsserviço, abra o terminal e execute o comando `mvn spring-boot:run` na seguinte sequência de diretórios:   
`config-server`   
`server-discovery`    
`gateway`   
`product-catalog`   
`shopping-cart`   

## Endpoints:

Método | Endpoint
:-----:|:--------:
POST  | http://localhost:8080/product
GET   | http://localhost:8080/product/{id}
POST  | http://localhost:8080/cart
GET   | http://localhost:8080/cart/{id}

## Modelo Json para criar um produto e adicioná-lo ao carrinho de compras:
Para adicionar um produto, envie uma requisição, método POST, para o endpoint http://localhost:8080/product com o modelo a seguir:
``` JSON
{
	"id": 1,
	"name": "Name Product.",
	"amount": 5
}
```   
Para adicionar o produto no carrinho, envie uma requisição, método POST, para o endpoint http://localhost:8080/cart com o modelo a seguir:
``` JSON
{
	"id": 1,
	"items": 
	[{
		"idProduct": 1,
		"amount": 2
	}]
}
```
## Autor:

Ricardo Farias.

https://www.linkedin.com/in/ricardo-farias-04069359/

## Licença:

[![NPM](http://img.shields.io/npm/l/react)](https://github.com/ricardo14231/microservices-dio/blob/master/LICENSE)
