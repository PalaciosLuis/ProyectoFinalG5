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
@Table(name = "clasificacion")
public class Clasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clasificacion;
    private String descripcion;
    private int is_active;
    @OneToMany(mappedBy = "clasificacion", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pelicula> pelicula;

}
