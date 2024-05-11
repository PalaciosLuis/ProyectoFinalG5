package pe.edu.cibertec.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrada;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_compra")
    @JsonIgnore

    private Compra compra;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_funcion")
    @JsonIgnore
    private Funcion funcion;
    private  int is_active;

}
