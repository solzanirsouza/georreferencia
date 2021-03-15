# Georreferencia
Projeto de exemplo de comunicação com Geocoding API do Google

###Criando Imagem da aplicação
Na raiz do projeto existe o arquivo Dockerfile que gera uma imagem Docker da aplicação.
Para criar a imagem da aplicação execute o seguinte comando na raiz do projeto:
```
sudo docker build -t georreferencia:1.0 .
```

####Importante
Antes de criar a imagem da aplicação deve-se alterar a configuração da base de dados, mais expecificamente o IP.
```
config:
    datasource:
      username: postgres
      password: postgres
      postgres:
          url: jdbc:postgresql://<IP DA SUA MÁQUINA>:15432/postgres
          driver-class-name: org.postgresql.Driver
```

Se estiver usando Linux execute o comando ``ifconfig`` para verificar o respectivo IP.

###Criação dos Contêineres

Ainda na raiz do projeto, existe um diretório com o nome de "outros", dentro dele existe o arquivo "docker-compose.yml",
este arquivo cria dois contêineres, o da própria aplicação e outro do postgres para gravação dos dados.

Na pasta outros execute o seguite comando:
```
sudo docker-compose up -d
```
Caso queria ver os logs dos contêineres remova o ``-d`` no final do comando. Com isso a aplicação está disponível para
testes.
