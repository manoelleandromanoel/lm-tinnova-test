# lm-tinnova-test
- Teste de Desenvolvimento - Processo Seletivo Tinnova

## Tecnologias
- Ambiente de desenvolvimento (IDE): [IntelliJ](https://www.jetbrains.com/pt-br/idea/) Version: 2021.3.2 (Community Edition)
- Linguagem de programação: [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

[//]: # (- Banco de dados: [Postgres]&#40;https://www.h2database.com/html/main.html&#41; que é em memória, caso queira reinicializar os testes basta parar e subir a aplicação novamente. Para acessar o console do H2: http://localhost:9000/h2)
- Framework: [SpringBoot](https://spring.io/projects/spring-boot) 2.6.3
- Controle de dependências: [Maven](https://maven.apache.org/)

## Padrões
- [RESTful](https://blog.caelum.com.br/rest-principios-e-boas-praticas/)

## Exercícios
1 - Votos em relação ao total de eleitores (_org.example.lm.tinnova.test.Exercise_1_)

2 - Algoritmo de ordenação Bubble Sort (_org.example.lm.tinnova.test.Exercise_2_)

3 - Fatorial (_org.example.lm.tinnova.test.Exercise_3_)

4 - Soma dos multiplos de 3 ou 5 (_org.example.lm.tinnova.test.Exercise_4_)

5 - Cadastro de Veículos (_org.example.lm.tinnova.test.Exercise_5_)

## Rotas da API - Cadastro de Veículos
- GET /veiculos _Retorna todos os veículos_
- GET /veiculos/{id} _Retorna os detalhes do veículo_
- POST /veiculos _Adiciona um novo veículo_
- PUT /veiculos/{id} _Atualiza os dados de um veículo_
- PATCH /veiculos/{id} _Atualiza apenas alguns dados do veículo_
- DELETE /veiculos/{id} _Apaga o veículo_
- GET /veiculos/disponiveis _Exibe a informação de quantos veículos estão como não vendidos na base_
- GET /veiculos/fabricacao _Exibe a informação da distribuição de veículos por década de fabricação_
- GET /veiculos/fabricante _Exibe a informação da distribuição de veículos por fabricante_
- GET /veiculos/ultimaSemana _Exibe os carros registrados durante a última semana_