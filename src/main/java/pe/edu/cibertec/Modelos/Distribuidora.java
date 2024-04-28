package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "distribuidora")
public class Distribuidora {
    @Id
    private int id_distribuidora;
    private String nombre_distribuidora;
    private int is_active;

    @OneToMany(mappedBy = "distribuidora", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pelicula> pelicula;

    public Distribuidora() {
    }

    public Distribuidora(int id_distribuidora) {
        this.id_distribuidora = id_distribuidora;
    }

    public Distribuidora(int id_distribuidora, String nombre_distribuidora, int is_active, List<Pelicula> pelicula) {
        this.id_distribuidora = id_distribuidora;
        this.nombre_distribuidora = nombre_distribuidora;
        this.is_active = is_active;
        this.pelicula = pelicula;
    }

    public int getId_distribuidora() {
        return id_distribuidora;
    }

    public void setId_distribuidora(int id_distribuidora) {
        this.id_distribuidora = id_distribuidora;
    }

    public String getNombre_distribuidora() {
        return nombre_distribuidora;
    }

    public void setNombre_distribuidora(String nombre_distribuidora) {
        this.nombre_distribuidora = nombre_distribuidora;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public List<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula(List<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Distribuidora{" +
                "id_distribuidora=" + id_distribuidora +
                ", nombre_distribuidora='" + nombre_distribuidora + '\'' +
                ", is_active=" + is_active +
                ", pelicula=" + pelicula +
                '}';
    }
}
