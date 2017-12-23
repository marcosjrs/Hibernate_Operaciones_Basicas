package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_persona")
    private int idPersona;
    private String nombre;
    private String apellido;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    @Override
    public String toString() {
        return "Persona [apellido=" + apellido + ", idPersona=" + idPersona + ", nombre=" + nombre + "]";
    }
    
    
}
