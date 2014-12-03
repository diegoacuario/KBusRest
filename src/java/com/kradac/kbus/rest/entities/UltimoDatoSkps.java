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
@Table(name = "ultimo_dato_skps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UltimoDatoSkps.findAll", query = "SELECT u FROM UltimoDatoSkps u"),
    @NamedQuery(name = "UltimoDatoSkps.findByIdUltimoDatoSkp", query = "SELECT u FROM UltimoDatoSkps u WHERE u.idUltimoDatoSkp = :idUltimoDatoSkp"),
    @NamedQuery(name = "UltimoDatoSkps.findByFechaHoraConex", query = "SELECT u FROM UltimoDatoSkps u WHERE u.fechaHoraConex = :fechaHoraConex"),
    @NamedQuery(name = "UltimoDatoSkps.findByFechaHoraUltDato", query = "SELECT u FROM UltimoDatoSkps u WHERE u.fechaHoraUltDato = :fechaHoraUltDato"),
    @NamedQuery(name = "UltimoDatoSkps.findByLatitud", query = "SELECT u FROM UltimoDatoSkps u WHERE u.latitud = :latitud"),
    @NamedQuery(name = "UltimoDatoSkps.findByLongitud", query = "SELECT u FROM UltimoDatoSkps u WHERE u.longitud = :longitud"),
    @NamedQuery(name = "UltimoDatoSkps.findByVelocidad", query = "SELECT u FROM UltimoDatoSkps u WHERE u.velocidad = :velocidad"),
    @NamedQuery(name = "UltimoDatoSkps.findByRumbo", query = "SELECT u FROM UltimoDatoSkps u WHERE u.rumbo = :rumbo"),
    @NamedQuery(name = "UltimoDatoSkps.findByG1", query = "SELECT u FROM UltimoDatoSkps u WHERE u.g1 = :g1"),
    @NamedQuery(name = "UltimoDatoSkps.findByG2", query = "SELECT u FROM UltimoDatoSkps u WHERE u.g2 = :g2"),
    @NamedQuery(name = "UltimoDatoSkps.findBySal", query = "SELECT u FROM UltimoDatoSkps u WHERE u.sal = :sal"),
    @NamedQuery(name = "UltimoDatoSkps.findByBateria", query = "SELECT u FROM UltimoDatoSkps u WHERE u.bateria = :bateria"),
    @NamedQuery(name = "UltimoDatoSkps.findByV1", query = "SELECT u FROM UltimoDatoSkps u WHERE u.v1 = :v1"),
    @NamedQuery(name = "UltimoDatoSkps.findByV2", query = "SELECT u FROM UltimoDatoSkps u WHERE u.v2 = :v2"),
    @NamedQuery(name = "UltimoDatoSkps.findByGsm", query = "SELECT u FROM UltimoDatoSkps u WHERE u.gsm = :gsm"),
    @NamedQuery(name = "UltimoDatoSkps.findByGps", query = "SELECT u FROM UltimoDatoSkps u WHERE u.gps = :gps"),
    @NamedQuery(name = "UltimoDatoSkps.findByIgn", query = "SELECT u FROM UltimoDatoSkps u WHERE u.ign = :ign"),
    @NamedQuery(name = "UltimoDatoSkps.findByDireccion", query = "SELECT u FROM UltimoDatoSkps u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "UltimoDatoSkps.findByCantidadPasajeros", query = "SELECT u FROM UltimoDatoSkps u WHERE u.cantidadPasajeros = :cantidadPasajeros")})
public class UltimoDatoSkps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ultimo_dato_skp")
    private Integer idUltimoDatoSkp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_conex")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraConex;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "rumbo")
    private double rumbo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "g1")
    private short g1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "g2")
    private short g2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sal")
    private short sal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bateria")
    private short bateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "v1")
    private short v1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "v2")
    private short v2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gsm")
    private short gsm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gps")
    private short gps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ign")
    private short ign;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_pasajeros")
    private int cantidadPasajeros;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipos idEquipo;
    @JoinColumn(name = "id_sky_evento", referencedColumnName = "id_sky_evento")
    @ManyToOne(optional = false)
    private SkyEventos idSkyEvento;
    @JoinColumn(name = "id_punto", referencedColumnName = "id_punto")
    @ManyToOne(optional = false)
    private Puntos idPunto;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;

    public UltimoDatoSkps() {
    }

    public UltimoDatoSkps(Integer idUltimoDatoSkp) {
        this.idUltimoDatoSkp = idUltimoDatoSkp;
    }

    public UltimoDatoSkps(Integer idUltimoDatoSkp, Date fechaHoraConex, Date fechaHoraUltDato, double latitud, double longitud, double velocidad, double rumbo, short g1, short g2, short sal, short bateria, short v1, short v2, short gsm, short gps, short ign, int cantidadPasajeros) {
        this.idUltimoDatoSkp = idUltimoDatoSkp;
        this.fechaHoraConex = fechaHoraConex;
        this.fechaHoraUltDato = fechaHoraUltDato;
        this.latitud = latitud;
        this.longitud = longitud;
        this.velocidad = velocidad;
        this.rumbo = rumbo;
        this.g1 = g1;
        this.g2 = g2;
        this.sal = sal;
        this.bateria = bateria;
        this.v1 = v1;
        this.v2 = v2;
        this.gsm = gsm;
        this.gps = gps;
        this.ign = ign;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getIdUltimoDatoSkp() {
        return idUltimoDatoSkp;
    }

    public void setIdUltimoDatoSkp(Integer idUltimoDatoSkp) {
        this.idUltimoDatoSkp = idUltimoDatoSkp;
    }

    public Date getFechaHoraConex() {
        return fechaHoraConex;
    }

    public void setFechaHoraConex(Date fechaHoraConex) {
        this.fechaHoraConex = fechaHoraConex;
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

    public double getRumbo() {
        return rumbo;
    }

    public void setRumbo(double rumbo) {
        this.rumbo = rumbo;
    }

    public short getG1() {
        return g1;
    }

    public void setG1(short g1) {
        this.g1 = g1;
    }

    public short getG2() {
        return g2;
    }

    public void setG2(short g2) {
        this.g2 = g2;
    }

    public short getSal() {
        return sal;
    }

    public void setSal(short sal) {
        this.sal = sal;
    }

    public short getBateria() {
        return bateria;
    }

    public void setBateria(short bateria) {
        this.bateria = bateria;
    }

    public short getV1() {
        return v1;
    }

    public void setV1(short v1) {
        this.v1 = v1;
    }

    public short getV2() {
        return v2;
    }

    public void setV2(short v2) {
        this.v2 = v2;
    }

    public short getGsm() {
        return gsm;
    }

    public void setGsm(short gsm) {
        this.gsm = gsm;
    }

    public short getGps() {
        return gps;
    }

    public void setGps(short gps) {
        this.gps = gps;
    }

    public short getIgn() {
        return ign;
    }

    public void setIgn(short ign) {
        this.ign = ign;
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

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    public SkyEventos getIdSkyEvento() {
        return idSkyEvento;
    }

    public void setIdSkyEvento(SkyEventos idSkyEvento) {
        this.idSkyEvento = idSkyEvento;
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
        hash += (idUltimoDatoSkp != null ? idUltimoDatoSkp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UltimoDatoSkps)) {
            return false;
        }
        UltimoDatoSkps other = (UltimoDatoSkps) object;
        if ((this.idUltimoDatoSkp == null && other.idUltimoDatoSkp != null) || (this.idUltimoDatoSkp != null && !this.idUltimoDatoSkp.equals(other.idUltimoDatoSkp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.UltimoDatoSkps[ idUltimoDatoSkp=" + idUltimoDatoSkp + " ]";
    }
    
}
