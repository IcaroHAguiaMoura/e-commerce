# E-commerce

#Projeto de Gestão de Pedidos com Fretes (Spring boot)

Este projeto é uma API RESTful desenvolvida em Spring Boot para gerenciar pedidos
com cálculos de frete, sendo ele Áereo ou Terrestre. Ele permite criar,Listar e alterar 
o status dos pedidos, utilizando diferentes estratégias de frete.

Neste projeto tambem implementamos os seguintes Design Patterns: State & Strategy
Sistema de e-commerce usando os seguintes design patterns: State & Strategy.

### Strategy
Utilizado para encapsular diferentes estratégias de cálculo de frete.

Utilizamos ele porque cada tipo de frete(ex: aéreo, terrestre) possui forma diferente de calculo.
Ao usar o **Strategy**, pode definir essa estratégia em classes separadas e trocar a lógica  sem
precisar alterar a classe principal(**Pedido**).

![image](https://github.com/user-attachments/assets/386d9754-aa19-4ede-99c0-2b80c626e500)


