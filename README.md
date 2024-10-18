# Desafio Java - Consulta de Veículos

Este projeto consiste em uma aplicação desenvolvida em Java, utilizando o framework Spring, para consultar o valor médio de veículos (carros, motos ou caminhões) de acordo com a tabela FIPE. O objetivo é replicar o fluxo de consulta do site da FIPE, implementando algumas melhorias na interação com o usuário.

## Objetivos do Projeto

- Permitir a escolha do tipo de veículo (carro, moto ou caminhão).
- Listar as marcas disponíveis para o tipo de veículo escolhido.
- Filtrar e listar os modelos de uma marca com base em um trecho do nome.
- Exibir as avaliações para todos os anos disponíveis de um modelo selecionado.

## Conceitos Aprendidos e Utilizados

- **Consumo de APIs**: A aplicação realiza chamadas a uma API externa para obter dados sobre marcas, modelos e avaliações de veículos.
- **Estruturas de Dados**: Utilização de listas e mapas para gerenciar informações sobre veículos e suas características.
- **Filtragem de Dados**: Aplicação de streams e filtros para permitir que o usuário busque modelos específicos através de trechos de nomes.
- **Jackson**: Uso da biblioteca Jackson para a desserialização de dados JSON, facilitando a manipulação das informações obtidas da API.
- **Interação com o Usuário**: Implementação de um menu interativo via terminal, utilizando a classe `Scanner` para capturar entradas do usuário.

## Como Executar o Projeto

1. Clone o repositório
2. Certifique-se de ter o Java e o Maven instalados.
3. Execute o projeto utilizando o comando:

   ```bash
   mvn spring-boot:run
    ```
4. Siga as instruções apresentadas no terminal para realizar consultas.

## Conclusão

Este desafio proporcionou uma excelente oportunidade para aplicar conceitos de programação em Java e desenvolvimento de aplicações com Spring, além de aprofundar conhecimentos em consumo de APIs e manipulação de dados.