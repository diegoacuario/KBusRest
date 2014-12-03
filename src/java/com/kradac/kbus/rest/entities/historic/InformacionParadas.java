/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.historic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "informacion_paradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionParadas.findAll", query = "SELECT i FROM InformacionParadas i"),
    @NamedQuery(name = "InformacionParadas.findByIdVehiculo", query = "SELECT i FROM InformacionParadas i WHERE i.informacionParadasPK.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "InformacionParadas.findByIdRuta", query = "SELECT i FROM InformacionParadas i WHERE i.informacionParadasPK.idRuta = :idRuta"),
    @NamedQuery(name = "InformacionParadas.findByIdParada", query = "SELECT i FROM InformacionParadas i WHERE i.idParada = :idParada"),
    @NamedQuery(name = "InformacionParadas.findByOrden", query = "SELECT i FROM InformacionParadas i WHERE i.informacionParadasPK.orden = :orden"),
    @NamedQuery(name = "InformacionParadas.findByHoraLlegada", query = "SELECT i FROM InformacionParadas i WHERE i.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "InformacionParadas.findByHoraArribo", query = "SELECT i FROM InformacionParadas i WHERE i.horaArribo = :horaArribo")})
public class InformacionParadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InformacionParadasPK informacionParadasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parada")
    private int idParada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_llegada")
    @Temporal(TemporalType.TIME)
    private Date horaLlegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_arribo")
    @Temporal(TemporalType.TIME)
    private Date horaArribo;

    public InformacionParadas() {
    }

    public InformacionParadas(InformacionParadasPK informacionParadasPK) {
        this.informacionParadasPK = informacionParadasPK;
    }

    public InformacionParadas(InformacionParadasPK informacionParadasPK, int idParada, Date horaLlegada, Date horaArribo) {
        this.informacionParadasPK = informacionParadasPK;
        this.idParada = idParada;
        this.horaLlegada = horaLlegada;
        this.horaArribo = horaArribo;
    }

    public InformacionParadas(int idVehiculo, int idRuta, short orden) {
        this.informacionParadasPK = new InformacionParadasPK(idVehiculo, idRuta, orden);
    }

    public InformacionParadasPK getInformacionParadasPK() {
        return informacionParadasPK;
    }

    public void setInformacionParadasPK(InformacionParadasPK informacionParadasPK) {
        this.informacionParadasPK = informacionParadasPK;
    }

    public int getIdParada() {
        return idParada;
    }

    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getHoraArribo() {
        return horaArribo;
    }

    public void setHoraArribo(Date horaArribo) {
        this.horaArribo = horaArribo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informacionParadasPK != null ? informacionParadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionParadas)) {
            return false;
        }
        InformacionParadas other = (InformacionParadas) object;
        if ((this.informacionParadasPK == null && other.informacionParadasPK != null) || (this.informacionParadasPK != null && !this.informacionParadasPK.equals(other.informacionParadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.historic.InformacionParadas[ informacionParadasPK=" + informacionParadasPK + " ]";
    }
    
}
