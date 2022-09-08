# Encurtador de URL

Este é um projeto teste para teste na Logique.

## IDE Utilizada 🖥️
Visutal Studio Code

## Tecnologia do Back-end
- Java 11
- Spring REST
- Spring Dev Tools
- Spring MongoDB
- Spring Web

## Tecnlogia do Front-end
- ReactJS
- NextJS
- TailwindCSS
- Axios

## Banco de Dados
- MongoDB

## Rodando a aplicação

Basta clonar este repositório.

```bash
$ git clone https://github.com/Darkisda/logique-audition.git
```

### Backend
Primeiro de tudo, tenha certeza que possui o Docker instalado, precisaremos dele para rodar o nosso banco de dados.

Para verificar que está com o Docker instalado, basta rodar no terminal:
```bash
$ docker --version
```

Com o Docker em mãos, basta seguir os passos a seguir:
- Entre no diretório `infra`
```bash
$ cd ./infra
```

Dentro do diretório de `infra`, basta rodar o comando:
```bash
$ docker-compose up
```
Este comando irá subir um baco de dados em MongoDB com todas as configurações que precisamos para rodar nossa aplicação.

Com o banco de dados ativo, navegaremos para o diretório da aplicação em Java, `url-shortener`
```bash
$ cd ./url-shortener
```
Dentro do diretório, basta rodar esses dois comandos da command line do Mavem:
```bash
./mvnw package clean # Para instalar as dependências também criar o package
```

```bash
./mvnw spring-boot:run # Para rodar a aplicação Spring
```

### Frontend

Antes de tudo verifique se tem o NodeJS instalado e se a versão é superior ou igual a `17.9.0`. Para verificar a versão do NodeJS, basta rodar:

```bash
$ node --version
```

Com tudo isso verificado, navegaremos para o diretório do `frontend`.

```bash
$ cd ./frontend
```

Dentro do diretório, precisamos instalar as dependências do node, para isso basta rodar o comando a seguir.

```bash
$ npm install # ou yarn
```

Com todas as dependências instaladas, basta rodar a aplicação.

```bash
$ npm run dev # ou yarn dev
```