/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.service;

import com.kradac.kbus.rest.entities.Vehiculos;
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

/**
 *
 * @author PRUEBA
 */
@Stateless
@Path("com.kradac.kbus.rest.entities.vehiculos")
public class VehiculosFacadeREST extends AbstractFacade<Vehiculos> {
    @PersistenceContext(unitName = "K-BusPU")
    private EntityManager em;

    public VehiculosFacadeREST() {
        super(Vehiculos.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Vehiculos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Vehiculos entity) {
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
    public Vehiculos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Vehiculos> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("regmuni={id}")
    @Produces({"application/json; charset=UTF-8", "application/json"})
    public List<Vehiculos> findByRegMunicipal(@PathParam("id") String regmuni) {
        TypedQuery<Vehiculos> qry;

        qry = getEntityManager().createNamedQuery("Vehiculos.findByRegMunicipal", Vehiculos.class);
        qry.setParameter("regMunicipal", "RT-"+regmuni);
        return qry.getResultList();
    }
    
    @GET
    @Path("placa={id}")
    @Produces({"application/json; charset=UTF-8", "application/json"})
    public List<Vehiculos> findByPlaca(@PathParam("id") String placa) {
        TypedQuery<Vehiculos> qry;

        qry = getEntityManager().createNamedQuery("Vehiculos.findByPlaca", Vehiculos.class);
        qry.setParameter("placa", placa);
        return qry.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Vehiculos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
