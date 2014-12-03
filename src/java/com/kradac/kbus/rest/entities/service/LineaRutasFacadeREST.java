/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.service;

import com.kradac.kbus.rest.entities.LineaRutas;
import com.kradac.kbus.rest.entities.LineaRutasPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("com.kradac.kbus.rest.entities.linearutas")
public class LineaRutasFacadeREST extends AbstractFacade<LineaRutas> {
    @PersistenceContext(unitName = "K-BusPU")
    private EntityManager em;

    private LineaRutasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idRuta=idRutaValue;orden=ordenValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.kradac.kbus.rest.entities.LineaRutasPK key = new com.kradac.kbus.rest.entities.LineaRutasPK();
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

    public LineaRutasFacadeREST() {
        super(LineaRutas.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(LineaRutas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, LineaRutas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.LineaRutasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LineaRutas find(@PathParam("id") PathSegment id) {
        com.kradac.kbus.rest.entities.LineaRutasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LineaRutas> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("ruta={id}")
    @Produces({"application/json; charset=UTF-8", "application/json"})
    public String findByIdRuta(@PathParam("id") Integer id) {
        TypedQuery<LineaRutas> qry;

        qry = getEntityManager().createNamedQuery("LineaRutas.findByIdRuta", LineaRutas.class);
        qry.setParameter("idRuta", id);

        List<LineaRutas> lr = qry.getResultList();
        String dato = "[";
        for (LineaRutas lineaRutas : lr) {
            dato += "{latitud:" + lineaRutas.getLatitud() + ",";
            dato += "longitud:" + lineaRutas.getLongitud() + "},";
        }
        if (dato.length() > 1) {
            dato = dato.substring(0, dato.length() - 1);
        }
        dato += "]";
        return dato;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LineaRutas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
