
# MoveFlix - backend-etl


```md
# Backend ETL- MoveFlix

Este serviço executa o processo ETL

- Lê arquivos CSV do Data Lake
- Carrega os dados no PostgreSQL (schema `raw`)
- Aplica transformações e filtros (`datawarehouse`)
- Gera views no `datamart`

## Como rodar

### Docker
```bash
docker build -t moveflix-backend-etl .
docker run moveflix-backend-etl
````

### Maven (sem Docker)
```bash
mvn clean package
java -jar target/*.jar
````

### Variáveis de ambiente

SPRING_DATASOURCE_URL

SPRING_DATASOURCE_USERNAME

SPRING_DATASOURCE_PASSWORD

### Saída esperada

Tabelas preenchidas em raw e datawarehouse

Views criadas no datamart



