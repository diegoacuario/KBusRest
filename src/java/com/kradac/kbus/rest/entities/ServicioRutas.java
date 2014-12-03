/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "servicio_rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioRutas.findAll", query = "SELECT s FROM ServicioRutas s"),
    @NamedQuery(name = "ServicioRutas.findByIdServicioRuta", query = "SELECT s FROM ServicioRutas s WHERE s.idServicioRuta = :idServicioRuta"),
    @NamedQuery(name = "ServicioRutas.findByServicioRuta", query = "SELECT s FROM ServicioRutas s WHERE s.servicioRuta = :servicioRuta"),
    @NamedQuery(name = "ServicioRutas.findByDescripcion", query = "SELECT s FROM ServicioRutas s WHERE s.descripcion = :descripcion")})
public class ServicioRutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio_ruta")
    private Integer idServicioRuta;
    @Size(max = 45)
    @Column(name = "servicio_ruta")
    private String servicioRuta;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicioRuta")
    private List<Vehiculos> vehiculosList;

    public ServicioRutas() {
    }

    public ServicioRutas(Integer idServicioRuta) {
        this.idServicioRuta = idServicioRuta;
    }

    public Integer getIdServicioRuta() {
        return idServicioRuta;
    }

    public void setIdServicioRuta(Integer idServicioRuta) {
        this.idServicioRuta = idServicioRuta;
    }

    public String getServicioRuta() {
        return servicioRuta;
    }

    public void setServicioRuta(String servicioRuta) {
        this.servicioRuta = servicioRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicioRuta != null ? idServicioRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioRutas)) {
            return false;
        }
        ServicioRutas other = (ServicioRutas) object;
        if ((this.idServicioRuta == null && other.idServicioRuta != null) || (this.idServicioRuta != null && !this.idServicioRuta.equals(other.idServicioRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.ServicioRutas[ idServicioRuta=" + idServicioRuta + " ]";
    }
    
}
