# Projeto da prova API Ecommerce
Este é um exemplo de aplicativo Java / Maven / Spring Boot com java 11, é um utilizado um ecomerce de games, esse aplicatiovo pode ser usado para adicionar e remover produtos em um carrinho de compras, e também listar produtos em ordem alfbética, por preço e por pontos.

## Sobre o serviço
O serviço é apenas um serviço REST de um ecomerce de games. Ele usa um banco de dados na memória (H2) para armazenar os dados. Você pode chamar alguns terminais REST definidas no projeto, baxando e executando em uma IDE para java. (ver abaixo, as urls para rodar localmente)

## Listar produtos e ordenar por preço, por score ou por ordem alfabética:

Ordenar por preço:
http://localhost:8080/product/order-price

Ordenar por pontos: 
http://localhost:8080/product/order-score

Ordem Alfabética:
http://localhost:8080/product/order-alphabetic

## Carrinho de compras, adicionar, remover, e carrinho:

Ver o carrinho:
http://localhost:8080/cart

Adicionar um produto no carrinho:
http://localhost:8080/cart/add/{id}

Remover um produto do carrinho:
http://localhost:8080/cart/remove/{id}

## Para melhores testes dos endpoins foi adicionado o swagger e o springfox, pode ser acessado na url abaixo:

http://localhost:8080/swagger-ui.html

## O banco de dados H2 pode ser acessado da url abaixo pra SELECT dos produtos cadastrados.
http://localhost:8080/h2-console

Os produtos são adicionado no banco assim que o sistema inicia, através de um componente.
Projeto realizado com Spring boot, hibernate e JPA.

## Após baixar o projeto e acessar por linha de comando a mesma pasta, é possível ustilizar o comando abaixo para criar um jar execultável da aplicação:

./mvnw clean package

## É possível rodar aplicação com o comando:
Java -jar ecommerce-game-0.0.1-SNAPSHOT.jar.Java

## Para a realização desse comando é nescessário tem o java e o mavem instalado, e também as váriaveis de ambientes configuradas.

