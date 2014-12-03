/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.historic;

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
public class InformacionParadasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vehiculo")
    private int idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ruta")
    private int idRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private short orden;

    public InformacionParadasPK() {
    }

    public InformacionParadasPK(int idVehiculo, int idRuta, short orden) {
        this.idVehiculo = idVehiculo;
        this.idRuta = idRuta;
        this.orden = orden;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVehiculo;
        hash += (int) idRuta;
        hash += (int) orden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionParadasPK)) {
            return false;
        }
        InformacionParadasPK other = (InformacionParadasPK) object;
        if (this.idVehiculo != other.idVehiculo) {
            return false;
        }
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
        return "com.kradac.kbus.rest.entities.historic.InformacionParadasPK[ idVehiculo=" + idVehiculo + ", idRuta=" + idRuta + ", orden=" + orden + " ]";
    }
    
}
