package com.consultacarros.app.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaModelos(List<ResultadoPesquisaModelo> modelos) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de modelos: \n");
        for (ResultadoPesquisaModelo resultadoPesquisaModelo : modelos) {
            sb.append(resultadoPesquisaModelo.toString()).append("\n");
        }
        return sb.toString();
    }
}
