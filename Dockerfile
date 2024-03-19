# Use a imagem base do OpenJDK para executar o serviço Clojure
FROM openjdk:11-jre-slim

#  /app
WORKDIR /app

# Copie o arquivo JAR do projeto para o diretório de trabalho no contêiner
COPY target/balance-service.jar .

# Exponha a porta 8080 do contêiner para acessar o serviço
EXPOSE 8080

# Comando para executar o serviço quando o contêiner for iniciado
CMD ["java", "-jar", "balance-service.jar"]