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
@Table(name = "encabezados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encabezados.findAll", query = "SELECT e FROM Encabezados e"),
    @NamedQuery(name = "Encabezados.findByIdEncabezado", query = "SELECT e FROM Encabezados e WHERE e.idEncabezado = :idEncabezado"),
    @NamedQuery(name = "Encabezados.findByEncabezado", query = "SELECT e FROM Encabezados e WHERE e.encabezado = :encabezado"),
    @NamedQuery(name = "Encabezados.findByDescripcionEncabezado", query = "SELECT e FROM Encabezados e WHERE e.descripcionEncabezado = :descripcionEncabezado"),
    @NamedQuery(name = "Encabezados.findByColor", query = "SELECT e FROM Encabezados e WHERE e.color = :color")})
public class Encabezados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_encabezado")
    private Integer idEncabezado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "encabezado")
    private String encabezado;
    @Size(max = 45)
    @Column(name = "descripcion_encabezado")
    private String descripcionEncabezado;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncabezado")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;

    public Encabezados() {
    }

    public Encabezados(Integer idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public Encabezados(Integer idEncabezado, String encabezado) {
        this.idEncabezado = idEncabezado;
        this.encabezado = encabezado;
    }

    public Integer getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(Integer idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getDescripcionEncabezado() {
        return descripcionEncabezado;
    }

    public void setDescripcionEncabezado(String descripcionEncabezado) {
        this.descripcionEncabezado = descripcionEncabezado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash += (idEncabezado != null ? idEncabezado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encabezados)) {
            return false;
        }
        Encabezados other = (Encabezados) object;
        if ((this.idEncabezado == null && other.idEncabezado != null) || (this.idEncabezado != null && !this.idEncabezado.equals(other.idEncabezado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Encabezados[ idEncabezado=" + idEncabezado + " ]";
    }
    
}
