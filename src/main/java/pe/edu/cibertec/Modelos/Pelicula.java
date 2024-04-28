package pe.edu.cibertec.Modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    private int id_pelicula;
    private String titulo;
    private String sinopsis;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_distribuidora")
    private Distribuidora distribuidora;
    private String director;
    private double duracion;
    private int puntuacion;
    private int is_estreno;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_clasificacion")
    private Clasificacion clasificacion;
    private int is_active;

    @OneToMany(mappedBy = "pelicula", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Funcion> funcion;

    public Pelicula() {
    }

    public Pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Pelicula(int id_pelicula, String titulo, String sinopsis, Distribuidora distribuidora, String director, double duracion, int puntuacion, int is_estreno, Clasificacion clasificacion, int is_active, List<Funcion> funcion) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.distribuidora = distribuidora;
        this.director = director;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.is_estreno = is_estreno;
        this.clasificacion = clasificacion;
        this.is_active = is_active;
        this.funcion = funcion;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIs_estreno() {
        return is_estreno;
    }

    public void setIs_estreno(int is_estreno) {
        this.is_estreno = is_estreno;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public List<Funcion> getFuncion() {
        return funcion;
    }

    public void setFuncion(List<Funcion> funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id_pelicula=" + id_pelicula +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", distribuidora=" + distribuidora +
                ", director='" + director + '\'' +
                ", duracion=" + duracion +
                ", puntuacion=" + puntuacion +
                ", is_estreno=" + is_estreno +
                ", clasificacion=" + clasificacion +
                ", is_active=" + is_active +
                ", funcion=" + funcion +
                '}';
    }
}
