/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomas
 */
@Entity
@Table(name = "PROYECTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findById", query = "SELECT p FROM Proyectos p WHERE p.id = :id"),
    @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyectos.findByApellido", query = "SELECT p FROM Proyectos p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Proyectos.findByNombredelproyecto", query = "SELECT p FROM Proyectos p WHERE p.nombredelproyecto = :nombredelproyecto"),
    @NamedQuery(name = "Proyectos.findByDescripcion", query = "SELECT p FROM Proyectos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyectos.findByLocalidad", query = "SELECT p FROM Proyectos p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyectos.findByPresupuesto", query = "SELECT p FROM Proyectos p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "Proyectos.findByNumerodehabitantes", query = "SELECT p FROM Proyectos p WHERE p.numerodehabitantes = :numerodehabitantes")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 100)
    @Column(name = "NOMBREDELPROYECTO")
    private String nombredelproyecto;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 50)
    @Column(name = "PRESUPUESTO")
    private String presupuesto;
    @Column(name = "NUMERODEHABITANTES")
    private Integer numerodehabitantes;

    public Proyectos() {
    }

    public Proyectos(Integer id, String nombre, String apellido, String nombredelproyecto, String descripcion, String localidad, String presupuesto, Integer numerodehabitantes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombredelproyecto = nombredelproyecto;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.numerodehabitantes = numerodehabitantes;
    }

    public Proyectos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNombredelproyecto() {
        return nombredelproyecto;
    }

    public void setNombredelproyecto(String nombredelproyecto) {
        this.nombredelproyecto = nombredelproyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getNumerodehabitantes() {
        return numerodehabitantes;
    }

    public void setNumerodehabitantes(Integer numerodehabitantes) {
        this.numerodehabitantes = numerodehabitantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.proyecto.entity.Proyectos[ id=" + id + " ]";
    }
    
}
