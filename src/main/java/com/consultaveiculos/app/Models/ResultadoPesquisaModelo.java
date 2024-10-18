package com.consultaveiculos.app.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoPesquisaModelo {
    String nome;
    int codigo;

    @JsonCreator
    public ResultadoPesquisaModelo(@JsonProperty("nome") String nome, @JsonProperty("codigo") int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Modelo: " + nome + ", Codigo: " + codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
