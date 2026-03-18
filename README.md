# Gestão de Vagas - Rocketseat 🚀

Projeto desenvolvido com base nas aulas da Rocketseat (Java), focado no gerenciamento de vagas de emprego, empresas e candidatos.

## 🛠 Tecnologias

- **Java 17+**
- **Spring Boot 3**
- **Spring Security** (Autenticação e Autorização com JWT)
- **Spring Data JPA**
- **Swagger / OpenAPI** (Documentação da API)
- **H2 / PostgreSQL** (Banco de dados)
- **Docker**

## ⚙️ Funcionalidades

### 🏢 Empresa (Company)
- **Cadastro:** Registro de novas empresas na plataforma.
- **Autenticação:** Login seguro com geração de Token JWT.
- **Vagas:** Criação (`POST /company/job`) e listagem das vagas publicadas.

### 🧑‍💻 Candidato (Candidate)
- **Perfil:** Cadastro e visualização de informações do candidato.
- **Autenticação:** Login para acesso às funcionalidades exclusivas.
- **Vagas:** Filtros de busca e listagem de oportunidades disponíveis.
- **Inscrição:** Processo de candidatura em vagas específicas (`POST /candidate/job/apply`).

## 📄 Documentação da API (Swagger)

Com a aplicação rodando, acesse a documentação interativa para testar os endpoints:

```
http://localhost:8080/swagger-ui/index.html
```

## 🚀 Como executar o projeto

1. Clone o repositório.
2. **Configure as propriedades:**
   - Renomeie o arquivo `src/main/resources/application-example.properties` para `application.properties`.
   - Preencha com as suas credenciais do PostgreSQL ou utilize as configurações do H2 contidas no `application-test-example.properties.`.
3. Certifique-se de ter o Docker rodando (caso utilize banco de dados via container) ou configure o `application.properties`.
4. Execute a aplicação via terminal:

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

## 🐳 Rodando com Docker

Se preferir rodar o banco de dados via container:

```bash
docker-compose up -d
