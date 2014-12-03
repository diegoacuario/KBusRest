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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuarios.findByIp", query = "SELECT u FROM Usuarios u WHERE u.ip = :ip"),
    @NamedQuery(name = "Usuarios.findByHost", query = "SELECT u FROM Usuarios u WHERE u.host = :host"),
    @NamedQuery(name = "Usuarios.findByFechaHoraCon", query = "SELECT u FROM Usuarios u WHERE u.fechaHoraCon = :fechaHoraCon"),
    @NamedQuery(name = "Usuarios.findByConectado", query = "SELECT u FROM Usuarios u WHERE u.conectado = :conectado"),
    @NamedQuery(name = "Usuarios.findByLatitud", query = "SELECT u FROM Usuarios u WHERE u.latitud = :latitud"),
    @NamedQuery(name = "Usuarios.findByLongitud", query = "SELECT u FROM Usuarios u WHERE u.longitud = :longitud"),
    @NamedQuery(name = "Usuarios.findByFechaHoraRegistro", query = "SELECT u FROM Usuarios u WHERE u.fechaHoraRegistro = :fechaHoraRegistro"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Size(max = 45)
    @Column(name = "ip")
    private String ip;
    @Size(max = 45)
    @Column(name = "host")
    private String host;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_con")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conectado")
    private short conectado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresas idEmpresa;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idPersona;
    @JoinColumn(name = "id_rol_usuario", referencedColumnName = "id_rol_usuario")
    @ManyToOne(optional = false)
    private RolUsuarios idRolUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Vehiculos> vehiculosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Equipos> equiposList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String usuario, String clave, Date fechaHoraCon, short conectado, double latitud, double longitud, Date fechaHoraRegistro, short activo) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaHoraCon = fechaHoraCon;
        this.conectado = conectado;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.activo = activo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Date getFechaHoraCon() {
        return fechaHoraCon;
    }

    public void setFechaHoraCon(Date fechaHoraCon) {
        this.fechaHoraCon = fechaHoraCon;
    }

    public short getConectado() {
        return conectado;
    }

    public void setConectado(short conectado) {
        this.conectado = conectado;
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

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public RolUsuarios getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(RolUsuarios idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
