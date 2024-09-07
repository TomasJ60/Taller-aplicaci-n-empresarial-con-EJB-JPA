/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.session;

import co.edu.unipiloto.arquitectura.proyecto.entity.Proyectos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tomas
 */
@Stateless
public class ProyectosFacade extends AbstractFacade<Proyectos> implements ProyectosFacadeLocal {

    @PersistenceContext(unitName = "JEE_Proyecto_TomasAlvarez-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }
    
}
