# Balance Service

Este é um serviço RESTful para registrar operações bancárias e relatar o saldo de uma conta.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
balance-service/
├── src/
│ ├── balance_service/
│ │ ├── handlers.clj ; Handlers específicos para operações de transações
│ │ ├── transactions.clj ; Funções específicas para operações de transações
│ │ ├── service.clj ; Configuração do serviço Pedestal
├── test/
│ ├── balance_service/
│ │ ├── handlers_test.clj ; Testes unitários para handlers
├── README.md ; Documentação do projeto
├── Dockerfile ; Arquivo Docker para empacotar o serviço
├── project.clj ; Arquivo de configuração do Leiningen
├── .gitignore ; Arquivo de configuração do Git
```



## Como rodar o projeto
### Pré-requisitos

- Clojure instalado
- Leiningen instalado
- Docker instalado

### Compilando o Código

1. Clone este repositório:
2. Compile o código com Leiningen:
### Iniciando o Serviço

1. Depois de construir a imagem Docker, você pode iniciar o contêiner Docker com o seguinte comando:
```docker run -p 8080:8080 balance-service
```


Isso iniciará o serviço Clojure dentro de um contêiner Docker, acessível na porta 8080 do seu sistema local.

## Endpoints

- `PUT /api/accounts/{accountId}/transactions`: Registra uma nova operação bancária para uma conta.
- `GET /api/accounts/{accountId}`: Relata o saldo de uma conta.

## Formato do Payload

```json
{
  "operation": "credit",
  "operation_amount": 100,
  "authorized_at": 1706260776
}