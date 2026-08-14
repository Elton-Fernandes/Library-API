# Library API

API REST desenvolvida em **Spring Boot** para gerenciamento de uma biblioteca, contemplando o cadastro de autores, livros, editoras, clientes e o controle de empréstimos entre eles.

## ✨ Funcionalidades

- CRUD completo de **Autores**, **Livros**, **Editoras**, **Clientes** e **Empréstimos**
- Relacionamentos JPA modelados entre as entidades
- DTOs com arquitetura em camadas (Controller → Service → Repository)
- Persistência em **PostgreSQL**, rodando em containers Docker

## 🛠️ Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (via Docker)
- pgAdmin4 (via Docker)
- Maven

## 🗂️ Modelo de dados

Entidades principais:

- **Autor**
- **Livro**
- **Editora**
- **Cliente**
- **Empréstimo**

Decisões técnicas relevantes:

- `LocalDate` para datas e `BigDecimal` para valores monetários
- IDs do tipo `Long` com geração `IDENTITY`
- Injeção via construtor (constructor injection), evitando field injection
- Relacionamentos `@OneToMany` e `@ManyToMany` mapeados entre as entidades
- Classe de configuração dedicada para o banco de dados

## 🚀 Como executar

### Pré-requisitos

- Docker (para o banco PostgreSQL)
- JDK e Maven

### Subindo os containers

O banco de dados roda em dois containers em uma mesma network Docker: `librarydb` (PostgreSQL) e `pgadmin4` (interface de administração). Exemplo de `docker-compose.yml`:

```yaml
services:
  librarydb:
    image: postgres:16.3
    container_name: librarydb
    environment:
      POSTGRES_DB: library
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5433:5432"
    networks:
      - library-network

  pgadmin4:
    image: dpage/pgadmin4
    container_name: pgadmin4
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: admin
    ports:
      - "15432:80"
    networks:
      - library-network

networks:
  library-network:
    driver: bridge
```

```bash
docker compose up -d
```

> Ajuste usuário, senha e credenciais conforme sua configuração real. Com esse mapeamento, o Postgres fica acessível em `localhost:5433` e o pgAdmin em `localhost:15432`.

### Rodando a aplicação

```bash
git clone <url-do-repositorio>
cd library-api
./mvnw spring-boot:run
```

A porta e o endereço de acesso da API dependem da configuração do projeto (`application.properties`/`application.yml`).

## 📌 Endpoints (exemplo)

| Método | Rota            | Descrição            |
|--------|-----------------|------------------------|
| GET    | /autores        | Lista todos os autores |
| GET    | /autores/{id}   | Busca autor por ID     |
| POST   | /autores        | Cadastra novo autor    |
| PUT    | /autores/{id}   | Atualiza autor         |
| DELETE | /autores/{id}   | Remove autor           |

> Padrão semelhante se aplica às demais entidades (Livro, Editora, Cliente, Empréstimo).

## 🧭 Roadmap

- [✔️] Criação de DTOs de requisição e resposta
- [✔️] Lógica de disponibilidade de livros (derivada da entidade Empréstimo)
- [ ] Tratamento global de erros com `@ControllerAdvice`
- [ ] Bean Validation nos DTOs
- [ ] Testes unitários e de integração (JUnit/Mockito)
- [ ] Documentação da API com Swagger/OpenAPI
- [ ] Segurança básica com Spring Security

## 👤 Autor

Projeto desenvolvido por Elton Fernandes.
