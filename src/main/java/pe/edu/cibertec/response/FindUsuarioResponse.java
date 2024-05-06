package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Usuario;

public record FindUsuarioResponse(String code, String error, Iterable<Usuario> usuarios) {
}
