package pe.edu.cibertec.Modelos;

import java.util.Date;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    private int id_compra;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private  Usuario usuario;
    private Date fecha_compra;
    private  int is_active;

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Entrada> entrada;




    public Compra() {
    }

    public Compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Compra(int id_compra, Usuario usuario, Date fecha_compra, int is_active, List<Entrada> entrada) {
        this.id_compra = id_compra;
        this.usuario = usuario;
        this.fecha_compra = fecha_compra;
        this.is_active = is_active;
        this.entrada = entrada;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public List<Entrada> getEntrada() {
        return entrada;
    }

    public void setEntrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id_compra=" + id_compra +
                ", usuario=" + usuario +
                ", fecha_compra=" + fecha_compra +
                ", is_active=" + is_active +
                ", entrada=" + entrada +
                '}';
    }
}
