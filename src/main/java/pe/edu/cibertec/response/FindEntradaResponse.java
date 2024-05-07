package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Entrada;

public record FindEntradaResponse(String code, String error, Iterable<Entrada> entradas) {
}
