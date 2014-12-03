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
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Personas.findByCedula", query = "SELECT p FROM Personas p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Personas.findByNombres", query = "SELECT p FROM Personas p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Personas.findByApellidos", query = "SELECT p FROM Personas p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Personas.findByGenero", query = "SELECT p FROM Personas p WHERE p.genero = :genero"),
    @NamedQuery(name = "Personas.findByFechaNacimiento", query = "SELECT p FROM Personas p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Personas.findByConyugue", query = "SELECT p FROM Personas p WHERE p.conyugue = :conyugue"),
    @NamedQuery(name = "Personas.findByDireccion", query = "SELECT p FROM Personas p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Personas.findByCorreo", query = "SELECT p FROM Personas p WHERE p.correo = :correo"),
    @NamedQuery(name = "Personas.findByCelular", query = "SELECT p FROM Personas p WHERE p.celular = :celular"),
    @NamedQuery(name = "Personas.findByImagen", query = "SELECT p FROM Personas p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Personas.findByFechaHoraRegistro", query = "SELECT p FROM Personas p WHERE p.fechaHoraRegistro = :fechaHoraRegistro"),
    @NamedQuery(name = "Personas.findByTipoLicencia", query = "SELECT p FROM Personas p WHERE p.tipoLicencia = :tipoLicencia")})
public class Personas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private int genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "conyugue")
    private String conyugue;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 10)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Size(max = 45)
    @Column(name = "tipo_licencia")
    private String tipoLicencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresas idEmpresa;
    @JoinColumn(name = "id_tipo_licencia", referencedColumnName = "id_tipo_licencia")
    @ManyToOne(optional = false)
    private TipoLicencias idTipoLicencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAyudante")
    private List<Vehiculos> vehiculosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor")
    private List<Vehiculos> vehiculosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Vehiculos> vehiculosList2;

    public Personas() {
    }

    public Personas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Personas(Integer idPersona, String cedula, String nombres, String apellidos, int genero, Date fechaNacimiento, String imagen, Date fechaHoraRegistro) {
        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoLicencias getIdTipoLicencia() {
        return idTipoLicencia;
    }

    public void setIdTipoLicencia(TipoLicencias idTipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList1() {
        return vehiculosList1;
    }

    public void setVehiculosList1(List<Vehiculos> vehiculosList1) {
        this.vehiculosList1 = vehiculosList1;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList2() {
        return vehiculosList2;
    }

    public void setVehiculosList2(List<Vehiculos> vehiculosList2) {
        this.vehiculosList2 = vehiculosList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Personas[ idPersona=" + idPersona + " ]";
    }
    
}
