package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosTemporadas(

        @JsonAlias("Season") Integer numero,
        @JsonAlias("Episodes") List<DatosEpisodio> episodios
) {
}
//En esta aula 02. lo aprendido:

//APIs y Consultas Detalladas: Descubrimos cómo trabajar con APIs para obtener información
// detallada y realizar consultas más específicas.

//Uso de Anotaciones @JsonAlias y @JsonIgnoreProperties: Exploramos la importancia de utilizar estas
// funciones para mapear la API a la aplicación.

//Creación de Métodos para Interacción con el Usuario:
// Creamos un método para mostrar el menú e interactuar con el usuario, permitiéndoles ingresar
//  el nombre de la serie que desean buscar.

//Manipulación de Datos de una API: Mostramos cómo importar y manipular datos de una API, en este caso,
// datos de series de televisión.

//Manipulación de Cadenas para Acceder a una API: Observamos cómo manipular cadenas para crear direcciones
// que la API entenderá y devolverá los datos deseados.

//Introducción a los Lambdas: Conocimos las Expresiones Lambda en Java, también conocidas como
//funciones anónimas que podemos usar para escribir código más eficiente.