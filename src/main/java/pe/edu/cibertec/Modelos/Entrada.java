package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "entrada")
public class Entrada {
    @Id
    private int id_entrada;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_compra")
    private Compra compra;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;
    private  int is_active;


    public Entrada() {
    }

    public Entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Entrada(int id_entrada, Compra compra, Funcion funcion, int is_active) {
        this.id_entrada = id_entrada;
        this.compra = compra;
        this.funcion = funcion;
        this.is_active = is_active;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id_entrada=" + id_entrada +
                ", compra=" + compra +
                ", funcion=" + funcion +
                ", is_active=" + is_active +
                '}';
    }
}
