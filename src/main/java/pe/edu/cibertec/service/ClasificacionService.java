package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Clasificacion;
import pe.edu.cibertec.repository.ClasificacionRepository;
import pe.edu.cibertec.response.AddClasificacionResponse;
import pe.edu.cibertec.response.DeleteClasificacionResponse;
import pe.edu.cibertec.response.FindClasificacionResponse;
import pe.edu.cibertec.response.UpdateClasificacionResponse;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class ClasificacionService {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @PostMapping("/AgregarClasificacion")
    public AddClasificacionResponse agregarClasificacion(@RequestBody Clasificacion clasificacion) {
        if (clasificacion.getId_clasificacion() != 0) {
            return new AddClasificacionResponse("99", "El ID de la clasificación no debe estar presente para agregar una nueva clasificación");
        }

        clasificacionRepository.save(clasificacion);
        return new AddClasificacionResponse("01", null);
    }

    @GetMapping("/BuscarClasificacion")
    public FindClasificacionResponse buscarClasificacion(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Clasificacion> clasificaciones;
        if (id > 0) {
            clasificaciones = clasificacionRepository.findAllById(List.of(id));
        } else {
            clasificaciones = clasificacionRepository.findAll();
        }
        return new FindClasificacionResponse("01", null, clasificaciones);
    }

    @PostMapping("/ActualizarClasificacion")
    public UpdateClasificacionResponse actualizarClasificacion(@RequestBody Clasificacion clasificacion) {
        if (!clasificacionRepository.existsById(clasificacion.getId_clasificacion())) {
            return new UpdateClasificacionResponse("99", "La clasificación no existe");
        }

        clasificacionRepository.save(clasificacion);
        return new UpdateClasificacionResponse("01", null);
    }

    @DeleteMapping("/EliminarClasificacion")
    public DeleteClasificacionResponse eliminarClasificacion(@RequestBody Clasificacion clasificacion) {
        if (!clasificacionRepository.existsById(clasificacion.getId_clasificacion())) {
            return new DeleteClasificacionResponse("99", "La clasificación no existe");
        }

        clasificacionRepository.delete(clasificacion);
        return new DeleteClasificacionResponse("01", null);
    }
}
