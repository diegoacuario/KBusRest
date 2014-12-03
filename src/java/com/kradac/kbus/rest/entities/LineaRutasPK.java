/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PRUEBA
 */
@Embeddable
public class LineaRutasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ruta")
    private int idRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;

    public LineaRutasPK() {
    }

    public LineaRutasPK(int idRuta, int orden) {
        this.idRuta = idRuta;
        this.orden = orden;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRuta;
        hash += (int) orden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaRutasPK)) {
            return false;
        }
        LineaRutasPK other = (LineaRutasPK) object;
        if (this.idRuta != other.idRuta) {
            return false;
        }
        if (this.orden != other.orden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.LineaRutasPK[ idRuta=" + idRuta + ", orden=" + orden + " ]";
    }
    
}
