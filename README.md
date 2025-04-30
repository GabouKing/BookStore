# 📚 BookStore API

Aplicação **Java 21** utilizando **Spring Boot** com **Clean Architecture**, desenvolvida para ser a base de um **e-commerce de livros**.

Permite:
- CRUD de livros e editoras
- Criação de ordens de compra
- Processamento de pagamentos

---

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Clean Architecture
- MySQL (banco de dados relacional)
- Maven (gerenciador de dependências)

---

## 📂 Estrutura de Pastas (Clean Architecture)


```text
src/main/java/com/gk/bookstore
│
├── adapters/                 # Adaptadores de entrada/saída (gateways)
├── application/usecases/     # Casos de uso da aplicação
├── controller/               # Controllers da API (Camada de entrada)
├── core/
│   ├── dto/                  # DTOs (Data Transfer Objects)
│   ├── model/                # Entidades de domínio
│   └── usecases/             # Interfaces dos casos de uso
├── infra/
│   ├── gateways/             # Implementações de acesso a dados
│   ├── paymentService/       # Implementações de serviços externos (pagamentos)
│   └── repositories/         # Repositórios
└── BookStoreApplication      # Classe principal (Spring Boot Application)

```

## ⚙️ Funcionalidades Principais

### 📖 Gerenciamento de Livros
- Criar, listar, atualizar e deletar livros.

### 🏢 Gerenciamento de Editoras
- Criar, listar, atualizar e deletar editoras.

### 🛒 Ordem de Compra
- Criar ordens de compra associando livros selecionados.

### 💳 Pagamento
- Efetuar pagamento das ordens de compra de forma simulada.

---

## 🚀 Tecnologias e Ferramentas

- **Java 11**
- **Spring Boot**
- **MySQL** (banco de dados relacional)
- **Maven** (gerenciamento de dependências)
- **Clean Architecture** (organização em camadas de responsabilidade)

---

## Como Executar

1. Clone o repositório:

```bash
git git clone https://github.com/seu-usuario/bookstore.git
cd cd bookstore
```
2. Compile e execute com Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

A aplicação estará disponível em:
(http://localhost:8080)

## 🧠 Conceitos Aplicados

- **Clean Architecture**: Separação clara entre camadas de domínio, aplicação, infraestrutura e interfaces.
- **DTOs (Data Transfer Objects)**: Utilizados para a comunicação entre o cliente e a aplicação, evitando exposição direta das entidades de domínio.
- **Casos de Uso (Use Cases)**: Implementação da lógica de negócio isolada em classes específicas.
- **Gateways**: Pontos de integração entre a aplicação e recursos externos, como banco de dados e serviços de pagamento.
- **Repositórios (Repositories)**: Controle de persistência usando JPA (Java Persistence API) com Hibernate.
- **Inversão de Dependência**: Interface define o contrato e implementações ficam nas camadas inferiores.
- **Boas práticas de design**: Separação de responsabilidades, alta coesão e baixo acoplamento.

---

## 📈 Melhorias Futuras

- Implementar **envio de e-mails** para confirmação de pedidos e notificações.
- Adicionar testes unitários e de integração automatizados.
- Documentar a API utilizando **Swagger** ou **OpenAPI**.
- Melhorar a cobertura de logs e métricas para monitoramento de produção.
- Adicionar Pagamentos com api externa




