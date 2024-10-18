package com.consultacarros.app.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Marca(String codigo, String nome) {
    @Override
    public String toString() {
        return "Marca: " + nome + " (" + "Código:" + codigo + ")";
    }
}
