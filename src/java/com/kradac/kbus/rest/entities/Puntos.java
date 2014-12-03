/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntos.findAll", query = "SELECT p FROM Puntos p"),
    @NamedQuery(name = "Puntos.findByIdPunto", query = "SELECT p FROM Puntos p WHERE p.idPunto = :idPunto"),
    @NamedQuery(name = "Puntos.findByPunto", query = "SELECT p FROM Puntos p WHERE p.punto = :punto"),
    @NamedQuery(name = "Puntos.findByGeocercaSkp", query = "SELECT p FROM Puntos p WHERE p.geocercaSkp = :geocercaSkp"),
    @NamedQuery(name = "Puntos.findByGeocercaFastrack", query = "SELECT p FROM Puntos p WHERE p.geocercaFastrack = :geocercaFastrack"),
    @NamedQuery(name = "Puntos.findByLatitud", query = "SELECT p FROM Puntos p WHERE p.latitud = :latitud"),
    @NamedQuery(name = "Puntos.findByLongitud", query = "SELECT p FROM Puntos p WHERE p.longitud = :longitud"),
    @NamedQuery(name = "Puntos.findByDireccion", query = "SELECT p FROM Puntos p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Puntos.findByFechaHoraRegistro", query = "SELECT p FROM Puntos p WHERE p.fechaHoraRegistro = :fechaHoraRegistro")})
public class Puntos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_punto")
    private Integer idPunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "punto")
    private String punto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "geocerca_skp")
    private String geocercaSkp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geocerca_fastrack")
    private int geocercaFastrack;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPunto")
    private List<UltimoDatoSkps> ultimoDatoSkpsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPunto")
    private List<PuntoRutas> puntoRutasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPunto")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;

    public Puntos() {
    }

    public Puntos(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Puntos(Integer idPunto, String punto, String geocercaSkp, int geocercaFastrack, double latitud, double longitud, Date fechaHoraRegistro) {
        this.idPunto = idPunto;
        this.punto = punto;
        this.geocercaSkp = geocercaSkp;
        this.geocercaFastrack = geocercaFastrack;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getGeocercaSkp() {
        return geocercaSkp;
    }

    public void setGeocercaSkp(String geocercaSkp) {
        this.geocercaSkp = geocercaSkp;
    }

    public int getGeocercaFastrack() {
        return geocercaFastrack;
    }

    public void setGeocercaFastrack(int geocercaFastrack) {
        this.geocercaFastrack = geocercaFastrack;
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

    @XmlTransient
    public List<UltimoDatoSkps> getUltimoDatoSkpsList() {
        return ultimoDatoSkpsList;
    }

    public void setUltimoDatoSkpsList(List<UltimoDatoSkps> ultimoDatoSkpsList) {
        this.ultimoDatoSkpsList = ultimoDatoSkpsList;
    }

    @XmlTransient
    public List<PuntoRutas> getPuntoRutasList() {
        return puntoRutasList;
    }

    public void setPuntoRutasList(List<PuntoRutas> puntoRutasList) {
        this.puntoRutasList = puntoRutasList;
    }

    @XmlTransient
    public List<UltimoDatoFastracks> getUltimoDatoFastracksList() {
        return ultimoDatoFastracksList;
    }

    public void setUltimoDatoFastracksList(List<UltimoDatoFastracks> ultimoDatoFastracksList) {
        this.ultimoDatoFastracksList = ultimoDatoFastracksList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPunto != null ? idPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntos)) {
            return false;
        }
        Puntos other = (Puntos) object;
        if ((this.idPunto == null && other.idPunto != null) || (this.idPunto != null && !this.idPunto.equals(other.idPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Puntos[ idPunto=" + idPunto + " ]";
    }
    
}
