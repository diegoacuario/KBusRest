/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kradac.kbus.rest.entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author PRUEBA
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kradac.kbus.rest.entities.service.DenunciasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.DisplaysFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EmpresasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EncabezadosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EquiposFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EstacionesFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EstadoBusesFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.EstadoMecanicosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.InformacionParadasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.LineaRutasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.PersonasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.PuntoRutasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.PuntosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.RolUsuariosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.RutasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.ServicioRutasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.SkyEventosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.TipoEquiposFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.TipoLicenciasFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.UltimoDatoFastracksFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.UltimoDatoSkpsFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.UsuariosFacadeREST.class);
        resources.add(com.kradac.kbus.rest.entities.service.VehiculosFacadeREST.class);
    }
    
}
