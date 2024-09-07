/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.session;

import co.edu.unipiloto.arquitectura.proyecto.entity.Proyectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tomas
 */
@Local
public interface ProyectosFacadeLocal {

    void create(Proyectos proyectos);

    void edit(Proyectos proyectos);

    void remove(Proyectos proyectos);

    Proyectos find(Object id);

    List<Proyectos> findAll();

    List<Proyectos> findRange(int[] range);

    int count();
    
}
