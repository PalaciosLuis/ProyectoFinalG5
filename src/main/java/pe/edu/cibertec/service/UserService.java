package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Entity.Usuario;
import pe.edu.cibertec.repository.UsuarioRepository;
import pe.edu.cibertec.response.LoginResponse;
import pe.edu.cibertec.security.JWTAuthenticationConfig;

@RestController
@RequestMapping("/user")
public class UserService {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Usuario user) {

        Usuario userResult = userRepository.findByUser(user.getUser());

        if (userResult == null) {
            return new LoginResponse("99", "Usuario no encontrado", null);
        }

        if (!new BCryptPasswordEncoder().matches(user.getPassword(), userResult.getPassword())) {
            return new LoginResponse("99", "Password incorrecto", null);
        }
        String token = jwtAuthenticationConfig.getJWTToken(user.getUser());

        return new LoginResponse("01", null, token);


    }
}
