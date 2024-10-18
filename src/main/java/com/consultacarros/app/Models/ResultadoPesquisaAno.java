package com.consultacarros.app.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoPesquisaAno(@JsonAlias("codigo") String codigo,
                                   @JsonAlias("nome") String nomeCombustivel) {
    @Override
    public String toString() {
        return "Código: " + codigo + ", Combustível: " + nomeCombustivel;
    }
}
