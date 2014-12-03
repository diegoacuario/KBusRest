/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.service;

import com.kradac.kbus.rest.entities.UltimoDatoSkps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author PRUEBA
 */
@Stateless
@Path("com.kradac.kbus.rest.entities.ultimodatoskps")
public class UltimoDatoSkpsFacadeREST extends AbstractFacade<UltimoDatoSkps> {
    @PersistenceContext(unitName = "K-BusPU")
    private EntityManager em;

    public UltimoDatoSkpsFacadeREST() {
        super(UltimoDatoSkps.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UltimoDatoSkps entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, UltimoDatoSkps entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UltimoDatoSkps find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UltimoDatoSkps> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("ruta={id}")
    @Produces({"application/json; charset=UTF-8", "application/json"})
    public String findByRuta(@PathParam("id") Integer id) {
        try {
            String dato;
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/kbusdb", "root", "krcloja")) {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("select v.reg_municipal, v.placa, u.latitud, u.longitud, u.velocidad, r.icono, u.fecha_hora_ult_dato from ultimo_dato_skps u, vehiculos v, rutas r where u.id_equipo = v.id_equipo and u.id_ruta = r.id_ruta and u.id_ruta = " + id);
                dato = "[";
                while (rs.next()) {
                    dato += "{regMunicipal:'" + rs.getString("reg_municipal") + "',";
                    dato += "placa:'" + rs.getString("placa") + "',";
                    dato += "latitud:" + rs.getDouble("latitud") + ",";
                    dato += "longitud:" + rs.getString("longitud") + ",";
                    dato += "velocidad:" + rs.getString("velocidad") + ",";
                    dato += "icono:'" + rs.getString("icono") + "',";
                    dato += "fechaHora:'" + rs.getString("fecha_hora_ult_dato").substring(0, rs.getString("fecha_hora_ult_dato").length()-2) + "'},";
                }   
                if (dato.length() > 1) {
                    dato = dato.substring(0, dato.length()-1);
                }
                dato += "]";
            }
            return dato;
        } catch (SQLException ex) {
            return null;
        }

//        TypedQuery<Object[]> qry;
//
//        qry = em.createQuery("SELECT v.regMunicipal, v.placa, u.latitud, u.longitud, u.velocidad, u.idRuta.icono FROM UltimoDatoSkps u, Vehiculos v WHERE u.idEquipo.idEquipo = v.idEquipo.idEquipo AND u.idRuta.idRuta = :idRuta", Object[].class);
//        qry.setParameter("idRuta", id);
//        List<Object[]> lo = qry.getResultList();
//        String dato = "[";
//        for (Object[] objects : lo) {
//            dato += "{regMunicipal:'" + objects[0].toString() + "',";
//            dato += "placa:'" + objects[1].toString() + "',";
//            dato += "latitud:" + objects[2].toString() + ",";
//            dato += "longitud:" + objects[3].toString() + ",";
//            dato += "velocidad:" + objects[4].toString() + ",";
//            dato += "icono:'" + objects[5].toString() + "'},";
//        }
//        dato += "]";
//        return dato;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UltimoDatoSkps> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
