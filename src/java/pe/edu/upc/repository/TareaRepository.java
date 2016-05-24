/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.repository;

import java.util.List;
import javax.persistence.EntityManager;
import pe.edu.upc.entities.Tarea;
import pe.edu.upc.entities.Usuario;
/**
 *
 * @author luis
 */
public class TareaRepository {

    private EntityManager entityManager;
    
    public TareaRepository(EntityManager entityManager) {
     this.entityManager=entityManager;
    }
    
    public void save(Tarea tarea)
    {
    
       this.entityManager.persist(tarea);
    }
    
    public void remove (Tarea tarea)
    {
       this.entityManager.remove(tarea);
    }
    
    public void update(Tarea tarea)
    {
       this.entityManager.refresh(tarea);
    }
    
    public Tarea searcht(Integer ID)
    {
       return this.entityManager.find(Tarea.class,ID);
    
    }
    
    //----------------------
    
       @SuppressWarnings("unchecked")
    
    public List<Tarea> getTareas(){   
        return this.entityManager.
                createNamedQuery("Tarea.findAll").
                getResultList();
    }
    
    public List<Tarea> getTareasRealizadas(){   
        return this.entityManager.
                createNamedQuery("Tarea.findEstadoRealizado").
                getResultList();
    }
    
    public List<Tarea> getTareasNoRealizadas(){   
        return this.entityManager.
                createNamedQuery("Tarea.findEstadoNoRealizado").
                getResultList();
    }
}
