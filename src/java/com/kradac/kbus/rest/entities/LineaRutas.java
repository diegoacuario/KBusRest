/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "linea_rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaRutas.findAll", query = "SELECT l FROM LineaRutas l"),
    @NamedQuery(name = "LineaRutas.findByIdRuta", query = "SELECT l FROM LineaRutas l WHERE l.lineaRutasPK.idRuta = :idRuta"),
    @NamedQuery(name = "LineaRutas.findByOrden", query = "SELECT l FROM LineaRutas l WHERE l.lineaRutasPK.orden = :orden"),
    @NamedQuery(name = "LineaRutas.findByLatitud", query = "SELECT l FROM LineaRutas l WHERE l.latitud = :latitud"),
    @NamedQuery(name = "LineaRutas.findByLongitud", query = "SELECT l FROM LineaRutas l WHERE l.longitud = :longitud")})
public class LineaRutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineaRutasPK lineaRutasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rutas rutas;

    public LineaRutas() {
    }

    public LineaRutas(LineaRutasPK lineaRutasPK) {
        this.lineaRutasPK = lineaRutasPK;
    }

    public LineaRutas(LineaRutasPK lineaRutasPK, double latitud, double longitud) {
        this.lineaRutasPK = lineaRutasPK;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public LineaRutas(int idRuta, int orden) {
        this.lineaRutasPK = new LineaRutasPK(idRuta, orden);
    }

    public LineaRutasPK getLineaRutasPK() {
        return lineaRutasPK;
    }

    public void setLineaRutasPK(LineaRutasPK lineaRutasPK) {
        this.lineaRutasPK = lineaRutasPK;
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

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaRutasPK != null ? lineaRutasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaRutas)) {
            return false;
        }
        LineaRutas other = (LineaRutas) object;
        if ((this.lineaRutasPK == null && other.lineaRutasPK != null) || (this.lineaRutasPK != null && !this.lineaRutasPK.equals(other.lineaRutasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.LineaRutas[ lineaRutasPK=" + lineaRutasPK + " ]";
    }
    
}
