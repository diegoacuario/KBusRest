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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRUEBA
 */
@Entity
@Table(name = "denuncias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denuncias.findAll", query = "SELECT d FROM Denuncias d"),
    @NamedQuery(name = "Denuncias.findByIdDenuncia", query = "SELECT d FROM Denuncias d WHERE d.idDenuncia = :idDenuncia"),
    @NamedQuery(name = "Denuncias.findByIdVehiculo", query = "SELECT d FROM Denuncias d WHERE d.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Denuncias.findByCedula", query = "SELECT d FROM Denuncias d WHERE d.cedula = :cedula"),
    @NamedQuery(name = "Denuncias.findByDenunciante", query = "SELECT d FROM Denuncias d WHERE d.denunciante = :denunciante"),
    @NamedQuery(name = "Denuncias.findByTelefono", query = "SELECT d FROM Denuncias d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Denuncias.findByCorreo", query = "SELECT d FROM Denuncias d WHERE d.correo = :correo"),
    @NamedQuery(name = "Denuncias.findByMotivo", query = "SELECT d FROM Denuncias d WHERE d.motivo = :motivo"),
    @NamedQuery(name = "Denuncias.findByLatitud", query = "SELECT d FROM Denuncias d WHERE d.latitud = :latitud"),
    @NamedQuery(name = "Denuncias.findByLongitud", query = "SELECT d FROM Denuncias d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "Denuncias.findByObservacion", query = "SELECT d FROM Denuncias d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "Denuncias.findByFechaHoraRegistro", query = "SELECT d FROM Denuncias d WHERE d.fechaHoraRegistro = :fechaHoraRegistro")})
public class Denuncias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia")
    private Integer idDenuncia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vehiculo")
    private int idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "denunciante")
    private String denunciante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Size(max = 150)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;

    public Denuncias() {
    }

    public Denuncias(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Denuncias(Integer idDenuncia, int idVehiculo, String cedula, String denunciante, String telefono, String correo, String motivo, double latitud, double longitud, Date fechaHoraRegistro) {
        this.idDenuncia = idDenuncia;
        this.idVehiculo = idVehiculo;
        this.cedula = cedula;
        this.denunciante = denunciante;
        this.telefono = telefono;
        this.correo = correo;
        this.motivo = motivo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }
    
    public Integer getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenuncia != null ? idDenuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denuncias)) {
            return false;
        }
        Denuncias other = (Denuncias) object;
        if ((this.idDenuncia == null && other.idDenuncia != null) || (this.idDenuncia != null && !this.idDenuncia.equals(other.idDenuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.historic.Denuncias[ idDenuncia=" + idDenuncia + " ]";
    }
    
}
