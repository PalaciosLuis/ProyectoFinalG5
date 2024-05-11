package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Funcion;
import pe.edu.cibertec.repository.FuncionRepository;
import pe.edu.cibertec.response.AddFuncionResponse;
import pe.edu.cibertec.response.DeleteFuncionResponse;
import pe.edu.cibertec.response.FindFuncionResponse;
import pe.edu.cibertec.response.UpdateFuncionResponse;

import java.util.List;

@RestController
@RequestMapping("/funcion")
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    @PostMapping("/AgregarFuncion")
    public AddFuncionResponse agregarFuncion(@RequestBody Funcion funcion) {
        if (funcion.getId_funcion() != 0) {
            return new AddFuncionResponse("99", "El ID de la función no debe estar presente para agregar una nueva función");
        }

        funcionRepository.save(funcion);
        return new AddFuncionResponse("01", null);
    }

    @GetMapping("/BuscarFuncion")
    public FindFuncionResponse buscarFuncion(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Funcion> funciones;
        if (id > 0) {
            funciones = funcionRepository.findAllById(List.of(id));
        } else {
            funciones = funcionRepository.findAll();
        }
        return new FindFuncionResponse("01", null, funciones);
    }

    @PostMapping("/ActualizarFuncion")
    public UpdateFuncionResponse actualizarFuncion(@RequestBody Funcion funcion) {
        if (!funcionRepository.existsById(funcion.getId_funcion())) {
            return new UpdateFuncionResponse("99", "La función no existe");
        }

        funcionRepository.save(funcion);
        return new UpdateFuncionResponse("01", null);
    }

    @DeleteMapping("/EliminarFuncion")
    public DeleteFuncionResponse eliminarFuncion(@RequestBody Funcion funcion) {
        if (!funcionRepository.existsById(funcion.getId_funcion())) {
            return new DeleteFuncionResponse("99", "La función no existe");
        }

        funcionRepository.delete(funcion);
        return new DeleteFuncionResponse("01", null);
    }
}
