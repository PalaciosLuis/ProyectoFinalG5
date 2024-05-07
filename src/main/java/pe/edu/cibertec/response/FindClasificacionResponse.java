package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Clasificacion;

public record FindClasificacionResponse(String code, String error, Iterable<Clasificacion> clasificaciones) {
}
