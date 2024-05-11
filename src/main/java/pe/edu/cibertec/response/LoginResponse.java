package pe.edu.cibertec.response;

public record LoginResponse(String code, String error, String token) {
}
