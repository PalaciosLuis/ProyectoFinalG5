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
@Table(name = "distribuidora")
public class Distribuidora {

    @Id
    private int id_distribuidora;
    private String nombre_distribuidora;
    private int is_active;
    @OneToMany(mappedBy = "distribuidora", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pelicula> pelicula;

}
