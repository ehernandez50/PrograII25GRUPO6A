/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.servicios;

import com.mycompany.people.com.Models.LogSesion;
import com.mycompany.people.com.Models.Usuario;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jovany
 */
public class register {
    EntityManagerFactory emf;
    public register(EntityManagerFactory emf){
    this.emf=emf;
    }
    
    
    public void log(Usuario user,String evento,Date date,String detalle) throws UnknownHostException{
         
        
        EntityManager em = emf.createEntityManager();
        LogSesion sesion = new LogSesion();
        sesion.setDetalle(detalle);
        sesion.setEvento(evento);
        sesion.setTiempo(date);
        sesion.setUsuarioId(user);
        
        InetAddress ip = InetAddress.getLocalHost();
        sesion.setIp(ip.getHostAddress());
        
        
        try {
            em.getTransaction().begin();
            em.persist(sesion);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }
        finally{
        em.close();
        }
    
    notificacion();
    
    
    }
    public List<LogSesion> notificacion(){
    EntityManager em = emf.createEntityManager();
        
        
        try {
            List<LogSesion> s = em.createNamedQuery("LogSesion.findAll",LogSesion.class)
                .getResultList();
            
            
            return s;
        } catch (Exception e) {
            return null;
        }
        
        
        
    
    }
}
