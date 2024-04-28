package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private int id_usuario;
    private String user;
    private String password;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol")
    private Rol rol;
    private String nombre;
    private String apellido;
    private String email;
    private int is_active;
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Compra> compra;


    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String user, String password, Rol rol, String nombre, String apellido, String email, int is_active, List<Compra> compra) {
        this.id_usuario = id_usuario;
        this.user = user;
        this.password = password;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.is_active = is_active;
        this.compra = compra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public List<Compra> getCompra() {
        return compra;
    }

    public void setCompra(List<Compra> compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", is_active=" + is_active +
                ", compra=" + compra +
                '}';
    }
}
