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
@Table(name = "estado_mecanicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoMecanicos.findAll", query = "SELECT e FROM EstadoMecanicos e"),
    @NamedQuery(name = "EstadoMecanicos.findByIdEstadoMecanico", query = "SELECT e FROM EstadoMecanicos e WHERE e.idEstadoMecanico = :idEstadoMecanico"),
    @NamedQuery(name = "EstadoMecanicos.findByEstadoMecanico", query = "SELECT e FROM EstadoMecanicos e WHERE e.estadoMecanico = :estadoMecanico"),
    @NamedQuery(name = "EstadoMecanicos.findByDescripcionEstadoMecanico", query = "SELECT e FROM EstadoMecanicos e WHERE e.descripcionEstadoMecanico = :descripcionEstadoMecanico")})
public class EstadoMecanicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_mecanico")
    private Integer idEstadoMecanico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado_mecanico")
    private String estadoMecanico;
    @Size(max = 45)
    @Column(name = "descripcion_estado_mecanico")
    private String descripcionEstadoMecanico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoMecanico")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;

    public EstadoMecanicos() {
    }

    public EstadoMecanicos(Integer idEstadoMecanico) {
        this.idEstadoMecanico = idEstadoMecanico;
    }

    public EstadoMecanicos(Integer idEstadoMecanico, String estadoMecanico) {
        this.idEstadoMecanico = idEstadoMecanico;
        this.estadoMecanico = estadoMecanico;
    }

    public Integer getIdEstadoMecanico() {
        return idEstadoMecanico;
    }

    public void setIdEstadoMecanico(Integer idEstadoMecanico) {
        this.idEstadoMecanico = idEstadoMecanico;
    }

    public String getEstadoMecanico() {
        return estadoMecanico;
    }

    public void setEstadoMecanico(String estadoMecanico) {
        this.estadoMecanico = estadoMecanico;
    }

    public String getDescripcionEstadoMecanico() {
        return descripcionEstadoMecanico;
    }

    public void setDescripcionEstadoMecanico(String descripcionEstadoMecanico) {
        this.descripcionEstadoMecanico = descripcionEstadoMecanico;
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
        hash += (idEstadoMecanico != null ? idEstadoMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMecanicos)) {
            return false;
        }
        EstadoMecanicos other = (EstadoMecanicos) object;
        if ((this.idEstadoMecanico == null && other.idEstadoMecanico != null) || (this.idEstadoMecanico != null && !this.idEstadoMecanico.equals(other.idEstadoMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.EstadoMecanicos[ idEstadoMecanico=" + idEstadoMecanico + " ]";
    }
    
}
