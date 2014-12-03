/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "sky_eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkyEventos.findAll", query = "SELECT s FROM SkyEventos s"),
    @NamedQuery(name = "SkyEventos.findByIdSkyEvento", query = "SELECT s FROM SkyEventos s WHERE s.idSkyEvento = :idSkyEvento"),
    @NamedQuery(name = "SkyEventos.findByEvento", query = "SELECT s FROM SkyEventos s WHERE s.evento = :evento"),
    @NamedQuery(name = "SkyEventos.findByParametro", query = "SELECT s FROM SkyEventos s WHERE s.parametro = :parametro"),
    @NamedQuery(name = "SkyEventos.findBySkyEvento", query = "SELECT s FROM SkyEventos s WHERE s.skyEvento = :skyEvento"),
    @NamedQuery(name = "SkyEventos.findByAcronimo", query = "SELECT s FROM SkyEventos s WHERE s.acronimo = :acronimo"),
    @NamedQuery(name = "SkyEventos.findByColor", query = "SELECT s FROM SkyEventos s WHERE s.color = :color"),
    @NamedQuery(name = "SkyEventos.findByObservacion", query = "SELECT s FROM SkyEventos s WHERE s.observacion = :observacion"),
    @NamedQuery(name = "SkyEventos.findByMensaje", query = "SELECT s FROM SkyEventos s WHERE s.mensaje = :mensaje")})
public class SkyEventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sky_evento")
    private Integer idSkyEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evento")
    private short evento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parametro")
    private short parametro;
    @Size(max = 100)
    @Column(name = "sky_evento")
    private String skyEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "acronimo")
    private String acronimo;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @Size(max = 255)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 150)
    @Column(name = "mensaje")
    private String mensaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSkyEvento")
    private List<UltimoDatoSkps> ultimoDatoSkpsList;

    public SkyEventos() {
    }

    public SkyEventos(Integer idSkyEvento) {
        this.idSkyEvento = idSkyEvento;
    }

    public SkyEventos(Integer idSkyEvento, short evento, short parametro, String acronimo) {
        this.idSkyEvento = idSkyEvento;
        this.evento = evento;
        this.parametro = parametro;
        this.acronimo = acronimo;
    }

    public Integer getIdSkyEvento() {
        return idSkyEvento;
    }

    public void setIdSkyEvento(Integer idSkyEvento) {
        this.idSkyEvento = idSkyEvento;
    }

    public short getEvento() {
        return evento;
    }

    public void setEvento(short evento) {
        this.evento = evento;
    }

    public short getParametro() {
        return parametro;
    }

    public void setParametro(short parametro) {
        this.parametro = parametro;
    }

    public String getSkyEvento() {
        return skyEvento;
    }

    public void setSkyEvento(String skyEvento) {
        this.skyEvento = skyEvento;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @XmlTransient
    public List<UltimoDatoSkps> getUltimoDatoSkpsList() {
        return ultimoDatoSkpsList;
    }

    public void setUltimoDatoSkpsList(List<UltimoDatoSkps> ultimoDatoSkpsList) {
        this.ultimoDatoSkpsList = ultimoDatoSkpsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkyEvento != null ? idSkyEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkyEventos)) {
            return false;
        }
        SkyEventos other = (SkyEventos) object;
        if ((this.idSkyEvento == null && other.idSkyEvento != null) || (this.idSkyEvento != null && !this.idSkyEvento.equals(other.idSkyEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.SkyEventos[ idSkyEvento=" + idSkyEvento + " ]";
    }
    
}
