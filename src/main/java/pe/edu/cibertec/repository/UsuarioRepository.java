package pe.edu.cibertec.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.Entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
