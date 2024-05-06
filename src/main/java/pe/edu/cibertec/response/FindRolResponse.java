package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Rol;

public record FindRolResponse(String code, String error, Iterable<Rol> roles) {
}
