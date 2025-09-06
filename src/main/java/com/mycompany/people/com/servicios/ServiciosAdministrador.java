/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.servicios;

import com.mycompany.people.com.Models.Administrador;
import com.mycompany.people.com.Models.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jovany
 */
public class ServiciosAdministrador {
    EntityManagerFactory emf;
    ServiciosUsuario us;
    
    
    public ServiciosAdministrador(EntityManagerFactory emf){
     this.emf = emf;
    this.us  = new ServiciosUsuario(emf);
    }
    
    public void ModificarAdministrador(Administrador admin){
        
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
        
        em.close();
        }
        

        
        
        
    
    
    }
    public void CrearAdministrador(Usuario usuarioId,Integer cod, Date creacion,String puestoEmpleado){
    
    
        EntityManager em = emf.createEntityManager();
        Administrador ad = new Administrador();
        ad.setUsuarioId(usuarioId);
        ad.setCodEmpleado(cod);
        ad.setCreacion(creacion);
        ad.setPuestoEmpleado(puestoEmpleado);
        
        try {
            em.getTransaction().begin();
            em.persist(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            
           em.getTransaction().rollback();
        }
        finally{
        
        em.close();
        }
        
        
    
    
    }
    public void EliminarUsuario(Usuario usuario){
      
        
    EntityManager em = emf.createEntityManager();
    usuario.setStatus(false);
    
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
                    
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
        em.close();
        }
    
        
        
    }
}
