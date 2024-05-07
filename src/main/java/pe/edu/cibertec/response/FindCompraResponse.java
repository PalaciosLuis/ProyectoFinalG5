package pe.edu.cibertec.response;

import pe.edu.cibertec.Entity.Compra;

public record FindCompraResponse(String code, String error, Iterable<Compra> compras) {
}
