package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
//    <T> T esto lo usamos para decir que estamos trabajando con tipos de datos genéricos
//    incluimos una clase de tipo Genérica "Class<T>" que va a llamarse clase
    <T> T obtenerDatos(String json, Class<T> clase);
}
