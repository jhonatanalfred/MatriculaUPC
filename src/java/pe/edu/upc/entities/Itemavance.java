/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.entities;

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
 * @author luis
 */
@Entity
@Table(name = "itemavance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemavance.findAll", query = "SELECT i FROM Itemavance i"),
    @NamedQuery(name = "Itemavance.findByIditem", query = "SELECT i FROM Itemavance i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Itemavance.findByFecha", query = "SELECT i FROM Itemavance i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Itemavance.findByDescripcion", query = "SELECT i FROM Itemavance i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Itemavance.count", query = "SELECT COUNT(i) FROM Itemavance i")
})
public class Itemavance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem")
    private Integer iditem;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idtarea", referencedColumnName = "idtarea")
    @ManyToOne(optional = false)
    private Tarea idtarea;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Itemavance() {
    }

    public Itemavance(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tarea getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Tarea idtarea) {
        this.idtarea = idtarea;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemavance)) {
            return false;
        }
        Itemavance other = (Itemavance) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.entities.Itemavance[ iditem=" + iditem + " ]";
    }
    
}
