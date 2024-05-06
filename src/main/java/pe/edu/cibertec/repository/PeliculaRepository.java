package pe.edu.cibertec.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.Entity.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
}
