package pe.edu.cibertec.Entity;

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
    private Compra compra;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;
    private  int is_active;

}
