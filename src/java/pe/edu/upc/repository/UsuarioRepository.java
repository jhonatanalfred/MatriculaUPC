/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.repository;
import java.util.List;
import javax.persistence.EntityManager;
import pe.edu.upc.entities.Usuario;
/**
 *
 * @author luis
 */
public class UsuarioRepository {
    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        
        this.entityManager = entityManager;
    }
   
    public void save(Usuario usuario)
    {
       this.entityManager.persist(usuario);
    }
       
    public void update(Usuario usuario)
    {
       this.entityManager.refresh(usuario);
    }
       public void remove (Usuario usuario)
       {
          this.entityManager.remove(usuario);
       }
    public Usuario search(Integer ID){
    
      return this.entityManager.find(Usuario.class,ID);
    
    
    }
    
    //---------------------------------------
     @SuppressWarnings("unchecked")
    public List<Usuario> getUsuarios() {
        
        return this.entityManager.
                createNamedQuery("Usuario.findAll").
                getResultList();
    }
    
      public Long getCountUsuarios() {
        return (Long) this.entityManager.createNamedQuery("Usuario.count")
                .getSingleResult();
    }

      
       public Usuario autenticar(Usuario u){
        try {
            return (Usuario)entityManager.createNamedQuery("Usuario.findByClaveUser")
                    .setParameter("password", u.getPassword())
                    .setParameter("user", u.getUser()).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}

