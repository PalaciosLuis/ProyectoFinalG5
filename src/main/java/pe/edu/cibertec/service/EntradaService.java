package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Entrada;
import pe.edu.cibertec.repository.EntradaRepository;
import pe.edu.cibertec.response.AddEntradaResponse;
import pe.edu.cibertec.response.DeleteEntradaResponse;
import pe.edu.cibertec.response.FindEntradaResponse;
import pe.edu.cibertec.response.UpdateEntradaResponse;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @PostMapping("/AgregarEntrada")
    public AddEntradaResponse agregarEntrada(@RequestBody Entrada entrada) {
        if (entrada.getId_entrada() != 0) {
            return new AddEntradaResponse("99", "El ID de la entrada no debe estar presente para agregar una nueva entrada");
        }

        entradaRepository.save(entrada);
        return new AddEntradaResponse("01", null);
    }

    @GetMapping("/BuscarEntrada")
    public FindEntradaResponse buscarEntrada(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Entrada> entradas;
        if (id > 0) {
            entradas = entradaRepository.findAllById(List.of(id));
        } else {
            entradas = entradaRepository.findAll();
        }
        return new FindEntradaResponse("01", null, entradas);
    }

    @PostMapping("/ActualizarEntrada")
    public UpdateEntradaResponse actualizarEntrada(@RequestBody Entrada entrada) {
        if (!entradaRepository.existsById(entrada.getId_entrada())) {
            return new UpdateEntradaResponse("99", "La entrada no existe");
        }

        entradaRepository.save(entrada);
        return new UpdateEntradaResponse("01", null);
    }

    @DeleteMapping("/EliminarEntrada")
    public DeleteEntradaResponse eliminarEntrada(@RequestBody Entrada entrada) {
        if (!entradaRepository.existsById(entrada.getId_entrada())) {
            return new DeleteEntradaResponse("99", "La entrada no existe");
        }

        entradaRepository.delete(entrada);
        return new DeleteEntradaResponse("01", null);
    }
}
