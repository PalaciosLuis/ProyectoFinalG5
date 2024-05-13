package pe.edu.cibertec.Entity;

import java.util.Date;

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
@Table(name = "funcion")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcion;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;
    private Date fecha_funcion;
    private  int stock;
    private  int  sala;
    private  double precio;
    private  int  is_active;
    @OneToMany(mappedBy = "funcion", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<Entrada> entrada;

}
