package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//utilizamos el implements para implementar la clase de IConvierteDatos
public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();
//Nos arrojara un problema y el mismo idea con ayudara con el metodo
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
//        no nos retornara un valor null sino un ---> objectMapper.readValue(json,clase) <---
//        nos aparecesa un error en el ---> readValue <--- que tendra que ser tratada con un exception o un try - catch
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

