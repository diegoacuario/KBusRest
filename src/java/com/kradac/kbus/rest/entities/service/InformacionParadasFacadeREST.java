/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kradac.kbus.rest.entities.service;

import com.kradac.kbus.rest.entities.historic.InformacionParadas;
import com.kradac.kbus.rest.entities.historic.InformacionParadasPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author PRUEBA
 */
@Stateless
@Path("com.kradac.kbus.rest.entities.historic.informacionparadas")
public class InformacionParadasFacadeREST extends AbstractFacade<InformacionParadas> {

    @PersistenceContext(unitName = "K-BusPU2")
    private EntityManager em;

    private InformacionParadasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idVehiculo=idVehiculoValue;idRuta=idRutaValue;orden=ordenValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.kradac.kbus.rest.entities.historic.InformacionParadasPK key = new com.kradac.kbus.rest.entities.historic.InformacionParadasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idVehiculo = map.get("idVehiculo");
        if (idVehiculo != null && !idVehiculo.isEmpty()) {
            key.setIdVehiculo(new java.lang.Integer(idVehiculo.get(0)));
        }
        java.util.List<String> idRuta = map.get("idRuta");
        if (idRuta != null && !idRuta.isEmpty()) {
            key.setIdRuta(new java.lang.Integer(idRuta.get(0)));
        }
        java.util.List<String> orden = map.get("orden");
        if (orden != null && !orden.isEmpty()) {
            key.setOrden(new java.lang.Short(orden.get(0)));
        }
        return key;
    }

    public InformacionParadasFacadeREST() {
        super(InformacionParadas.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(InformacionParadas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, InformacionParadas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.historic.InformacionParadasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public InformacionParadas find(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.historic.InformacionParadasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<InformacionParadas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("parada={id}")
    @Produces({"application/json; charset=UTF-8", "application/json"})
    public String findByParada(@PathParam("id") Integer id) {
        try {
            String dato;
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/kbusdb", "root", "krcloja")) {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("select v.reg_municipal, r.ruta, ip.hora_llegada, ip.hora_arribo "
                        + "from kbushistoricodb.informacion_paradas ip, vehiculos v, rutas r "
                        + "where ip.id_vehiculo = v.id_vehiculo "
                        + "and ip.id_ruta = r.id_ruta "
                        + "and ip.id_parada = " + id + " "
                        + "order by hora_llegada");
                dato = "[";
                while (rs.next()) {
                    dato += "{regMunicipal:'" + rs.getString("reg_municipal") + "',";
                    dato += "ruta:'" + rs.getString("ruta") + "',";
                    dato += "horaLlegada:'" + rs.getString("hora_llegada") + "',";
                    dato += "horaArribo:'" + rs.getString("hora_arribo") + "'},";
                }
                if (dato.length() > 1) {
                    dato = dato.substring(0, dato.length() - 1);
                }
                dato += "]";
            }
            return "{data: " + dato + "}";
        } catch (SQLException ex) {
            return "{data: []}";
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<InformacionParadas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
