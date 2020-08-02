# Tutorial Spring API, Postgres, Spring Data, Rest API
Crie a API CRUD Restful para um aplicativo simples de cliente e pets usando Spring Boot, Postgres e Spring data.

# Tecnologias
<b>Java - 1.8.x</b><br>
Java é o ambiente computacional, ou plataforma, criada pela empresa estadunidense Sun Microsystems, e vendida para a Oracle depois de alguns anos. A plataforma permite desenvolver programas utilizando a linguagem de programação Java.<br><br>

<b>Maven - 3.x.x</b><br>
Apache Maven, ou Maven, é uma ferramenta de automação de compilação utilizada primariamente em projetos Java. Ela é similar à ferramenta Ant, mas é baseada em conceitos e trabalhos diferentes em um modo diferente. Também é utilizada para construir e gerenciar projetos escritos em C#, Ruby, Scala e outras linguagens<br><br>

<b>Postgres - 5.x.x</b><br>
PostgreSQL é um sistema gerenciador de banco de dados objeto relacional, desenvolvido como projeto de código aberto<br><br>

<b>Spring boot - 2.3.2.RELEASE</b><br>
O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação. Ele consegue isso favorecendo a convenção sobre a configuração<br><br>

<b>Spring data - last version</b><br>
O Spring Data tem por objetivo facilitar nosso trabalho com persistência de dados de uma forma geral. E além do Spring Data JPA, ele possui vários outros projetos: Spring Data Commons<br><br>

<b>Lombok - last version</b> <br>
O Lombok é uma biblioteca Java focada em produtividade e redução de código boilerplate que, por meio de anotações adicionadas ao nosso código, ensinamos o compilador (maven ou gradle) durante o processo de compilação a criar código Java.<br><br>

<b>Swagger - last version</b><br>
Traduzido do inglês-O Swagger é um conjunto de ferramentas de software de código aberto para projetar, criar, documentar e usar serviços da Web RESTful, desenvolvidos pela SmartBear Software. Inclui documentação automatizada, geração de código e geração de casos de teste<br><br>

<b>Flyway - last version</b><br>
Traduzido do inglês-Flyway é uma ferramenta de migração de banco de dados de código aberto<br><br>

# Etapas para a instalação
<b>1. Clone o aplicativo</b>

git clone https://github.com/rafaelvulner/petz.git

<b>2. Caso queira rodar local crie um banco de dados Postgres na sua maquina</b>

Altere o nome de usuário e a senha do Postgres conforme sua instalação

abra src / main / recursos / application.properties

mude spring.datasource.username e spring.datasource.password conforme sua instalação do mysql

<b>3. Instale o Lombok na sua IDE conforme documentação: </b><br>
https://projectlombok.org/

<b>4. Crie e execute o aplicativo usando o maven</b><br>

pacote mvn

mvn spring-boot: run

O aplicativo começará a ser executado em http://localhost:8080.

<b>Para acessar sua documentação das Apis acesse:</b><br>
http://localhost:8080/swagger-ui.html

<b>Alguns exemplos</b><br>
O aplicativo define as seguintes APIs CRUD.

GET / cliente

POST / cliente / {DTO}

GET / cliente / {id}

PUT / cliente / {DTO}

DELETE / cliente / {id}<br>

Para saber sobre todos endpoints consultar o Swagger.

<b>O serviço também está hospedado no Heroku caso queira testar sem baixar o projeto</b><br>
https://apipetz.herokuapp.com/swagger-ui.html

