package com.consultacarros.app.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // DESERIALIZA ARRAYS OU TIPOS COMPLEXOS
    public <T> T obterDados(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para extrair um campo específico e convertê-lo
    public <T> T obterCampoEspecifico(String json, String campo, Class<T> classe) {
        try {
            JsonNode node = mapper.readTree(json).get(campo); // Extrai o campo específico
            return mapper.treeToValue(node, classe);          // Converte o campo extraído
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para extrair um tipo complexo específico e convertê-lo
    public <T> T obterCampoEspecifico(String json, String campo, TypeReference<T> typeRef) {
        try {
            JsonNode node = mapper.readTree(json).get(campo); // Extrai o campo específico
            return mapper.readValue(node.toString(), typeRef); // Converte o campo extraído
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}