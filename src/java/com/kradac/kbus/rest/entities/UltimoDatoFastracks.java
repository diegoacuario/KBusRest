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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ultimo_dato_fastracks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UltimoDatoFastracks.findAll", query = "SELECT u FROM UltimoDatoFastracks u"),
    @NamedQuery(name = "UltimoDatoFastracks.findByIdUltimoDatoFastrack", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.idUltimoDatoFastrack = :idUltimoDatoFastrack"),
    @NamedQuery(name = "UltimoDatoFastracks.findByFechaHoraUltDato", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.fechaHoraUltDato = :fechaHoraUltDato"),
    @NamedQuery(name = "UltimoDatoFastracks.findByLatitud", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.latitud = :latitud"),
    @NamedQuery(name = "UltimoDatoFastracks.findByLongitud", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.longitud = :longitud"),
    @NamedQuery(name = "UltimoDatoFastracks.findByVelocidad", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.velocidad = :velocidad"),
    @NamedQuery(name = "UltimoDatoFastracks.findByIpPublica", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.ipPublica = :ipPublica"),
    @NamedQuery(name = "UltimoDatoFastracks.findByIpEquipo", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.ipEquipo = :ipEquipo"),
    @NamedQuery(name = "UltimoDatoFastracks.findByTramaRestante", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.tramaRestante = :tramaRestante"),
    @NamedQuery(name = "UltimoDatoFastracks.findByDireccion", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "UltimoDatoFastracks.findByCantidadPasajeros", query = "SELECT u FROM UltimoDatoFastracks u WHERE u.cantidadPasajeros = :cantidadPasajeros")})
public class UltimoDatoFastracks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ultimo_dato_fastrack")
    private Integer idUltimoDatoFastrack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_ult_dato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraUltDato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad")
    private double velocidad;
    @Size(max = 45)
    @Column(name = "ip_publica")
    private String ipPublica;
    @Size(max = 45)
    @Column(name = "ip_equipo")
    private String ipEquipo;
    @Size(max = 45)
    @Column(name = "trama_restante")
    private String tramaRestante;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_pasajeros")
    private int cantidadPasajeros;
    @JoinColumn(name = "id_display", referencedColumnName = "id_display")
    @ManyToOne(optional = false)
    private Displays idDisplay;
    @JoinColumn(name = "id_encabezado", referencedColumnName = "id_encabezado")
    @ManyToOne(optional = false)
    private Encabezados idEncabezado;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipos idEquipo;
    @JoinColumn(name = "id_estado_bus", referencedColumnName = "id_estado_bus")
    @ManyToOne(optional = false)
    private EstadoBuses idEstadoBus;
    @JoinColumn(name = "id_estado_mecanico", referencedColumnName = "id_estado_mecanico")
    @ManyToOne(optional = false)
    private EstadoMecanicos idEstadoMecanico;
    @JoinColumn(name = "id_punto", referencedColumnName = "id_punto")
    @ManyToOne(optional = false)
    private Puntos idPunto;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;

    public UltimoDatoFastracks() {
    }

    public UltimoDatoFastracks(Integer idUltimoDatoFastrack) {
        this.idUltimoDatoFastrack = idUltimoDatoFastrack;
    }

    public UltimoDatoFastracks(Integer idUltimoDatoFastrack, Date fechaHoraUltDato, double latitud, double longitud, double velocidad, int cantidadPasajeros) {
        this.idUltimoDatoFastrack = idUltimoDatoFastrack;
        this.fechaHoraUltDato = fechaHoraUltDato;
        this.latitud = latitud;
        this.longitud = longitud;
        this.velocidad = velocidad;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getIdUltimoDatoFastrack() {
        return idUltimoDatoFastrack;
    }

    public void setIdUltimoDatoFastrack(Integer idUltimoDatoFastrack) {
        this.idUltimoDatoFastrack = idUltimoDatoFastrack;
    }

    public Date getFechaHoraUltDato() {
        return fechaHoraUltDato;
    }

    public void setFechaHoraUltDato(Date fechaHoraUltDato) {
        this.fechaHoraUltDato = fechaHoraUltDato;
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

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getIpPublica() {
        return ipPublica;
    }

    public void setIpPublica(String ipPublica) {
        this.ipPublica = ipPublica;
    }

    public String getIpEquipo() {
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }

    public String getTramaRestante() {
        return tramaRestante;
    }

    public void setTramaRestante(String tramaRestante) {
        this.tramaRestante = tramaRestante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Displays getIdDisplay() {
        return idDisplay;
    }

    public void setIdDisplay(Displays idDisplay) {
        this.idDisplay = idDisplay;
    }

    public Encabezados getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(Encabezados idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    public EstadoBuses getIdEstadoBus() {
        return idEstadoBus;
    }

    public void setIdEstadoBus(EstadoBuses idEstadoBus) {
        this.idEstadoBus = idEstadoBus;
    }

    public EstadoMecanicos getIdEstadoMecanico() {
        return idEstadoMecanico;
    }

    public void setIdEstadoMecanico(EstadoMecanicos idEstadoMecanico) {
        this.idEstadoMecanico = idEstadoMecanico;
    }

    public Puntos getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Puntos idPunto) {
        this.idPunto = idPunto;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUltimoDatoFastrack != null ? idUltimoDatoFastrack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UltimoDatoFastracks)) {
            return false;
        }
        UltimoDatoFastracks other = (UltimoDatoFastracks) object;
        if ((this.idUltimoDatoFastrack == null && other.idUltimoDatoFastrack != null) || (this.idUltimoDatoFastrack != null && !this.idUltimoDatoFastrack.equals(other.idUltimoDatoFastrack))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.UltimoDatoFastracks[ idUltimoDatoFastrack=" + idUltimoDatoFastrack + " ]";
    }
    
}
