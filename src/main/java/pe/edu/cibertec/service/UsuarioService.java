package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Usuario;
import pe.edu.cibertec.repository.UsuarioRepository;
import pe.edu.cibertec.response.AddUsuarioResponse;
import pe.edu.cibertec.response.DeleteUsuarioResponse;
import pe.edu.cibertec.response.FindUsuarioResponse;
import pe.edu.cibertec.response.UpdateUsuarioResponse;

import java.util.List;

@RestController
@RequestMapping("/Principal")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/Agregar")
    public AddUsuarioResponse agregarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getId_usuario() != 0) {
            return new AddUsuarioResponse("99", "El ID del usuario no debe estar presente para agregar un nuevo usuario");
        }

        usuarioRepository.save(usuario);
        return new AddUsuarioResponse("01", null);
    }

    @GetMapping("/Buscar")
    public FindUsuarioResponse buscarUsuario(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Usuario> usuarios;
        if (id > 0) {
            usuarios = usuarioRepository.findAllById(List.of(id));
        } else {
            usuarios = usuarioRepository.findAll();
        }
        return new FindUsuarioResponse("01", null, usuarios);
    }


    @PostMapping("/Actualizar")
    public UpdateUsuarioResponse actualizarUsuario(@RequestBody Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getId_usuario())) {
            return new UpdateUsuarioResponse("99", "El usuario no existe");
        }

        usuarioRepository.save(usuario);
        return new UpdateUsuarioResponse("01", null);
    }

    @DeleteMapping("/Eliminar")
    public DeleteUsuarioResponse eliminarUsuario(@RequestBody Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getId_usuario())) {
            return new DeleteUsuarioResponse("99", "El usuario no existe");
        }

        usuarioRepository.delete(usuario);
        return new DeleteUsuarioResponse("01", null);
    }
}
