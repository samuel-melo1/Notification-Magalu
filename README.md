# Envio de Notificação Microsserviços - Backend

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-257bd6?style=for-the-badge&logo=docker&logoColor=white)

Esse é um projeto construído em  **Java com Spring Boot, Spring Data Jpa, Spring Mail, RabbitMQ, Twillio API, Docker e PostgreSQL ** 

Projeto de um Microsserviços utilizando RabbitMQ, sendo possível a realização de envio de notificações. O projeto consiste em um agendamento de Notificação, essa notificação poderá ser SMS e EMAIL. Ao ser agendada a notificação, o sistema irá verificar o conteúdo da mensagem, identificando se será Email ou SMS. Após a identificação, um agendador irá executar de 1 em 1 minuto identificando as notificações que estão pendentes ou com erro e enviará novamente a mensagem para uma fila. Ao qual será processada e enviada para o destino.
## Table of Contents

- [Instalação](#instalação)
- [Usabilidade](#usabilidade)
- [API Endpoints](#api-endpoints)
- [Contribuição](#contribuição)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/samuel-melo1/helpdesk-backend
```
2. Instale o Docker na sua máquina (caso não tenha): https://www.docker.com/products/docker-desktop/
3. Instale o PostgreSQL ou utilize o banco de sua preferência: https://www.postgresql.org/download/ 

## Usabilidade
 
1. Baixe as imagens do Docker de cada projeto separadamente. Acesse o local de cada serviço e rode o docker build. Exemplo: docker build -t (nome da sua conta docker)/notification-sender:1.0.0 .

1. Após baixar as imagens do Docker, suba os containers utilizando o docker-compose up

2. As API's estarão disponíveis nas portas: 8080 e 8084. 

3. O RabbitMQ estará disponível na seguinte URL: http://localhost:15672/

## API Endpoints
A API possui os seguintes endpoints:

```markdown

POST /notifications -> Criar um agendamento de Notificação.

GET /notifications/{notificationId} - Buscar uma Notificação por Id. 

DELETE /notifications/{notificationId} - Deletar uma Notificação por Id. 

```

## Contribuição

Sugestões e/ou contribuições são bem-vindas! Se você encontrar qualquer questão ou tenha sugestões de melhorias, por favor, abra uma solicitação pull para o repositório. 


Ao contribuir para este projeto, siga o estilo de código existente, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em uma ramificação separada.
