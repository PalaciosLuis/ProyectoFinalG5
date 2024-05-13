package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Usuario;

public record LoginResponse(String code, String error, String token, Usuario user) {
}
