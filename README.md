<p align="center">
  <img src="https://github.com/Regismrs/abrigo-seguro/raw/main/src/main/resources/static/images/logo.png" alt="Logo Abrigo Seguro" width="300">
</p>

# 🛟 Abrigo Seguro

> Um sistema web desenvolvido para auxiliar no cadastro e organização de pessoas em situação de abrigo durante desastres naturais.

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.2-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-template--engine-orange)
![Status](https://img.shields.io/badge/MVP-pronto-success)



## ✨ Sobre o Projeto

Durante as enchentes que atingiram o Rio Grande do Sul em maio de 2024, milhares de pessoas ficaram desabrigadas e foram acolhidas em abrigos improvisados. A falta de uma ferramenta unificada dificultou o controle de informações essenciais, como nomes, locais, contatos e dados familiares. Este projeto surge como uma iniciativa solidária para facilitar o registro e a consulta de pessoas abrigadas.



## 💻 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2**
- **Thymeleaf**
- **PostgreSQL**
- **Bootstrap 5**
- **Maven**
- **JPA / Hibernate**



## 🚀 Como Rodar o Projeto Localmente

### Pré-requisitos

- Java 17+
- PostgreSQL instalado e rodando
- IDE (IntelliJ, VS Code ou Eclipse)
- Git



### ⚙️ Passo a Passo

1. **Clone o repositório**

```bash
git clone https://github.com/Regismrs/abrigo-seguro.git
cd abrigo-seguro
```

2. **Configure o banco de dados**

- Crie o banco de dados manualmente no PostgreSQL:

```sql
CREATE DATABASE abrigoseguro;
```

3. **Configure o arquivo de ambiente**

- Renomeie o arquivo `application.yaml.example` para `application.yaml`:

```bash
mv src/main/resources/application.yaml.example src/main/resources/application.yaml
```

- No arquivo `application.yaml`, configure os dados de acesso ao banco de dados PostgreSQL:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/abrigoseguro
    username: seu_usuario
    password: sua_senha
```

4. **Compile e execute o projeto**

- Você pode rodar com sua IDE ou com o Maven no terminal:

```bash
./mvnw spring-boot:run
```

5. **Acesse a aplicação no navegador**

```
http://localhost:8080/abrigados
```



## 📸 Funcionalidades

- ✅ Cadastro de pessoas abrigadas
- ✅ Pesquisa por nome
- ✅ Paginação dos resultados
- ✅ Validação de CPF único
- ✅ Sugestão de cidades com datalist
- ✅ Páginas de erro personalizadas (404 e 500)
- ✅ Interface responsiva com Bootstrap



## 📂 Estrutura de Pastas (resumo)

```
abrigo-seguro/
├── src/
│   └── main/
│       ├── java/
│       │   └── ... (controllers, models, repositories)
│       └── resources/
│           ├── static/
│           │   ├── css/
│           │   └── images/
│           ├── templates/
│           │   └── pessoas/
│           └── application.yaml
└── pom.xml
```



## 📌 Observações

- O projeto está em estágio de MVP e aberto a colaborações.
- Desenvolvido com foco na simplicidade e rápida implantação em cenários de crise.
- Os dados utilizados são fictícios e voltados para testes.



## 🧑‍💻 Autor

Desenvolvido por **Regismrs**
📫 Contato: [github.com/Regismrs](https://github.com/Regismrs)



## 🧾 Licença

Este projeto está sob a licença MIT.  
Sinta-se livre para usar, modificar e compartilhar com os devidos créditos.
