package pe.edu.cibertec.Modelos;

import java.util.Date;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "funcion")
public class Funcion {
    @Id

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
    private List<Entrada> entrada;

    public Funcion() {
    }

    public Funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Funcion(int id_funcion, Pelicula pelicula, Date fecha_funcion, int stock, int sala, double precio, int is_active, List<Entrada> entrada) {
        this.id_funcion = id_funcion;
        this.pelicula = pelicula;
        this.fecha_funcion = fecha_funcion;
        this.stock = stock;
        this.sala = sala;
        this.precio = precio;
        this.is_active = is_active;
        this.entrada = entrada;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        return "Funcion{" +
                "id_funcion=" + id_funcion +
                ", pelicula=" + pelicula +
                ", fecha_funcion=" + fecha_funcion +
                ", stock=" + stock +
                ", sala=" + sala +
                ", precio=" + precio +
                ", is_active=" + is_active +
                ", entrada=" + entrada +
                '}';
    }
}
