/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "estaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estaciones.findAll", query = "SELECT e FROM Estaciones e"),
    @NamedQuery(name = "Estaciones.findByIdEstacion", query = "SELECT e FROM Estaciones e WHERE e.idEstacion = :idEstacion"),
    @NamedQuery(name = "Estaciones.findByCodigo", query = "SELECT e FROM Estaciones e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Estaciones.findByEstacion", query = "SELECT e FROM Estaciones e WHERE e.estacion = :estacion"),
    @NamedQuery(name = "Estaciones.findByLatitud", query = "SELECT e FROM Estaciones e WHERE e.latitud = :latitud"),
    @NamedQuery(name = "Estaciones.findByLongitud", query = "SELECT e FROM Estaciones e WHERE e.longitud = :longitud"),
    @NamedQuery(name = "Estaciones.findByDireccion", query = "SELECT e FROM Estaciones e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Estaciones.findByFechaHoraRegistro", query = "SELECT e FROM Estaciones e WHERE e.fechaHoraRegistro = :fechaHoraRegistro")})
public class Estaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estacion")
    private Integer idEstacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estacion")
    private String estacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;

    public Estaciones() {
    }

    public Estaciones(Integer idEstacion) {
        this.idEstacion = idEstacion;
    }

    public Estaciones(Integer idEstacion, String codigo, String estacion, double latitud, double longitud, Date fechaHoraRegistro) {
        this.idEstacion = idEstacion;
        this.codigo = codigo;
        this.estacion = estacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Integer idEstacion) {
        this.idEstacion = idEstacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacion != null ? idEstacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estaciones)) {
            return false;
        }
        Estaciones other = (Estaciones) object;
        if ((this.idEstacion == null && other.idEstacion != null) || (this.idEstacion != null && !this.idEstacion.equals(other.idEstacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Estaciones[ idEstacion=" + idEstacion + " ]";
    }
    
}
