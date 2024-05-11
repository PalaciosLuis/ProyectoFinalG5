package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Pelicula;
import pe.edu.cibertec.repository.PeliculaRepository;
import pe.edu.cibertec.response.AddPeliculaResponse;
import pe.edu.cibertec.response.DeletePeliculaResponse;
import pe.edu.cibertec.response.FindPeliculaResponse;
import pe.edu.cibertec.response.UpdatePelicula;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @PostMapping("/AgregarPelicula")
    public AddPeliculaResponse agregarPelicula(@RequestBody Pelicula pelicula) {
        if (pelicula.getId_pelicula() == 0) {
            peliculaRepository.save(pelicula);
            return new AddPeliculaResponse("01", null);
        } else {
            return new AddPeliculaResponse("99", "El ID de la película no debe estar presente para agregar una nueva película");
        }
    }

    @GetMapping("/BuscarPelicula")
    public FindPeliculaResponse buscarPelicula(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Pelicula> peliculas;
        if (id > 0) {
            peliculas = peliculaRepository.findAllById(List.of(id));
        } else {
            peliculas = peliculaRepository.findAll();
        }
        return new FindPeliculaResponse("01", null, peliculas);
    }

    @PostMapping("/ActualizarPelicula")
    public UpdatePelicula actualizarPelicula(@RequestBody Pelicula pelicula) {
        if (!peliculaRepository.existsById(pelicula.getId_pelicula())) {
            return new UpdatePelicula("99", "La película no existe");
        }
        peliculaRepository.save(pelicula);
        return new UpdatePelicula("01", null);
    }

    @DeleteMapping("/EliminarPelicula")
    public DeletePeliculaResponse eliminarPelicula(@RequestBody Pelicula pelicula) {
        if (!peliculaRepository.existsById(pelicula.getId_pelicula())) {
            return new DeletePeliculaResponse("99", "La película no existe");
        }
        peliculaRepository.delete(pelicula);
        return new DeletePeliculaResponse("01", null);
    }
}
