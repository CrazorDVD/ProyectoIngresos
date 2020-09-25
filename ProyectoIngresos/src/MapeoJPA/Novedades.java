/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres Daraviña
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedades.findAll", query = "SELECT n FROM Novedades n")
    , @NamedQuery(name = "Novedades.findByIDNovedad", query = "SELECT n FROM Novedades n WHERE n.iDNovedad = :iDNovedad")
    , @NamedQuery(name = "Novedades.findByTemperatura", query = "SELECT n FROM Novedades n WHERE n.temperatura = :temperatura")
    , @NamedQuery(name = "Novedades.findByEnfermedades", query = "SELECT n FROM Novedades n WHERE n.enfermedades = :enfermedades")
    , @NamedQuery(name = "Novedades.findByConviveME", query = "SELECT n FROM Novedades n WHERE n.conviveME = :conviveME")
    , @NamedQuery(name = "Novedades.findByUltimoSitio", query = "SELECT n FROM Novedades n WHERE n.ultimoSitio = :ultimoSitio")})
public class Novedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDNovedad")
    private Integer iDNovedad;
    @Column(name = "Temperatura")
    private Integer temperatura;
    @Column(name = "Enfermedades")
    private String enfermedades;
    @Column(name = "ConviveME")
    private String conviveME;
    @Column(name = "UltimoSitio")
    private String ultimoSitio;
    @JoinColumn(name = "CedulaPersonal", referencedColumnName = "CedulaPersonal")
    @ManyToOne
    private Personal cedulaPersonal;
    @JoinColumn(name = "CedulaUsuario", referencedColumnName = "CedulaUsuarios")
    @ManyToOne
    private Usuarios cedulaUsuario;

    public Novedades() {
    }

    public Novedades(Integer iDNovedad) {
        this.iDNovedad = iDNovedad;
    }

    public Integer getIDNovedad() {
        return iDNovedad;
    }

    public void setIDNovedad(Integer iDNovedad) {
        this.iDNovedad = iDNovedad;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getConviveME() {
        return conviveME;
    }

    public void setConviveME(String conviveME) {
        this.conviveME = conviveME;
    }

    public String getUltimoSitio() {
        return ultimoSitio;
    }

    public void setUltimoSitio(String ultimoSitio) {
        this.ultimoSitio = ultimoSitio;
    }

    public Personal getCedulaPersonal() {
        return cedulaPersonal;
    }

    public void setCedulaPersonal(Personal cedulaPersonal) {
        this.cedulaPersonal = cedulaPersonal;
    }

    public Usuarios getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(Usuarios cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDNovedad != null ? iDNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.iDNovedad == null && other.iDNovedad != null) || (this.iDNovedad != null && !this.iDNovedad.equals(other.iDNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapeoJPA.Novedades[ iDNovedad=" + iDNovedad + " ]";
    }
    
}
