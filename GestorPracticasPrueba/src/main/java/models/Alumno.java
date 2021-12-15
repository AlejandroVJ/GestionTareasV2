package models;

import java.util.Date;
import javax.persistence.Entity;
import models.Empresa;
import models.Profesor;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import models.Empresa;
import models.Profesor;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="contraseña")
    private String contraseña;
    @Column(name="DNI")
    private String DNI;
    @Column(name="fecha_Nacimiento")
    private Date fechaNacimiento;
    @Column(name="email")
    private String email;
    @Column(name="telefono")
    private Integer telefono;
    @Column(name="horas_DUAL")
    private Integer horasDUAL;
    @Column(name="horas_FCT")
    private Integer horasFCT;
    @Column(name="observaciones")
    private String Observaciones;
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;
    
    @OneToMany( mappedBy="alumno", fetch=FetchType.EAGER)
    private Set<Actividad> actividades;
    
    
    public Alumno() {
    }
    

    public Alumno(Integer id, String nombre, String apellidos, String contraseña, String DNI, Date fechaNacimiento, String email, Integer telefono, Integer horasDUAL, Integer horasFCT, String Observaciones, Profesor profesor, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.horasDUAL = horasDUAL;
        this.horasFCT = horasFCT;
        this.Observaciones = Observaciones;
        this.profesor = profesor;
        this.empresa = empresa;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getHorasDUAL() {
        return horasDUAL;
    }

    public void setHorasDUAL(Integer horasDUAL) {
        this.horasDUAL = horasDUAL;
    }

    public Integer getHorasFCT() {
        return horasFCT;
    }

    public void setHorasFCT(Integer horasFCT) {
        this.horasFCT = horasFCT;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contraseña=" + contraseña + ", DNI=" + DNI + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", telefono=" + telefono + ", horasDUAL=" + horasDUAL + ", horasFCT=" + horasFCT + ", Observaciones=" + Observaciones + ", profesor=" + profesor + ", empresa=" + empresa + '}';
    }
    

    
    
    
    
}
