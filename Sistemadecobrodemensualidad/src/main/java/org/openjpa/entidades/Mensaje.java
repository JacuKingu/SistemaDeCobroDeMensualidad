package org.openjpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Mensaje.seleccionaTodos", 
                query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.seleccionaPorId",
                query = "SELECT m FROM Mensaje m WHERE m.mensajeId = :mensajeId"),
    @NamedQuery(name = "Mensaje.seleccionaPorFecha",
                query = "SELECT m FROM Mensaje m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Mensaje.seleccionaPorPersona",
                query = "SELECT m FROM Mensaje m WHERE m.persona = :persona")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mensaje_id", nullable = false)
    private Integer mensajeId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(length = 255)
    private String texto;
    @JoinColumn(name = "persona", referencedColumnName = "persona_id")
    @ManyToOne
    private Persona persona;

    public Mensaje() {
    }

    public Mensaje(String texto, Persona pPersona) {
        this.texto = texto;
        this.persona = pPersona;
    }

    public Mensaje(Integer mensajeId) {
        this.mensajeId = mensajeId;
    }

    public Integer getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Integer mensajeId) {
        this.mensajeId = mensajeId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajeId != null ? mensajeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.mensajeId == null && other.mensajeId != null) || (this.mensajeId != null && !this.mensajeId.equals(other.mensajeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openjpa.Mensaje[ mensajeId=" + mensajeId + " ]";
    }
    
}
