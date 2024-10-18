package com.consultaveiculos.app.Principal;

import com.consultaveiculos.app.Models.*;
import com.consultaveiculos.app.Service.ConsumoApi;
import com.consultaveiculos.app.Service.ConverteDados;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
        Scanner scanner = new Scanner(System.in);
        private final ConsumoApi consumo = new ConsumoApi();
        private final String API = "https://parallelum.com.br/fipe/api/v1/";
        private final ConverteDados conversor = new ConverteDados();
        private String json;

        Map<String, String> opcoes = Map.of(
                "1", "carros",
                "2", "motos",
                "3", "caminhoes"
        );

        public void exibirMenu() {
            System.out.println("Digite uma das opções para pesquisar:");
            System.out.println("1 - Carros");
            System.out.println("2 - Motos");
            System.out.println("3 - Caminhões");
            String opcao = scanner.nextLine();

            String tipoVeiculo = opcoes.get(opcao);

            // Request do String json
            json = consumo.obterDados(API + tipoVeiculo + "/marcas/");
            // Conversão para o record ListaMarcas, que é uma List<Marca>
            ListaMarcas listaDeMarcas = new ListaMarcas(conversor.obterDados(json, new TypeReference<List<Marca>>() {}));
            // Imprimindo marcas encontradas para o usuário
            listaDeMarcas.marcasLista().stream().forEach(System.out::println);

            System.out.println("Escolha a marca: (Digite o código)");
            String escolhaMarca = scanner.nextLine();

            // Request do String json
            json = consumo.obterDados(API + tipoVeiculo + "/marcas/" + escolhaMarca + "/modelos");
            // Conversão para o record ListaModelos, que é uma List<ResultadoPesquisaModelo>
            ListaModelos listaModelos = new ListaModelos(conversor.obterCampoEspecifico(json, "modelos", new TypeReference<List<ResultadoPesquisaModelo>>() {}));
            // Imprimindo modelos encontrados para o usuário
            listaModelos.modelos().stream().forEach(System.out::println);

            System.out.println("Escreva o nome do modelo para maior detalhe:");
            String modeloFiltroNome = scanner.nextLine();

            // Filtrando os modelos que contém o nome que o usuário inseriu
            List<ResultadoPesquisaModelo> resultadosFiltrados = listaModelos.modelos()
                .stream()
                .filter(modelo -> modelo.getNome().toUpperCase().contains(modeloFiltroNome.toUpperCase())
                ).collect(Collectors.toList());
            ListaModelos listaFiltrada = new ListaModelos(resultadosFiltrados);

            // Imprimindo a lista de modelos filtrados
            System.out.println(listaFiltrada);
            System.out.println("Escolha o número de um modelo para maior detalhe:");
            String modeloEscolhido = scanner.nextLine();

            // Pesquisando os anos disponíveis do modelo escolhido
            json = consumo.obterDados(API + tipoVeiculo + "/marcas/" + escolhaMarca + "/modelos/" + modeloEscolhido + "/anos/");
            // Conversão para o record ResultadoPesquisaAnos, que é uma List<ResultadoPesquisaAno>
            ResultadoPesquisaAnos resultadoPesquisaAnos = new ResultadoPesquisaAnos(conversor.obterDados(json, new TypeReference<List<ResultadoPesquisaAno>>() {}));

            // Para cada ano disponível do modelo, fazer uma api call e receber mais detalhes (Valor, ano, combustível...)
            List<Modelo> modelos = resultadoPesquisaAnos.anos()
                    .stream()
                    .map(ano -> {
                        json = consumo.obterDados(API + tipoVeiculo + "/marcas/" + escolhaMarca + "/modelos/" + modeloEscolhido + "/anos/" + ano.codigo());
                        return (conversor.obterDados(json, Modelo.class)); // Retorna o objeto Modelo
                    })
                    .collect(Collectors.toList());

            // Exibe os detalhes de todos os anos do modelo escolhido
            modelos.forEach(System.out::println);
        }
}
