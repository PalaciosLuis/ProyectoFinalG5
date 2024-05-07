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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String user;
    private String password;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol")
    private Rol rol;
    private String nombre;
    private String apellido;
    private String email;
    private int is_active;
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Compra> compra;

}
