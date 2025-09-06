/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.servicios;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.Factura;
import com.mycompany.people.com.Models.FacturaDetalle;
import com.mycompany.people.com.Models.OfertaEmpleo;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jovany
 */
public class ServiciosFactura {
    
    
    EntityManagerFactory emf;
    
    
    public ServiciosFactura(EntityManagerFactory emf){
        
        this.emf = emf;

    }
    
    
    public Factura Generar(Cliente cliente,Integer Total, Date fecha){
    
       EntityManager em = emf.createEntityManager();
         
        Factura  f = new Factura();
        Long total = (long)Total;
        f.setClienteId(cliente);
        f.setFecha(fecha);
        f.setTotal(total);
        
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
        em.close();
        }
       
    
        
        return f;
    
    
    
    }
    public FacturaDetalle GenerarDetalleFactura(OfertaEmpleo ofertaEmpleoId, Factura facturaId){
    
        EntityManager em = emf.createEntityManager();
        
        FacturaDetalle fd = new FacturaDetalle();
        
        
        fd.setOfertaEmpleoId(ofertaEmpleoId);
        fd.setFacturaId(facturaId);
        
        try {
            em.getTransaction().begin();
            em.persist(fd);
            em.getTransaction().commit();
                    
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    finally{
        
        em.close();
        
        }
    
    return fd;
             
    
    
    
    }
    




}
