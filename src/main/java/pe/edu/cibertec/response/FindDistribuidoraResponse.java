package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Distribuidora;

public record FindDistribuidoraResponse(String code, String error, Iterable<Distribuidora> distribuidoras) {
}
