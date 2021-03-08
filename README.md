# rmi-java
Atividade prática sobre JAVA-RMI

### Essa pequena aplicação é um exemplo de uso de RMI em Java.
- o "pratica 1" instancia um contador para cada conexão de tamanho aleatório

- o "pratica 2" é uma sistema de correção de questionários

## Requisitos:
> Ter o java instalado

### Como rodar:
#### Prática 1:
- Abra um terminal na pasta raiz do projeto

- Navegue até 

> pratica1/src/

- execute o comando

> rmiregistry &

- execute o server com o comando 

> java CounterServer

- depois execute o cliente com o comando

> java CounterCliente localhost

feito!

##### Pratica 2:

- Abra um terminal na pasta raiz do projeto

- Navegue até:

> pratica2/src/

- execute o comando 

> rmiregistry &

- execute o server com o comando

> java QuestionServer

- para rodar o cliente, é necessário um argumento a mais para rodar, esse argumento é formado pelas questões enviadas no formato "numero da questão;numero de alternativas;gabarito" . Por exemplo:

> java QuestionClient localhost "1:1:vvvvv"

###### Espero poder ter ajudado de alguma forma, fique à vontade para reproduzir o código e subir alterações
