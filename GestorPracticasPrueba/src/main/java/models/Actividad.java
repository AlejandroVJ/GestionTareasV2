package models;

import java.util.Date;
import javax.persistence.Entity;
import models.Empresa;
import models.Profesor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import models.Alumno;
import models.Empresa;
import models.Profesor;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name="actividad")
public class Actividad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="horas")
    private Integer horas;
    @Column(name="incidencias")
    private String incidencias;
    @ManyToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    public Actividad() {
    }

    public Actividad(Integer id, String nombre, Date fecha, Integer horas, String incidencias, Alumno alumno) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horas = horas;
        this.incidencias = incidencias;
        this.alumno = alumno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", horas=" + horas + ", incidencias=" + incidencias + ", alumno=" + alumno + '}';
    }
    
    
    
    
    
}
