package com.aluracursos.screenmatch;
// https://start.spring.io/index.html es de donde sacamos el paquete para muestra API, es mucho mas Fácil.

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.EjemploEstreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    //Sobrescribimos con el método Run que nos sugirio el idea con el CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.muestraELMenu();

//        <-----------   Se comento por lo mismo poruqe es un ejemplo

//        EjemploEstreams ejemploEstreams = new EjemploEstreams();
//        ejemploEstreams.muestraEjemplo();    <----------


    }
}



//        Se elimina el código porque ya lo tenemos en la clase Principal

//        var consumoApi = new ConsumoApi();
//        var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=401242af");
//        System.out.println(json);
//        ConvierteDatos conversor = new ConvierteDatos();
////        con esta linea de código le estamos diciendo a nuestro conversor que pasamos de convertir datos genéricos como bananos y mangos a DatosSerie
//        var datos = conversor.obtenerDatos(json, DatosSerie.class);
//        System.out.println(datos);
//
//// 0.2 Modelando Episodios
//        json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=401242af");
//        DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
//        System.out.println(episodios);
//// fin del modelamiento de episodios y del codigo eliminado


//Lo aprendido en el modulo 01.

// Estructura de un Proyecto Spring: Observamos la estructura inicial de un proyecto Spring y discutimos sobre los paquetes, clases y el método run.
//Inferencia de Tipos en Java: Vimos un ejemplo práctico de inferencia de tipos con 'var' en el código Java.
//Consumo de API: Aprendimos a consumir APIs a través del método 'obtenerDatos', que devuelve los datos deseados en formato Json.
//Modularización de Código: Aprendimos la importancia de tener un código modularizado y de fácil mantenimiento.
//Serialización y Deserialización: Aprendimos cómo transformar JSON en clases y cómo esto es útil para el proyecto.

//Creación de Interfaces e Implementación de Métodos: Se demostró la creación de una interfaz con un
// método genérico que utiliza Generics, así como la implementación de este método en una clase separada.

//Inclusión de Nuevas Dependencias en el Proyecto: Vimos cómo agregar una nueva dependencia al archivo .pom.xml y cómo este proceso es gestionado por Maven.
