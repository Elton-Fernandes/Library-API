# 📚 Library API v1.0.0

API REST desenvolvida em **Spring Boot** para gerenciamento de uma biblioteca — cadastro de autores, livros, editoras e clientes, além do controle de empréstimos entre eles.

Mais do que um CRUD, o projeto foi construído como um exercício de arquitetura: separação clara de responsabilidades, regras de negócio bem definidas e práticas usadas em ambientes profissionais (validação, tratamento de erros, testes e documentação de API).

---

## 🧱 Arquitetura e decisões técnicas

**Camadas bem definidas — `Controller → Service → Repository`**
Cada camada tem uma responsabilidade única: o Controller apenas recebe e devolve dados, o Service concentra as regras de negócio, e o Repository cuida da persistência. Essa separação facilita testes isolados e evita que lógica de negócio vaze para os controllers.

**DTOs para entrada e saída**
As entidades JPA nunca são expostas diretamente pela API. DTOs de requisição e resposta desacoplam o modelo de domínio do contrato público, permitindo evoluir um sem quebrar o outro.

**Regras de negócio nos Services**
A lógica de disponibilidade de livros, por exemplo, não é armazenada como um campo booleano redundante — ela é **derivada da entidade Empréstimo**, evitando inconsistência entre o estado do livro e o histórico real de empréstimos.

**Bean Validation nos DTOs**
Validações (`@Valid` e anotações como `@NotNull`, `@NotBlank`, etc.) garantem que dados inválidos sejam rejeitados antes de chegar à camada de negócio.

**Tratamento global de exceções com `@ControllerAdvice`**
Erros são capturados centralizadamente e convertidos em respostas HTTP padronizadas, evitando tratamento de exceção repetido em cada controller e mantendo mensagens de erro consistentes para quem consome a API.

**Relacionamentos JPA/Hibernate**
Mapeamento de relações `@OneToMany` e `@ManyToMany` entre as entidades (Autor, Livro, Editora, Cliente, Empréstimo), com atenção a problemas comuns desse tipo de modelagem — como recursão infinita em `toString()` entre entidades bidirecionais, resolvida durante o desenvolvimento.

**Modelagem cuidadosa dos tipos**
`LocalDate` para datas e `BigDecimal` para valores monetários (evitando os problemas de precisão do `double`), IDs `Long` com geração `IDENTITY`, e injeção de dependência via **construtor** em vez de field injection — facilitando testes e deixando dependências explícitas.

**PostgreSQL via Docker**
Banco de dados rodando em containers Docker (`librarydb` e `pgadmin4` na mesma network), simulando um ambiente mais próximo do real do que um H2 em memória.

**Testes unitários com JUnit e Mockito**
Cobertura focada principalmente nas regras de negócio mais sensíveis, como a lógica de empréstimos — garantindo que o comportamento central da aplicação não regrida a cada mudança.

**Documentação com Swagger/OpenAPI**
Endpoints documentados e exploráveis via interface Swagger, facilitando tanto o consumo da API quanto a avaliação do projeto por terceiros.

**Versionamento com Git/GitHub**
Histórico de commits ao longo do desenvolvimento, incluindo depuração de erros de injeção nula, problemas de persistência de timezone e conflitos de `@GetMapping` ambíguos.

---

## 🛠️ Tecnologias

- **Java**
- **Spring Boot**
- **Spring Data JPA** / Hibernate
- **PostgreSQL** (via Docker)
- **pgAdmin4** (via Docker)
- **Maven**
- **JUnit** / **Mockito**
- **Swagger / OpenAPI**

## 🗂️ Modelo de dados

Entidades principais:

- **Autor**
- **Livro**
- **Editora**
- **Cliente**
- **Empréstimo**

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
| GET    | /autores/{id}   | Busca autor por ID     |
| POST   | /autores        | Cadastra novo autor    |
| PUT    | /autores/{id}   | Atualiza autor         |
| DELETE | /autores/{id}   | Remove autor           |

> Padrão semelhante se aplica às demais entidades (Livro, Editora, Cliente, Empréstimo).

## 🧭 Roadmap

- [✔️] Criação de DTOs de requisição e resposta
- [✔️] Lógica de disponibilidade de livros (derivada da entidade Empréstimo)
- [✔️] Tratamento global de erros com `@ControllerAdvice`
- [✔️] Bean Validation nos DTOs
- [✔️] Testes unitários (JUnit/Mockito)
- [✔️] Documentação da API com Swagger/OpenAPI

## 👤 Autor

Projeto desenvolvido por **Elton Fernandes**.