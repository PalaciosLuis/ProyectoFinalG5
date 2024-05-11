package pe.edu.cibertec.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula;
    private String titulo;
    private String sinopsis;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_distribuidora")
    @JsonIgnore
    private Distribuidora distribuidora;
    private String director;
    private double duracion;
    private int puntuacion;
    private int is_estreno;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_clasificacion")
    @JsonIgnore
    private Clasificacion clasificacion;
    private int is_active;
    @OneToMany(mappedBy = "pelicula", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Funcion> funcion;

}
