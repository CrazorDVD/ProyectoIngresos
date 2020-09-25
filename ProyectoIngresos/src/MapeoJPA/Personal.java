/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres Daraviña
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByCedulaPersonal", query = "SELECT p FROM Personal p WHERE p.cedulaPersonal = :cedulaPersonal")
    , @NamedQuery(name = "Personal.findByUsername", query = "SELECT p FROM Personal p WHERE p.username = :username")
    , @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personal.findByApellido", query = "SELECT p FROM Personal p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Personal.findByContrase\u00f1a", query = "SELECT p FROM Personal p WHERE p.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Personal.findByCorreo", query = "SELECT p FROM Personal p WHERE p.correo = :correo")
    , @NamedQuery(name = "Personal.findByTelefono", query = "SELECT p FROM Personal p WHERE p.telefono = :telefono")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CedulaPersonal")
    private Integer cedulaPersonal;
    @Column(name = "Username")
    private String username;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(mappedBy = "cedulaPersonal")
    private Collection<Entradassalidas> entradassalidasCollection;
    @OneToMany(mappedBy = "cedulaPersonal")
    private Collection<Novedades> novedadesCollection;

    public Personal() {
    }

    public Personal(Integer cedulaPersonal) {
        this.cedulaPersonal = cedulaPersonal;
    }

    public Integer getCedulaPersonal() {
        return cedulaPersonal;
    }

    public void setCedulaPersonal(Integer cedulaPersonal) {
        this.cedulaPersonal = cedulaPersonal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Entradassalidas> getEntradassalidasCollection() {
        return entradassalidasCollection;
    }

    public void setEntradassalidasCollection(Collection<Entradassalidas> entradassalidasCollection) {
        this.entradassalidasCollection = entradassalidasCollection;
    }

    @XmlTransient
    public Collection<Novedades> getNovedadesCollection() {
        return novedadesCollection;
    }

    public void setNovedadesCollection(Collection<Novedades> novedadesCollection) {
        this.novedadesCollection = novedadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaPersonal != null ? cedulaPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.cedulaPersonal == null && other.cedulaPersonal != null) || (this.cedulaPersonal != null && !this.cedulaPersonal.equals(other.cedulaPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapeoJPA.Personal[ cedulaPersonal=" + cedulaPersonal + " ]";
    }
    
}
