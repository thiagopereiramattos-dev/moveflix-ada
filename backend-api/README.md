
# MoveFlix - backend-api


```md
# Backend API - MoveFlix

Este serviço expõe uma API REST com dados analíticos consumidos do Data Mart.

## Como rodar

### Docker
```bash
docker build -t moveflix-backend-api .
docker run -p 8080:8080 moveflix-backend-api
````

### Maven (sem Docker)
```bash
mvn clean spring-boot:run
````

### Endpoints principais

GET /moveflix/filmes/populares

GET /moveflix/usuarios/ativos

GET /moveflix/relatorios/...

### Variáveis de ambiente

SPRING_DATASOURCE_URL

SPRING_DATASOURCE_USERNAME

SPRING_DATASOURCE_PASSWORD





