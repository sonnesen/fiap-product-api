# FIAP Product API

## Sobre o Projeto
Este projeto é uma API para gerenciamento de produtos, desenvolvida para estudantes da FIAP. Ele permite criar, listar, atualizar e excluir informações de produtos e categorias.

## Tecnologias Utilizadas
- Java
- Spring
- Spring Data JPA
- PostgreSQL
- Docker

## Como Configurar
### Pré-requisitos
- Java JDK 17 ou superior
- PostgreSQL 
- Maven

### Instalação
1. Clone o repositório:

git clone https://github.com/sonnesen/fiap-product-api.git

2. Instale as dependências:

cd fiap-product-api
mvn clean package

A API estará disponível em `http://localhost:8080`.

## Como Contribuir
Contribuições são sempre bem-vindas! Veja como:

1. Fork o projeto
2. Crie sua Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Licença
Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

## Contato
Winston Spencer Sonnesen - sonnesen@gmail.com

### Exemplos de Uso
Para adicionar um novo produto:

POST /categories { "name": "Nome da Categoria", "description": "Descrição da Categoria", "active": true }