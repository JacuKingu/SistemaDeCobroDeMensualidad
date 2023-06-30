package org.openjpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.seleccionaPorApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id", nullable = false)
    private Integer personaId;
    @Column(length = 30)
    private String nombre;
    @Column(length = 60)
    private String apellidos;
    @Column(length = 50)
    private String correoElectronico;
    @Column(length = 100)
    private String direccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(length = 15)
    private String telefono;
    @OneToMany(mappedBy = "persona")
    private List<Mensaje> listaMensaje;

    public Persona() {
        this(null, null, null);
    }

    public Persona(String pNombre, String pApellidos, String pCorreoElectronico) {
        this.nombre = pNombre;
        this.apellidos = pApellidos;
        this.correoElectronico = pCorreoElectronico;
        this.direccion = "direccion S/N";
        this.fechaNacimiento = new Date(2005, 06, 15);
        this.telefono = "999999999";
    }

    public Persona(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Mensaje> getMensaje1Collection() {
        return listaMensaje;
    }

    public void setMensaje1Collection(List<Mensaje> mensaje1Collection) {
        this.listaMensaje = mensaje1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openjpa.Persona[ personaId=" + personaId + " ]";
    }
    
}
