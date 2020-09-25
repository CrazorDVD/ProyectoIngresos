/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoJPA;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres Daraviña
 */
@Entity
@Table(name = "entradassalidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradassalidas.findAll", query = "SELECT e FROM Entradassalidas e")
    , @NamedQuery(name = "Entradassalidas.findByIDEntradaSalida", query = "SELECT e FROM Entradassalidas e WHERE e.iDEntradaSalida = :iDEntradaSalida")
    , @NamedQuery(name = "Entradassalidas.findByFecha", query = "SELECT e FROM Entradassalidas e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Entradassalidas.findByHoraEntrada", query = "SELECT e FROM Entradassalidas e WHERE e.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Entradassalidas.findByHoraSalida", query = "SELECT e FROM Entradassalidas e WHERE e.horaSalida = :horaSalida")
    , @NamedQuery(name = "Entradassalidas.findByTemperatura", query = "SELECT e FROM Entradassalidas e WHERE e.temperatura = :temperatura")})
public class Entradassalidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEntradaSalida")
    private Integer iDEntradaSalida;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "HoraEntrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Column(name = "HoraSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "Temperatura")
    private String temperatura;
    @JoinColumn(name = "CedulaPersonal", referencedColumnName = "CedulaPersonal")
    @ManyToOne
    private Personal cedulaPersonal;
    @JoinColumn(name = "CedulaUsuario", referencedColumnName = "CedulaUsuarios")
    @ManyToOne
    private Usuarios cedulaUsuario;

    public Entradassalidas() {
    }

    public Entradassalidas(Integer iDEntradaSalida) {
        this.iDEntradaSalida = iDEntradaSalida;
    }

    public Integer getIDEntradaSalida() {
        return iDEntradaSalida;
    }

    public void setIDEntradaSalida(Integer iDEntradaSalida) {
        this.iDEntradaSalida = iDEntradaSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
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
        hash += (iDEntradaSalida != null ? iDEntradaSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradassalidas)) {
            return false;
        }
        Entradassalidas other = (Entradassalidas) object;
        if ((this.iDEntradaSalida == null && other.iDEntradaSalida != null) || (this.iDEntradaSalida != null && !this.iDEntradaSalida.equals(other.iDEntradaSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapeoJPA.Entradassalidas[ iDEntradaSalida=" + iDEntradaSalida + " ]";
    }
    
}
