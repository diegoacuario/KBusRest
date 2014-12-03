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
@Table(name = "tipo_equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipos.findAll", query = "SELECT t FROM TipoEquipos t"),
    @NamedQuery(name = "TipoEquipos.findByIdTipoEquipo", query = "SELECT t FROM TipoEquipos t WHERE t.idTipoEquipo = :idTipoEquipo"),
    @NamedQuery(name = "TipoEquipos.findByTipoEquipo", query = "SELECT t FROM TipoEquipos t WHERE t.tipoEquipo = :tipoEquipo"),
    @NamedQuery(name = "TipoEquipos.findByConexion", query = "SELECT t FROM TipoEquipos t WHERE t.conexion = :conexion")})
public class TipoEquipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_equipo")
    private Integer idTipoEquipo;
    @Size(max = 45)
    @Column(name = "tipo_equipo")
    private String tipoEquipo;
    @Size(max = 45)
    @Column(name = "conexion")
    private String conexion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEquipo")
    private List<Equipos> equiposList;

    public TipoEquipos() {
    }

    public TipoEquipos(Integer idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public Integer getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(Integer idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEquipo != null ? idTipoEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipos)) {
            return false;
        }
        TipoEquipos other = (TipoEquipos) object;
        if ((this.idTipoEquipo == null && other.idTipoEquipo != null) || (this.idTipoEquipo != null && !this.idTipoEquipo.equals(other.idTipoEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.TipoEquipos[ idTipoEquipo=" + idTipoEquipo + " ]";
    }
    
}
