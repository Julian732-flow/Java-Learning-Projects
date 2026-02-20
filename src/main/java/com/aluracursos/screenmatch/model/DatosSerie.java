package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//esta anotación ---> @JsonIgnoreProperties <--- va a mapear todos los contenidos a false
//---> ignoreUnknown = true <--- que va a ignorar aquellos campos que no hemos mapeado dentro de esta clase
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosSerie(
//        JsonAlias solo nos permite leer que viene de nuestra API
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion){

//JsonProperty nos permite tanto leer como escribir
//        @JsonProperty("") {
}
//Continuidad a lo que estmos realizando
// Es momento de crear nuestro conversor que nos permita tranformar a
// nuestros tipo de dato a java que vienen de nuestra API