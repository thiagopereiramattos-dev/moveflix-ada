# 🎬 MoveFlix - Projeto de Engenharia de Dados e DevOps

Este projeto simula o ciclo de vida completo de uma aplicação de dados, abrangendo desde a ingestão até a exposição via API.

Inclui:
- Aplicação web com backend REST em **Spring Boot**.
- Pipeline **CI/CD** usando **GitHub Actions**.
- Deploy com **Docker** e **Nginx** como proxy reverso.
- Simulação de um ecossistema de dados: **Data Lake → Data Warehouse → Data Mart**.

---

## 📂 Estrutura do Projeto

```plaintext
moveflix/
├── backend-api/       # API para consumo das visões do Data Mart
├── backend-etl/       # Job ETL que lê CSV, carrega e trata os dados
├── init.sql           # Script para criação de schemas e views no PostgreSQL
├── nginx/             # Configuração do Nginx como proxy reverso
├── docker-compose.yml # Orquestração dos serviços
└── .github/workflows/ci-cd.yml # Pipeline de CI/CD
```

---

## 🚀 Rodando Localmente

### 1. Requisitos
- **Docker**
- **Docker Compose**
- (Opcional) **Java 17+** + **Maven** (para builds locais sem Docker)

---

### 2. Subindo a Aplicação

#### 🔹 Opção 1: Usando `docker-compose`
```bash
git clone https://github.com/seu-usuario/moveflix.git
cd moveflix
cd backend-etl
mvn clean package

cd ../backend-api
mvn clean package
cd ..    [estar na pasta moveflix]
docker-compose up --build
```
- Nginx: [http://localhost](http://localhost)
- API: [http://localhost/moveflix](http://localhost/moveflix)

---

#### 🔹 Opção 2: Usando imagens do Docker Hub

**1. Subir o PostgreSQL**
```bash
docker run -d --name postgres-moveflix   -e POSTGRES_DB=moveflix   -e POSTGRES_USER=postgres   -e POSTGRES_PASSWORD=adminadmin   -p 5432:5432   postgres:15
```

**2. Rodar o ETL**
```bash
docker pull thiagomattos20/backend-etl:latest

docker run --rm   -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/moveflix   -e SPRING_DATASOURCE_USERNAME=postgres   -e SPRING_DATASOURCE_PASSWORD=adminadmin   thiagomattos20/backend-etl:latest
```

**3. Rodar a API**
```bash
docker pull thiagomattos20/backend-api:latest

docker run -d --name backend-api   -p 8080:8080   -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/moveflix   -e SPRING_DATASOURCE_USERNAME=postgres   -e SPRING_DATASOURCE_PASSWORD=adminadmin   thiagomattos20/backend-api:latest
```
👉 API disponível em: [http://localhost:8080/moveflix](http://localhost:8080/moveflix)

---

#### 🔹 Opção 3: Executar localmente com Java/Maven (sem Docker)

1. **Compile os projetos**
```bash
cd backend-etl
mvn clean package

cd ../backend-api
mvn clean package
```

2. **Execute o ETL**
```bash
java -jar backend-etl/target/*.jar
```

3. **Execute a API**
```bash
java -jar backend-api/target/*.jar
```

⚠️ **Lembre-se**: O PostgreSQL deve estar rodando localmente com o banco `moveflix` criado e os dados carregados (via ETL ou script `init.sql`).

---

## 🐘 Banco de Dados

- **DB:** PostgreSQL
- **Schemas:**
    - `raw` → dados brutos do CSV
    - `datawarehouse` → dados tratados
    - `datamart` → visões analíticas para negócio

---

## 📊 Fluxo de Dados

1. `backend-etl` lê arquivos **CSV** do **Data Lake**.
2. Carrega os dados no schema **raw**.
3. Aplica transformações e grava no schema **datawarehouse**.
4. Cria **views/tabelas** no **datamart**.
5. `backend-api` expõe **endpoints** que consultam o **datamart**.

---

## 🧪 CI/CD com GitHub Actions

Pipeline automatizado contendo:
- Build das aplicações
- Testes unitários
- Execução do ETL
- Build e push de imagens Docker para o **Docker Hub**
- Teste simples da API em container

---

## 🔗 Endpoints Principais

| Serviço      | URL                                                                                     |
| ------------ | --------------------------------------------------------------------------------------- |
| API          | [http://localhost/moveflix](http://localhost/moveflix)                                  |
| Health Check | [http://localhost/moveflix/actuator/health](http://localhost/moveflix/actuator/health)  |
| PG Admin     | (opcional, caso configurado)                                                            |

---

## 👨‍💻 Autor

**Thiago Pereira de Mattos**  
