package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Distribuidora;
import pe.edu.cibertec.repository.DistribuidoraRepository;
import pe.edu.cibertec.response.AddDistribuidoraResponse;
import pe.edu.cibertec.response.DeleteDistribuidoraResponse;
import pe.edu.cibertec.response.FindDistribuidoraResponse;
import pe.edu.cibertec.response.UpdateDistribuidoraResponse;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class DistribuidoraService {

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    @PostMapping("/AgregarDistribuidora")
    public AddDistribuidoraResponse agregarDistribuidora(@RequestBody Distribuidora distribuidora) {
        if (distribuidora.getId_distribuidora() != 0) {
            return new AddDistribuidoraResponse("99", "El ID de la distribuidora no debe estar presente para agregar una nueva distribuidora");
        }

        distribuidoraRepository.save(distribuidora);
        return new AddDistribuidoraResponse("01", null);
    }

    @GetMapping("/BuscarDistribuidora")
    public FindDistribuidoraResponse buscarDistribuidora(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Distribuidora> distribuidoras;
        if (id > 0) {
            distribuidoras = distribuidoraRepository.findAllById(List.of(id));
        } else {
            distribuidoras = distribuidoraRepository.findAll();
        }
        return new FindDistribuidoraResponse("01", null, distribuidoras);
    }

    @PostMapping("/ActualizarDistribuidora")
    public UpdateDistribuidoraResponse actualizarDistribuidora(@RequestBody Distribuidora distribuidora) {
        if (!distribuidoraRepository.existsById(distribuidora.getId_distribuidora())) {
            return new UpdateDistribuidoraResponse("99", "La distribuidora no existe");
        }

        distribuidoraRepository.save(distribuidora);
        return new UpdateDistribuidoraResponse("01", null);
    }

    @DeleteMapping("/EliminarDistribuidora")
    public DeleteDistribuidoraResponse eliminarDistribuidora(@RequestBody Distribuidora distribuidora) {
        if (!distribuidoraRepository.existsById(distribuidora.getId_distribuidora())) {
            return new DeleteDistribuidoraResponse("99", "La distribuidora no existe");
        }

        distribuidoraRepository.delete(distribuidora);
        return new DeleteDistribuidoraResponse("01", null);
    }
}
