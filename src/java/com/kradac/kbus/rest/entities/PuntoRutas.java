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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "punto_rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntoRutas.findAll", query = "SELECT p FROM PuntoRutas p"),
    @NamedQuery(name = "PuntoRutas.findByIdRuta", query = "SELECT p FROM PuntoRutas p WHERE p.puntoRutasPK.idRuta = :idRuta"),
    @NamedQuery(name = "PuntoRutas.findByOrden", query = "SELECT p FROM PuntoRutas p WHERE p.puntoRutasPK.orden = :orden"),
    @NamedQuery(name = "PuntoRutas.findByTiempos", query = "SELECT p FROM PuntoRutas p WHERE p.tiempos = :tiempos"),
    @NamedQuery(name = "PuntoRutas.findByTiemposPico", query = "SELECT p FROM PuntoRutas p WHERE p.tiemposPico = :tiemposPico"),
    @NamedQuery(name = "PuntoRutas.findByImprimir", query = "SELECT p FROM PuntoRutas p WHERE p.imprimir = :imprimir")})
public class PuntoRutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuntoRutasPK puntoRutasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempos")
    @Temporal(TemporalType.TIME)
    private Date tiempos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempos_pico")
    @Temporal(TemporalType.TIME)
    private Date tiemposPico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "imprimir")
    private short imprimir;
    @JoinColumn(name = "id_punto", referencedColumnName = "id_punto")
    @ManyToOne(optional = false)
    private Puntos idPunto;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rutas rutas;

    public PuntoRutas() {
    }

    public PuntoRutas(PuntoRutasPK puntoRutasPK) {
        this.puntoRutasPK = puntoRutasPK;
    }

    public PuntoRutas(PuntoRutasPK puntoRutasPK, Date tiempos, Date tiemposPico, short imprimir) {
        this.puntoRutasPK = puntoRutasPK;
        this.tiempos = tiempos;
        this.tiemposPico = tiemposPico;
        this.imprimir = imprimir;
    }

    public PuntoRutas(int idRuta, int orden) {
        this.puntoRutasPK = new PuntoRutasPK(idRuta, orden);
    }

    public PuntoRutasPK getPuntoRutasPK() {
        return puntoRutasPK;
    }

    public void setPuntoRutasPK(PuntoRutasPK puntoRutasPK) {
        this.puntoRutasPK = puntoRutasPK;
    }

    public Date getTiempos() {
        return tiempos;
    }

    public void setTiempos(Date tiempos) {
        this.tiempos = tiempos;
    }

    public Date getTiemposPico() {
        return tiemposPico;
    }

    public void setTiemposPico(Date tiemposPico) {
        this.tiemposPico = tiemposPico;
    }

    public short getImprimir() {
        return imprimir;
    }

    public void setImprimir(short imprimir) {
        this.imprimir = imprimir;
    }

    public Puntos getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Puntos idPunto) {
        this.idPunto = idPunto;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puntoRutasPK != null ? puntoRutasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntoRutas)) {
            return false;
        }
        PuntoRutas other = (PuntoRutas) object;
        if ((this.puntoRutasPK == null && other.puntoRutasPK != null) || (this.puntoRutasPK != null && !this.puntoRutasPK.equals(other.puntoRutasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.PuntoRutas[ puntoRutasPK=" + puntoRutasPK + " ]";
    }
    
}
