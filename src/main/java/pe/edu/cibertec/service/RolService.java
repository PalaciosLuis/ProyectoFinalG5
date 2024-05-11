package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Rol;
import pe.edu.cibertec.repository.RolRepository;
import pe.edu.cibertec.response.AddRolResponse;
import pe.edu.cibertec.response.DeleteRolResponse;
import pe.edu.cibertec.response.FindRolResponse;
import pe.edu.cibertec.response.UpdateRolResponse;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @PostMapping("/AgregarRol")
    public AddRolResponse agregarRol(@RequestBody Rol rol) {
        if (rol.getId_rol() != 0) {
            return new AddRolResponse("99", "El ID del rol no debe estar presente para agregar un nuevo rol");
        }

        rolRepository.save(rol);
        return new AddRolResponse("01", null);
    }

    @GetMapping("/BuscarRol")
    public FindRolResponse buscarRol(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Rol> roles;
        if (id > 0) {
            roles = rolRepository.findAllById(List.of(id));
        } else {
            roles = rolRepository.findAll();
        }
        return new FindRolResponse("01", null, roles);
    }

    @PostMapping("/ActualizarRol")
    public UpdateRolResponse actualizarRol(@RequestBody Rol rol) {
        if (!rolRepository.existsById(rol.getId_rol())) {
            return new UpdateRolResponse("99", "El rol no existe");
        }

        rolRepository.save(rol);
        return new UpdateRolResponse("01", null);
    }

    @DeleteMapping("/EliminarRol")
    public DeleteRolResponse eliminarRol(@RequestBody Rol rol) {
        if (!rolRepository.existsById(rol.getId_rol())) {
            return new DeleteRolResponse("99", "El rol no existe");
        }

        rolRepository.delete(rol);
        return new DeleteRolResponse("01", null);
    }
}
