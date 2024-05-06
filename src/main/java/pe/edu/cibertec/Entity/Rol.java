package pe.edu.cibertec.Entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    private String nombre_rol;
    @OneToMany(mappedBy = "rol", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Usuario> usuario;

}
