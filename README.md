# Sistema de Autenticação e Autorização com JWT

Este é um sistema de autenticação e autorização desenvolvido com Spring Boot, utilizando JWT (JSON Web Token) para autenticação e Spring Security para controle de acesso baseado em roles.

## Requisitos

- JDK 21 (LTS) ou superior
- MySQL 8.0 ou superior
- Maven 3.6 ou superior

## Configuração do Ambiente

1. Clone o repositório:
```bash
git clone <repository-url>
cd atividade
```

2. Configure o banco de dados MySQL:
- Crie um banco de dados chamado `user_auth_db` (ou use o nome que preferir)
- Atualize as credenciais do banco de dados no arquivo `src/main/resources/application.properties`

3. Compile e execute o projeto:
```bash
mvn clean install
mvn spring-boot:run
```

O servidor estará rodando em `http://localhost:8080`

## Endpoints da API

### Autenticação

1. Registrar novo usuário:
```bash
POST /api/auth/register
Content-Type: application/json

{
    "username": "user1",
    "email": "user1@example.com",
    "password": "password123"
}
```

2. Registrar novo admin:
```bash
POST /api/auth/register/admin
Content-Type: application/json

{
    "username": "admin1",
    "email": "admin1@example.com",
    "password": "password123"
}
```

3. Login:
```bash
POST /api/auth/login
Content-Type: application/json

{
    "username": "user1",
    "password": "password123"
}
```

### Gerenciamento de Usuários

1. Visualizar perfil (requer autenticação):
```bash
GET /api/users/profile
Authorization: Bearer <jwt-token>
```

2. Atualizar perfil (requer autenticação):
```bash
PUT /api/users/profile
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
    "username": "newusername",
    "email": "newemail@example.com",
    "password": "newpassword"
}
```

3. Listar todos os usuários (requer role ADMIN):
```bash
GET /api/users
Authorization: Bearer <jwt-token>
```

4. Visualizar usuário específico (requer role ADMIN ou ser o próprio usuário):
```bash
GET /api/users/{id}
Authorization: Bearer <jwt-token>
```

5. Atualizar usuário (requer role ADMIN):
```bash
PUT /api/users/{id}
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
    "username": "newusername",
    "email": "newemail@example.com",
    "password": "newpassword"
}
```

6. Deletar usuário (requer role ADMIN):
```bash
DELETE /api/users/{id}
Authorization: Bearer <jwt-token>
```

## Estrutura do Projeto

```
src/main/java/com/edu/atividade/
├── config/           # Configurações (Security, JWT)
├── controller/       # Controladores REST
├── dto/             # Objetos de transferência de dados
├── model/           # Entidades JPA
├── repository/      # Repositórios JPA
└── service/         # Lógica de negócio
```

## Segurança

- Autenticação baseada em JWT
- Senhas criptografadas com BCrypt
- Controle de acesso baseado em roles (ROLE_USER e ROLE_ADMIN)
- Validação de entrada de dados
- Proteção contra CSRF
- Headers de segurança configurados

## Desenvolvimento

O projeto foi desenvolvido seguindo as melhores práticas:
- Arquitetura em camadas (Controller, Service, Repository)
- Princípios SOLID
- Tratamento de exceções
- Validação de dados
- Documentação clara
- Código limpo e organizado 