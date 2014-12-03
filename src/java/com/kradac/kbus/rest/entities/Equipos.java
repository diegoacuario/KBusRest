/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipos.findByEquipo", query = "SELECT e FROM Equipos e WHERE e.equipo = :equipo"),
    @NamedQuery(name = "Equipos.findBySerie", query = "SELECT e FROM Equipos e WHERE e.serie = :serie"),
    @NamedQuery(name = "Equipos.findByNumeroChip", query = "SELECT e FROM Equipos e WHERE e.numeroChip = :numeroChip"),
    @NamedQuery(name = "Equipos.findByImeiChip", query = "SELECT e FROM Equipos e WHERE e.imeiChip = :imeiChip"),
    @NamedQuery(name = "Equipos.findByFechaHoraRegistro", query = "SELECT e FROM Equipos e WHERE e.fechaHoraRegistro = :fechaHoraRegistro"),
    @NamedQuery(name = "Equipos.findByObservacion", query = "SELECT e FROM Equipos e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Equipos.findByComentario", query = "SELECT e FROM Equipos e WHERE e.comentario = :comentario"),
    @NamedQuery(name = "Equipos.findByFechaHoraComentario", query = "SELECT e FROM Equipos e WHERE e.fechaHoraComentario = :fechaHoraComentario")})
public class Equipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "equipo")
    private String equipo;
    @Size(max = 45)
    @Column(name = "serie")
    private String serie;
    @Size(max = 45)
    @Column(name = "numero_chip")
    private String numeroChip;
    @Size(max = 45)
    @Column(name = "imei_chip")
    private String imeiChip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraComentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<Vehiculos> vehiculosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<UltimoDatoSkps> ultimoDatoSkpsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<UltimoDatoFastracks> ultimoDatoFastracksList;
    @JoinColumn(name = "id_tipo_equipo", referencedColumnName = "id_tipo_equipo")
    @ManyToOne(optional = false)
    private TipoEquipos idTipoEquipo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipos(Integer idEquipo, String equipo, Date fechaHoraRegistro, String observacion, String comentario, Date fechaHoraComentario) {
        this.idEquipo = idEquipo;
        this.equipo = equipo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.observacion = observacion;
        this.comentario = comentario;
        this.fechaHoraComentario = fechaHoraComentario;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(String numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getImeiChip() {
        return imeiChip;
    }

    public void setImeiChip(String imeiChip) {
        this.imeiChip = imeiChip;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaHoraComentario() {
        return fechaHoraComentario;
    }

    public void setFechaHoraComentario(Date fechaHoraComentario) {
        this.fechaHoraComentario = fechaHoraComentario;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @XmlTransient
    public List<UltimoDatoSkps> getUltimoDatoSkpsList() {
        return ultimoDatoSkpsList;
    }

    public void setUltimoDatoSkpsList(List<UltimoDatoSkps> ultimoDatoSkpsList) {
        this.ultimoDatoSkpsList = ultimoDatoSkpsList;
    }

    @XmlTransient
    public List<UltimoDatoFastracks> getUltimoDatoFastracksList() {
        return ultimoDatoFastracksList;
    }

    public void setUltimoDatoFastracksList(List<UltimoDatoFastracks> ultimoDatoFastracksList) {
        this.ultimoDatoFastracksList = ultimoDatoFastracksList;
    }

    public TipoEquipos getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(TipoEquipos idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Equipos[ idEquipo=" + idEquipo + " ]";
    }
    
}
