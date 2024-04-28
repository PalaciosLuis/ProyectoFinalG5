package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    private int id_clasificacion;
    private String descripcion;
    private int is_active;
    @OneToMany(mappedBy = "clasificacion", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pelicula> pelicula;

    public Clasificacion() {
    }

    public Clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public Clasificacion(int id_clasificacion, String descripcion, int is_active, List<Pelicula> pelicula) {
        this.id_clasificacion = id_clasificacion;
        this.descripcion = descripcion;
        this.is_active = is_active;
        this.pelicula = pelicula;
    }

    public int getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIs_active() {
        return is_active;
    }

    public List<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula(List<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;


    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "id_clasificacion=" + id_clasificacion +
                ", descripcion='" + descripcion + '\'' +
                ", is_active=" + is_active +
                ", pelicula=" + pelicula +
                '}';
    }
}
