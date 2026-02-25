package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//03. Manipulando Streams
public class EjemploEstreams {
    public void muestraEjemplo() {
        List<String> nombres = Arrays.asList("Brenda", "Luis", "María", "Fernanda", "Eric", "Genesis");
//Todo depende de la secuencia que usemos por la API de stream
        nombres.stream()
                .sorted()
                .limit(5)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}
