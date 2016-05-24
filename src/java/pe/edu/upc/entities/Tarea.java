/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author luis
 */
@Entity
@Table(name = "tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdtarea", query = "SELECT t FROM Tarea t WHERE t.idtarea = :idtarea"),
    @NamedQuery(name = "Tarea.findByNombre", query = "SELECT t FROM Tarea t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tarea.findByPrioridad", query = "SELECT t FROM Tarea t WHERE t.prioridad = :prioridad"),
    @NamedQuery(name = "Tarea.findByEstado", query = "SELECT t FROM Tarea t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tarea.findByFecharegistro", query = "SELECT t FROM Tarea t WHERE t.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "Tarea.findByFechaterminado", query = "SELECT t FROM Tarea t WHERE t.fechaterminado = :fechaterminado"),
    @NamedQuery(name = "Tarea.findEstadoRealizado", query = "SELECT t FROM Tarea t WHERE t.estado = \"Realizado\""),
    @NamedQuery(name = "Tarea.findEstadoNoRealizado", query = "SELECT t FROM Tarea t WHERE t.estado = \"No Realizado\"")})
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtarea")
    private Integer idtarea;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "prioridad")
    private String prioridad;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecharegistro")
    private String fecharegistro;
    @Basic(optional = false)
    @Column(name = "fechaterminado")
    private String fechaterminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarea")
    private Collection<Itemavance> itemavanceCollection;

    public Tarea() {
    }

    public Tarea(Integer idtarea) {
        this.idtarea = idtarea;
    }

    public Tarea(Integer idtarea, String nombre, String prioridad, String estado, String fecharegistro, String fechaterminado) {
        this.idtarea = idtarea;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.fechaterminado = fechaterminado;
    }

    public Integer getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Integer idtarea) {
        this.idtarea = idtarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getFechaterminado() {
        return fechaterminado;
    }

    public void setFechaterminado(String fechaterminado) {
        this.fechaterminado = fechaterminado;
    }

    @XmlTransient
    public Collection<Itemavance> getItemavanceCollection() {
        return itemavanceCollection;
    }

    public void setItemavanceCollection(Collection<Itemavance> itemavanceCollection) {
        this.itemavanceCollection = itemavanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarea != null ? idtarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.idtarea == null && other.idtarea != null) || (this.idtarea != null && !this.idtarea.equals(other.idtarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.entities.Tarea[ idtarea=" + idtarea + " ]";
    }
    
}
