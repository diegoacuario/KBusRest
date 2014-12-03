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
@Table(name = "tipo_licencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLicencias.findAll", query = "SELECT t FROM TipoLicencias t"),
    @NamedQuery(name = "TipoLicencias.findByIdTipoLicencia", query = "SELECT t FROM TipoLicencias t WHERE t.idTipoLicencia = :idTipoLicencia"),
    @NamedQuery(name = "TipoLicencias.findByTipoLicencia", query = "SELECT t FROM TipoLicencias t WHERE t.tipoLicencia = :tipoLicencia"),
    @NamedQuery(name = "TipoLicencias.findByDescripcion", query = "SELECT t FROM TipoLicencias t WHERE t.descripcion = :descripcion")})
public class TipoLicencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_licencia")
    private Integer idTipoLicencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_licencia")
    private String tipoLicencia;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLicencia")
    private List<Personas> personasList;

    public TipoLicencias() {
    }

    public TipoLicencias(Integer idTipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
    }

    public TipoLicencias(Integer idTipoLicencia, String tipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
        this.tipoLicencia = tipoLicencia;
    }

    public Integer getIdTipoLicencia() {
        return idTipoLicencia;
    }

    public void setIdTipoLicencia(Integer idTipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Personas> getPersonasList() {
        return personasList;
    }

    public void setPersonasList(List<Personas> personasList) {
        this.personasList = personasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLicencia != null ? idTipoLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLicencias)) {
            return false;
        }
        TipoLicencias other = (TipoLicencias) object;
        if ((this.idTipoLicencia == null && other.idTipoLicencia != null) || (this.idTipoLicencia != null && !this.idTipoLicencia.equals(other.idTipoLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.TipoLicencias[ idTipoLicencia=" + idTipoLicencia + " ]";
    }
    
}
