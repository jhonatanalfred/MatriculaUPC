/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.manageBeans;

/**
 *
 * @author luis
 */

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.repository.UsuarioRepository;

@ManagedBean
public class UsuarioBean implements Serializable  {
    
     @ManagedProperty(value = "#{entityManager}")
    private EntityManager entityManager;

     private List<Usuario> usuarios = null;
     private Usuario usuario = new Usuario();
     
     

  

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   
    public String login(){
      UsuarioRepository usuarioRepository=new  UsuarioRepository(this.entityManager) ;
      usuario=usuarioRepository.autenticar(usuario);
      
      if(usuario!=null)
          return "exito";
      else
          return "fallo";
    }
    
    public String usuaria()
    {
        
         return "usaste";
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       //-------------------------------------------
    
    public void save(){
      UsuarioRepository usuarioRepository= new UsuarioRepository(this.entityManager);
      
      usuarioRepository.save(this.usuario);
      this.usuario=new Usuario();
      this.usuario=null;
    
     
    }
    
      public void update(Usuario usuario)
      {
        UsuarioRepository usuarioRepository=new UsuarioRepository(
                this.entityManager);
        usuarioRepository.update(usuario);
        this.usuarios=null;
      }
      
    public void remove (Usuario usuario){
      UsuarioRepository usuarioRepository = new UsuarioRepository(
              this.entityManager);
      usuarioRepository.remove(usuario);
      this.usuarios=null;
    
    }
    
    //------------------------------------
    
    public List<Usuario> getUsuarios()
    {
     UsuarioRepository usuarioRepository =
             new UsuarioRepository(this.entityManager);
     
     usuarios=usuarioRepository.getUsuarios();
     return usuarios;
    
    }
    
    
    
    @SuppressWarnings("unused")
    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute(" EntityManager ");
    }
    
      public Long getCount() {
          UsuarioRepository repository = new UsuarioRepository(this.entityManager);
        
        return repository.getCountUsuarios();
    }
}



