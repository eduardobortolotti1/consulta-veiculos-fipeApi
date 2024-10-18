package com.consultaveiculos.app.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaMarcas(List<Marca> marcasLista) {
    @Override
    public String toString() {
        return "Lista de marcas: \n" + marcasLista.toString();
    }
}
