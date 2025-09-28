FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/*.jar app.jar

# Define o comando de execução da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
