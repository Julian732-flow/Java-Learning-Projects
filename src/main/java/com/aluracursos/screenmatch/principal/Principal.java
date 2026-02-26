package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    //    Creamos constantes
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=401242af";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraELMenu() {
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar");
//        Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

//        Busca los datos de todas las temporadas

        List<DatosTemporadas> temporadas = new ArrayList<>();
        // Ciclo que recorre todas las temporadas y consulta datos de la API
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + "&Season=" + i + API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
//        temporadas.forEach(System.out::println);

// Mostrar solo el título de los episodios para las temporadas
// En esto trabajamps lista sobre listas

//        for (int i = 0; i < datos.totalDeTemporadas() ; i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

//Recurso mas legible para simplificar nuestro código for por medio de los lambdas
//       <----- LA COMENTAMOS PARA QUE NO NOS VUELVA A IMPRIMIR ----> temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista del tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
//Con el toList creamos una lista inmutable por el contrario si trabajamos en el "collect(Collectors.toList)"
// estamos colocando todos estos datos en una lista mutable
                .collect(Collectors.toList());

//        Top 5 episodios
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))//1. En esta linea filtramos los datos de la evaluacion que aparecian con N/A a darnos el valor de la calificación
        // 2. Ordenación: Se aplica un comparador basado en el atributo 'evaluacion'.
        // Se utiliza .reversed() para obtener un orden descendente (de mayor a menor puntaje).
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);

        // Convertimos los datos de las temporadas a una lista de objetos tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                /* Usamos flatMap para "aplanar".
                 * Básicamente sacamos todos los episodios de cada temporada y los metemos en una sola bolsa.
                 */
                .flatMap(t -> t.episodios().stream()
                        /* Mapeamos: Por cada dato suelto, creamos un objeto Episodio real.
                         * Le pasamos el número de temporada para que el episodio sepa a cuál pertenece.
                         */
                        .map(d->new Episodio(t.numero(),d)))
                // Guardamos todo el resultado en una lista común
                .collect(Collectors.toList());
        episodios.forEach(System.out::println);

//        Busqu3eda de episodios a patir de x año
        System.out.println("Indica el año a partir del cual deseas ver los episodios: ");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e ->e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                  "Temporada" + e.getTemporada() +
                    "Episodio" + e.getTitulo() +
                    "Fecha de lanzamiento" + e.getFechaDeLanzamiento().format(dtf)
                ));



    }
}
