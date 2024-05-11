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
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private  Usuario usuario;

    private Date fecha_compra;
    private  int is_active;
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Entrada> entrada;

}
