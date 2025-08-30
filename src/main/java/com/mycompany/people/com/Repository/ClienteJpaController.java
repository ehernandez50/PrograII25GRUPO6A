/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;


public class ClienteJpaController implements Serializable {
    
    EntityManagerFactory emf;
    public ClienteJpaController(EntityManagerFactory emf){
    this.emf =emf;
    
    }
     public Cliente buscar(String nombreEmpresa) {
    EntityManager em = emf.createEntityManager();
    Cliente cliente = null;
    try {
        cliente = em.createNamedQuery("Cliente.findByEmpresa", Cliente.class)
                    .setParameter("empresa", nombreEmpresa)
                    .getSingleResult();
    } catch (NoResultException e) {
        System.out.println("No se encontró el usuario: " + nombreEmpresa);
    } finally {
        em.close();
    }
    return cliente;
    }
    
     
  public void   registroCliente(Usuario Id,String empresa,String contacto, String correo, Integer postal,Long nit,String puesto,int tel){
    EntityManager em = emf.createEntityManager(); 
     Cliente cliente = new Cliente();
     
     cliente.setUsuarioId(Id);
     cliente.setEmpresa(empresa);
     
     cliente.setNombreContacto(contacto);
     cliente.setCorreo(correo);
     cliente.setCodPostal(postal);
     cliente.setNit(nit);
     cliente.setPuestoContacto(puesto);
     cliente.setTelefono(tel);
     
em.getTransaction().begin();
em.persist(cliente);
em.getTransaction().commit();
     
     
     
     }
    
    
    

}
