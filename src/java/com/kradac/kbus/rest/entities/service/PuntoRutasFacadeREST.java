/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.service;

import com.kradac.kbus.rest.entities.PuntoRutas;
import com.kradac.kbus.rest.entities.PuntoRutasPK;
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
@Path("com.kradac.kbus.rest.entities.puntorutas")
public class PuntoRutasFacadeREST extends AbstractFacade<PuntoRutas> {
    @PersistenceContext(unitName = "K-BusPU")
    private EntityManager em;

    private PuntoRutasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idRuta=idRutaValue;orden=ordenValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.kradac.kbus.rest.entities.PuntoRutasPK key = new com.kradac.kbus.rest.entities.PuntoRutasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idRuta = map.get("idRuta");
        if (idRuta != null && !idRuta.isEmpty()) {
            key.setIdRuta(new java.lang.Integer(idRuta.get(0)));
        }
        java.util.List<String> orden = map.get("orden");
        if (orden != null && !orden.isEmpty()) {
            key.setOrden(new java.lang.Integer(orden.get(0)));
        }
        return key;
    }

    public PuntoRutasFacadeREST() {
        super(PuntoRutas.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(PuntoRutas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, PuntoRutas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.PuntoRutasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public PuntoRutas find(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.PuntoRutasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<PuntoRutas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<PuntoRutas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
