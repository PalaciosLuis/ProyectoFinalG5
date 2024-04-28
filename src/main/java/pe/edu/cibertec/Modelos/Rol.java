package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    private int id_rol;
    private String nombre_rol;
    @OneToMany(mappedBy = "rol", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Usuario> usuario;

    public Rol() {
    }

    public Rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public Rol(int id_rol, String nombre_rol, List<Usuario> usuario) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.usuario = usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id_rol=" + id_rol +
                ", nombre_rol='" + nombre_rol + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
