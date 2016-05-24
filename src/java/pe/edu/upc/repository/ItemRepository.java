/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.repository;

import javax.persistence.EntityManager;
import java.util.List;
import pe.edu.upc.entities.Itemavance;

/**
 *
 * @author luis
 */
public class ItemRepository {
    private EntityManager entityManager;

	
    
        public ItemRepository(EntityManager entityManager)
        {
            this.entityManager = entityManager;
        }
	public void save(Itemavance item) {
		this.entityManager.persist(item);
	}
        
        public void update(Itemavance itemavance)
        {
           this.entityManager.refresh(itemavance);
        }
    
        public void remove (Itemavance item)
        {
          this.entityManager.remove(item);
        }
     
        public Itemavance search(Integer ID)
        {
          return this.entityManager.find(Itemavance.class, ID);
        }
   //------------------------------
        
          @SuppressWarnings("unchecked")
      public List<Itemavance> getItemavances()
      {
         return this.entityManager.
                 createNamedQuery("Itemavance.findAll").
                 getResultList();
       
      }
 
    public Long getCountItems() {
        return (Long) this.entityManager.createNamedQuery("Itemavance.count")
                .getSingleResult();
    }
}
