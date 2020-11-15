este projeto foi construido com o Spring Tool Suite STS 3.8.4
usando o Spring Boot 2.3.6
com MYSQL 5

para acessar a documentacao da API pelo Swagger
acesse através do link
http://localhost:8080/swagger-ui.html

pagina inicial do sistema
http://localhost:8080/index.html

utilizei uma ferramenta de migracao de BD FlyWay
com esta ferramenta, quando for inicializada pela primeira vez,
a aplicacao gerará todas as tabelas do BD 
e populará alguns registros também
basta verificar os parametros no arquivo "application.properties" 
(database da URL, usuario e senha)