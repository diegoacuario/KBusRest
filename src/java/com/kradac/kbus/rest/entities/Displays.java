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
@Table(name = "displays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Displays.findAll", query = "SELECT d FROM Displays d"),
    @NamedQuery(name = "Displays.findByIdDisplay", query = "SELECT d FROM Displays d WHERE d.idDisplay = :idDisplay"),
    @NamedQuery(name = "Displays.findByDisplay", query = "SELECT d FROM Displays d WHERE d.display = :display"),
    @NamedQuery(name = "Displays.findByDescripcionDisplay", query = "SELECT d FROM Displays d WHERE d.descripcionDisplay = :descripcionDisplay")})
public class Displays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_display")
    private Integer idDisplay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "display")
    private int display;
    @Size(max = 45)
    @Column(name = "descripcion_display")
    private String descripcionDisplay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisplay")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;

    public Displays() {
    }

    public Displays(Integer idDisplay) {
        this.idDisplay = idDisplay;
    }

    public Displays(Integer idDisplay, int display) {
        this.idDisplay = idDisplay;
        this.display = display;
    }

    public Integer getIdDisplay() {
        return idDisplay;
    }

    public void setIdDisplay(Integer idDisplay) {
        this.idDisplay = idDisplay;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getDescripcionDisplay() {
        return descripcionDisplay;
    }

    public void setDescripcionDisplay(String descripcionDisplay) {
        this.descripcionDisplay = descripcionDisplay;
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
        hash += (idDisplay != null ? idDisplay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Displays)) {
            return false;
        }
        Displays other = (Displays) object;
        if ((this.idDisplay == null && other.idDisplay != null) || (this.idDisplay != null && !this.idDisplay.equals(other.idDisplay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Displays[ idDisplay=" + idDisplay + " ]";
    }
    
}
