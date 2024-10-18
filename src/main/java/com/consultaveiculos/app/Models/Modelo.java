package com.consultaveiculos.app.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelo(
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("Valor") String valor,
        @JsonAlias("AnoModelo") int anoModelo,
        @JsonAlias("Combustivel") String combustivel) {

    @Override
    public String toString() {
        return modelo + ", Valor:" + valor + ", ano " + anoModelo + " - " + combustivel;
    }
}
