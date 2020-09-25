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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "programas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programas.findAll", query = "SELECT p FROM Programas p")
    , @NamedQuery(name = "Programas.findByIDPrograma", query = "SELECT p FROM Programas p WHERE p.iDPrograma = :iDPrograma")
    , @NamedQuery(name = "Programas.findByNombre", query = "SELECT p FROM Programas p WHERE p.nombre = :nombre")})
public class Programas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPrograma")
    private Integer iDPrograma;
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(mappedBy = "iDPrograma")
    private Collection<Usuarios> usuariosCollection;

    public Programas() {
    }

    public Programas(Integer iDPrograma) {
        this.iDPrograma = iDPrograma;
    }

    public Integer getIDPrograma() {
        return iDPrograma;
    }

    public void setIDPrograma(Integer iDPrograma) {
        this.iDPrograma = iDPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPrograma != null ? iDPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programas)) {
            return false;
        }
        Programas other = (Programas) object;
        if ((this.iDPrograma == null && other.iDPrograma != null) || (this.iDPrograma != null && !this.iDPrograma.equals(other.iDPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapeoJPA.Programas[ iDPrograma=" + iDPrograma + " ]";
    }
    
}
