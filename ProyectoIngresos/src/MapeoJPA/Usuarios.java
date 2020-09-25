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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByCedulaUsuarios", query = "SELECT u FROM Usuarios u WHERE u.cedulaUsuarios = :cedulaUsuarios")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellido", query = "SELECT u FROM Usuarios u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuarios.findByCargo", query = "SELECT u FROM Usuarios u WHERE u.cargo = :cargo")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByCarnet", query = "SELECT u FROM Usuarios u WHERE u.carnet = :carnet")
    , @NamedQuery(name = "Usuarios.findByEliminado", query = "SELECT u FROM Usuarios u WHERE u.eliminado = :eliminado")})
public class Usuarios implements Serializable {

    @Basic(optional = false)
    @Column(name = "TipoDocumento")
    private String tipoDocumento;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Ciudad")
    private String ciudad;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CedulaUsuarios")
    private Integer cedulaUsuarios;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Carnet")
    private String carnet;
    @Column(name = "Eliminado")
    private String eliminado;
    @OneToMany(mappedBy = "cedulaUsuario")
    private Collection<Entradassalidas> entradassalidasCollection;
    @OneToMany(mappedBy = "cedulaUsuario")
    private Collection<Novedades> novedadesCollection;
    @JoinColumn(name = "IDPrograma", referencedColumnName = "IDPrograma")
    @ManyToOne
    private Programas iDPrograma;

    public Usuarios() {
    }

    public Usuarios(Integer cedulaUsuarios) {
        this.cedulaUsuarios = cedulaUsuarios;
    }

    public Integer getCedulaUsuarios() {
        return cedulaUsuarios;
    }

    public void setCedulaUsuarios(Integer cedulaUsuarios) {
        this.cedulaUsuarios = cedulaUsuarios;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
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

    public Programas getIDPrograma() {
        return iDPrograma;
    }

    public void setIDPrograma(Programas iDPrograma) {
        this.iDPrograma = iDPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaUsuarios != null ? cedulaUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.cedulaUsuarios == null && other.cedulaUsuarios != null) || (this.cedulaUsuarios != null && !this.cedulaUsuarios.equals(other.cedulaUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapeoJPA.Usuarios[ cedulaUsuarios=" + cedulaUsuarios + " ]";
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
