/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculos.findByRegMunicipal", query = "SELECT v FROM Vehiculos v WHERE v.regMunicipal = :regMunicipal"),
    @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculos.findByYear", query = "SELECT v FROM Vehiculos v WHERE v.year = :year"),
    @NamedQuery(name = "Vehiculos.findByNumMotor", query = "SELECT v FROM Vehiculos v WHERE v.numMotor = :numMotor"),
    @NamedQuery(name = "Vehiculos.findByNumChasis", query = "SELECT v FROM Vehiculos v WHERE v.numChasis = :numChasis"),
    @NamedQuery(name = "Vehiculos.findByNumDisco", query = "SELECT v FROM Vehiculos v WHERE v.numDisco = :numDisco"),
    @NamedQuery(name = "Vehiculos.findByFechaMatricula", query = "SELECT v FROM Vehiculos v WHERE v.fechaMatricula = :fechaMatricula"),
    @NamedQuery(name = "Vehiculos.findBySoat", query = "SELECT v FROM Vehiculos v WHERE v.soat = :soat"),
    @NamedQuery(name = "Vehiculos.findByImagen", query = "SELECT v FROM Vehiculos v WHERE v.imagen = :imagen"),
    @NamedQuery(name = "Vehiculos.findByEstadoReten", query = "SELECT v FROM Vehiculos v WHERE v.estadoReten = :estadoReten"),
    @NamedQuery(name = "Vehiculos.findByFechaHoraEntradaReten", query = "SELECT v FROM Vehiculos v WHERE v.fechaHoraEntradaReten = :fechaHoraEntradaReten"),
    @NamedQuery(name = "Vehiculos.findByFechaHoraSalidaReten", query = "SELECT v FROM Vehiculos v WHERE v.fechaHoraSalidaReten = :fechaHoraSalidaReten"),
    @NamedQuery(name = "Vehiculos.findByComentario", query = "SELECT v FROM Vehiculos v WHERE v.comentario = :comentario"),
    @NamedQuery(name = "Vehiculos.findByFechaHoraComentario", query = "SELECT v FROM Vehiculos v WHERE v.fechaHoraComentario = :fechaHoraComentario"),
    @NamedQuery(name = "Vehiculos.findByFechaHoraRegistro", query = "SELECT v FROM Vehiculos v WHERE v.fechaHoraRegistro = :fechaHoraRegistro"),
    @NamedQuery(name = "Vehiculos.findByPersonasSentadas", query = "SELECT v FROM Vehiculos v WHERE v.personasSentadas = :personasSentadas"),
    @NamedQuery(name = "Vehiculos.findByPersonasParadas", query = "SELECT v FROM Vehiculos v WHERE v.personasParadas = :personasParadas")})
public class Vehiculos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "placa")
    private String placa;
    @Size(max = 10)
    @Column(name = "reg_municipal")
    private String regMunicipal;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Size(max = 45)
    @Column(name = "num_motor")
    private String numMotor;
    @Size(max = 45)
    @Column(name = "num_chasis")
    private String numChasis;
    @Column(name = "num_disco")
    private Integer numDisco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_matricula")
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;
    @Size(max = 45)
    @Column(name = "soat")
    private String soat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reten")
    private short estadoReten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_entrada_reten")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEntradaReten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_salida_reten")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraSalidaReten;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personas_sentadas")
    private int personasSentadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personas_paradas")
    private int personasParadas;
    @JoinColumn(name = "id_ayudante", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idAyudante;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idConductor;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresas idEmpresa;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipos idEquipo;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas idPersona;
    @JoinColumn(name = "id_servicio_ruta", referencedColumnName = "id_servicio_ruta")
    @ManyToOne(optional = false)
    private ServicioRutas idServicioRuta;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(Integer idVehiculo, String placa, int year, Date fechaMatricula, String imagen, short estadoReten, Date fechaHoraEntradaReten, Date fechaHoraSalidaReten, String comentario, Date fechaHoraComentario, Date fechaHoraRegistro, int personasSentadas, int personasParadas) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.year = year;
        this.fechaMatricula = fechaMatricula;
        this.imagen = imagen;
        this.estadoReten = estadoReten;
        this.fechaHoraEntradaReten = fechaHoraEntradaReten;
        this.fechaHoraSalidaReten = fechaHoraSalidaReten;
        this.comentario = comentario;
        this.fechaHoraComentario = fechaHoraComentario;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.personasSentadas = personasSentadas;
        this.personasParadas = personasParadas;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRegMunicipal() {
        return regMunicipal;
    }

    public void setRegMunicipal(String regMunicipal) {
        this.regMunicipal = regMunicipal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public Integer getNumDisco() {
        return numDisco;
    }

    public void setNumDisco(Integer numDisco) {
        this.numDisco = numDisco;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public short getEstadoReten() {
        return estadoReten;
    }

    public void setEstadoReten(short estadoReten) {
        this.estadoReten = estadoReten;
    }

    public Date getFechaHoraEntradaReten() {
        return fechaHoraEntradaReten;
    }

    public void setFechaHoraEntradaReten(Date fechaHoraEntradaReten) {
        this.fechaHoraEntradaReten = fechaHoraEntradaReten;
    }

    public Date getFechaHoraSalidaReten() {
        return fechaHoraSalidaReten;
    }

    public void setFechaHoraSalidaReten(Date fechaHoraSalidaReten) {
        this.fechaHoraSalidaReten = fechaHoraSalidaReten;
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

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public int getPersonasSentadas() {
        return personasSentadas;
    }

    public void setPersonasSentadas(int personasSentadas) {
        this.personasSentadas = personasSentadas;
    }

    public int getPersonasParadas() {
        return personasParadas;
    }

    public void setPersonasParadas(int personasParadas) {
        this.personasParadas = personasParadas;
    }

    public Personas getIdAyudante() {
        return idAyudante;
    }

    public void setIdAyudante(Personas idAyudante) {
        this.idAyudante = idAyudante;
    }

    public Personas getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Personas idConductor) {
        this.idConductor = idConductor;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public ServicioRutas getIdServicioRuta() {
        return idServicioRuta;
    }

    public void setIdServicioRuta(ServicioRutas idServicioRuta) {
        this.idServicioRuta = idServicioRuta;
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
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kradac.kbus.rest.entities.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
