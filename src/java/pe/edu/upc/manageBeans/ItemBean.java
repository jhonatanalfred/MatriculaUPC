/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.manageBeans;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import pe.edu.upc.entities.Itemavance;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.Tarea;
import pe.edu.upc.repository.UsuarioRepository;
import pe.edu.upc.repository.TareaRepository;
import pe.edu.upc.repository.ItemRepository;
/**
 *
 * @author luis
 */
@ManagedBean
public class ItemBean {
    
     @ManagedProperty(value = "#{entityManager}")
    private EntityManager entityManager;
    
   private Itemavance item = new Itemavance();
   private List<Itemavance> items;
    private Integer usuarioID;
    private Integer tareaID;
    
//get
   
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Itemavance getItem() {
        return item;
    }

    public void setItem(Itemavance item) {
        this.item = item;
    }

    

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Integer getTareaID() {
        return tareaID;
    }

    public void setTareaID(Integer tareaID) {
        this.tareaID = tareaID;
    }
  
    
    //--------------
    
    public void save(){
    
       
       TareaRepository tr = new TareaRepository(entityManager);
       UsuarioRepository ur = new UsuarioRepository(entityManager);
     
      Tarea t = tr.searcht(tareaID);
      Usuario u = ur.search(usuarioID);
      
      this.item.setIdtarea(t);
      this.item.setIdusuario(u);
        
        //Guardar un objeto DVD
        ItemRepository ir= new ItemRepository(entityManager);
        ir.save(item);
        
    
    
    }
    
    public void update(Itemavance itemavance)
      {
        ItemRepository itemRepository=new ItemRepository(
                this.entityManager);
        itemRepository.update(itemavance);
        this.items=null;
      
      }
    
    public void remove (Itemavance item )
    {
      ItemRepository itemRepository = new ItemRepository(this.entityManager);
      itemRepository.remove(item);
      this.items=null;
    
    
    }
    
   
  //-------------------
    
    public List<Itemavance> getItems() {
      
  
        ItemRepository itemRepository =
                new ItemRepository(this.entityManager);
        
        items=itemRepository.getItemavances();
        return items;
    }

    public void setItems(List<Itemavance> items) {
        this.items = items;
    }
    //-------------------------
    
     public EntityManager getEntityManager() {
      FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute(" EntityManager ");
    }

      public Long getCount() {
          ItemRepository repository = new ItemRepository(this.entityManager);
          return repository.getCountItems();
          
    }
     
     
}
