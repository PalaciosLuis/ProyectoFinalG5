package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Funcion;

public record FindFuncionResponse(String code, String error, Iterable<Funcion> funciones) {
}
