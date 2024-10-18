package com.consultacarros.app.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoPesquisaAnos(List<ResultadoPesquisaAno> anos){
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado da pesquisa: ");
        for (ResultadoPesquisaAno ano : anos) {
            sb.append(ano).append("\n");
        }
        return sb.toString();
    }
}
