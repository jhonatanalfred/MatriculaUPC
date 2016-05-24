/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.manageBeans;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import pe.edu.upc.entities.Tarea;
import pe.edu.upc.repository.TareaRepository;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luis
 */

@ManagedBean
public class TareaBean {
    
     @ManagedProperty(value = "#{entityManager}")
    private EntityManager entityManager;
     
     private List<Tarea> tareas = null;
     private List<Tarea> tareasestadorealizado = null;
     private List<Tarea> tareasestadonorealizado = null;
     private Tarea tarea = new Tarea();

     
     
     
  

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    //---------------------------------
    
      public void save() {
        
        
        TareaRepository tareaRepository = new TareaRepository(
                this.entityManager);
        
        tareaRepository.save(this.tarea);
        this.tarea=new Tarea();
        this.tarea=null;
    }
    
    public void update(Tarea tarea)
      {
        TareaRepository tareaRepository=new TareaRepository(this.entityManager);
        tareaRepository.update(tarea);
        this.tareas=null;
      }
      
    public void remove (Tarea tarea){
      TareaRepository tareaRepository = new TareaRepository(this.entityManager);
      tareaRepository.remove(tarea);
      
      this.tareas=null;
    
    }
      
    //--------------------------------------
     public List<Tarea> getTareas() {
         
         TareaRepository tareaRepository=
                 new TareaRepository(this.entityManager);
         tareas=tareaRepository.getTareas();
        return tareas;
    }

     public List<Tarea> getTareasRealizadas() {
         
         TareaRepository tareaRepository=
                 new TareaRepository(this.entityManager);
         tareasestadorealizado=tareaRepository.getTareasRealizadas();
        return tareasestadorealizado;
    }
     
     public List<Tarea> getTareasNoRealizadas() {
         
         TareaRepository tareaRepository=
                 new TareaRepository(this.entityManager);
         
         tareasestadonorealizado=tareaRepository.getTareasNoRealizadas();
        return tareasestadonorealizado;
    }
     
        public EntityManager getEntityManager() {
         FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute(" EntityManager ");
    }
   
        
}
