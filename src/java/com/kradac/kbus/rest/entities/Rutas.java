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
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findByIdRuta", query = "SELECT r FROM Rutas r WHERE r.idRuta = :idRuta"),
    @NamedQuery(name = "Rutas.findByCodRuta", query = "SELECT r FROM Rutas r WHERE r.codRuta = :codRuta"),
    @NamedQuery(name = "Rutas.findByRuta", query = "SELECT r FROM Rutas r WHERE r.ruta = :ruta"),
    @NamedQuery(name = "Rutas.findByLinea", query = "SELECT r FROM Rutas r WHERE r.linea = :linea"),
    @NamedQuery(name = "Rutas.findByTiempoSancion", query = "SELECT r FROM Rutas r WHERE r.tiempoSancion = :tiempoSancion"),
    @NamedQuery(name = "Rutas.findByIcono", query = "SELECT r FROM Rutas r WHERE r.icono = :icono"),
    @NamedQuery(name = "Rutas.findByColor", query = "SELECT r FROM Rutas r WHERE r.color = :color"),
    @NamedQuery(name = "Rutas.findByDistancia", query = "SELECT r FROM Rutas r WHERE r.distancia = :distancia"),
    @NamedQuery(name = "Rutas.findByVelocidadOperacion", query = "SELECT r FROM Rutas r WHERE r.velocidadOperacion = :velocidadOperacion"),
    @NamedQuery(name = "Rutas.findByVelocidadComercial", query = "SELECT r FROM Rutas r WHERE r.velocidadComercial = :velocidadComercial"),
    @NamedQuery(name = "Rutas.findByFechaHoraRegistro", query = "SELECT r FROM Rutas r WHERE r.fechaHoraRegistro = :fechaHoraRegistro")})
public class Rutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ruta")
    private Integer idRuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ruta")
    private String codRuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "linea")
    private int linea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_sancion")
    @Temporal(TemporalType.TIME)
    private Date tiempoSancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "icono")
    private String icono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distancia")
    private double distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad_operacion")
    private double velocidadOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad_comercial")
    private double velocidadComercial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<UltimoDatoSkps> ultimoDatoSkpsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private List<PuntoRutas> puntoRutasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private List<LineaRutas> lineaRutasList;

    public Rutas() {
    }

    public Rutas(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Rutas(Integer idRuta, String codRuta, String ruta, int linea, Date tiempoSancion, String icono, String color, double distancia, double velocidadOperacion, double velocidadComercial, Date fechaHoraRegistro) {
        this.idRuta = idRuta;
        this.codRuta = codRuta;
        this.ruta = ruta;
        this.linea = linea;
        this.tiempoSancion = tiempoSancion;
        this.icono = icono;
        this.color = color;
        this.distancia = distancia;
        this.velocidadOperacion = velocidadOperacion;
        this.velocidadComercial = velocidadComercial;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public String getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(String codRuta) {
        this.codRuta = codRuta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public Date getTiempoSancion() {
        return tiempoSancion;
    }

    public void setTiempoSancion(Date tiempoSancion) {
        this.tiempoSancion = tiempoSancion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getVelocidadOperacion() {
        return velocidadOperacion;
    }

    public void setVelocidadOperacion(double velocidadOperacion) {
        this.velocidadOperacion = velocidadOperacion;
    }

    public double getVelocidadComercial() {
        return velocidadComercial;
    }

    public void setVelocidadComercial(double velocidadComercial) {
        this.velocidadComercial = velocidadComercial;
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

    @XmlTransient
    public List<LineaRutas> getLineaRutasList() {
        return lineaRutasList;
    }

    public void setLineaRutasList(List<LineaRutas> lineaRutasList) {
        this.lineaRutasList = lineaRutasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Rutas[ idRuta=" + idRuta + " ]";
    }
    
}
