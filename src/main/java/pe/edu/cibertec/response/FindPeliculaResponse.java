package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Pelicula;

public record FindPeliculaResponse(String code, String error, Iterable<Pelicula> peliculas) {
}