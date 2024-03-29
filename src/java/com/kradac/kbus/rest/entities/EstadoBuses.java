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
@Table(name = "estado_buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoBuses.findAll", query = "SELECT e FROM EstadoBuses e"),
    @NamedQuery(name = "EstadoBuses.findByIdEstadoBus", query = "SELECT e FROM EstadoBuses e WHERE e.idEstadoBus = :idEstadoBus"),
    @NamedQuery(name = "EstadoBuses.findByEstadoBus", query = "SELECT e FROM EstadoBuses e WHERE e.estadoBus = :estadoBus"),
    @NamedQuery(name = "EstadoBuses.findByDescripcionEstadoBus", query = "SELECT e FROM EstadoBuses e WHERE e.descripcionEstadoBus = :descripcionEstadoBus")})
public class EstadoBuses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_bus")
    private Integer idEstadoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_bus")
    private int estadoBus;
    @Size(max = 45)
    @Column(name = "descripcion_estado_bus")
    private String descripcionEstadoBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoBus")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;

    public EstadoBuses() {
    }

    public EstadoBuses(Integer idEstadoBus) {
        this.idEstadoBus = idEstadoBus;
    }

    public EstadoBuses(Integer idEstadoBus, int estadoBus) {
        this.idEstadoBus = idEstadoBus;
        this.estadoBus = estadoBus;
    }

    public Integer getIdEstadoBus() {
        return idEstadoBus;
    }

    public void setIdEstadoBus(Integer idEstadoBus) {
        this.idEstadoBus = idEstadoBus;
    }

    public int getEstadoBus() {
        return estadoBus;
    }

    public void setEstadoBus(int estadoBus) {
        this.estadoBus = estadoBus;
    }

    public String getDescripcionEstadoBus() {
        return descripcionEstadoBus;
    }

    public void setDescripcionEstadoBus(String descripcionEstadoBus) {
        this.descripcionEstadoBus = descripcionEstadoBus;
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
        hash += (idEstadoBus != null ? idEstadoBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoBuses)) {
            return false;
        }
        EstadoBuses other = (EstadoBuses) object;
        if ((this.idEstadoBus == null && other.idEstadoBus != null) || (this.idEstadoBus != null && !this.idEstadoBus.equals(other.idEstadoBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.EstadoBuses[ idEstadoBus=" + idEstadoBus + " ]";
    }
    
}
