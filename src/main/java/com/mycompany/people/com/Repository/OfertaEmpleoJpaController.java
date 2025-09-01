/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Costo;
import com.mycompany.people.com.Models.NivelAcademico;
import com.mycompany.people.com.Models.OfertaEmpleo;
import com.mycompany.people.com.Models.Requisito;
import com.mycompany.people.com.Models.Vacante;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jovany
 */
public class OfertaEmpleoJpaController {
    
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf;
    
     
    public OfertaEmpleoJpaController(EntityManagerFactory emf){
    
    this.emf = emf;
    
    }
    
        
    
    public NivelAcademico ElegirNivel(){
      EntityManager em = emf.createEntityManager();
        
     List< NivelAcademico> n;
      
      n = em.createNamedQuery("NivelAcademico.findAll",NivelAcademico.class )
              .getResultList();
      
        for (NivelAcademico nivelAcademico : n) {
            
            
            System.out.println(nivelAcademico.getNivelAcademicoId());
            System.out.println(nivelAcademico.getNombre());
            
        }
        Integer opcion=null;
        
        NivelAcademico nu = new NivelAcademico();
        while (true) {  
            System.out.println("Nivel Academico: seleccione");
            if (sc.hasNextInt()) {
                opcion= sc.nextInt();
                try {
                    
        nu = em.createNamedQuery("NivelAcademico.findByNivelAcademicoId", NivelAcademico.class)
                .setParameter("nivelAcademicoId", opcion)
                .getSingleResult();
                } catch (Exception e) {
                    continue;
                }
                sc.nextLine();
                break;
            }
            else{
                System.err.println("Selccione una correcta");
                sc.nextLine();
            }
            
            
            
       
            
        }
         
    
    return nu;
    }
   
    
    public Costo buscarCosto(){
        
    EntityManager em = emf.createEntityManager();
    
    List<Costo> costo=null;
    
    costo = em.createNamedQuery("Costo.findAll", Costo.class)
            .getResultList();
    
    
    System.out.printf("%-10s |%-10s | %-10s%n","No.", "Días", "Precio");
System.out.println("------------------------");


for (Costo costo1 : costo) {
    System.out.printf("%-10d |%-10d | %-10d%n", costo1.getCostoId(),costo1.getDias(), costo1.getPrecio());

}

 Long opcion;
 Costo costo7 = new Costo();
         while (true) {  
             
          System.out.println("Seleccione el plan.");
          
        if (sc.hasNextInt()) {
            opcion = sc.nextLong();
            sc.nextLine();
            
            try {
                
            
         costo7 = em.createNamedQuery("Costo.findByCostoId",Costo.class)
                 .setParameter("costoId",opcion)
                 .getSingleResult();
         break;
         } catch (Exception e) {
             continue;
            }
         
            
                    
        }
        else{
            System.out.println("ingrese una opcion valida");
            sc.nextLine();
        }
            }
         
         
         
         
                 
                 

    return costo7;
    
    }
    
    public void CrearOferta(Cliente cliente, Vacante vacanteId, Costo costo){
     OfertaEmpleo of = new OfertaEmpleo();
     EntityManager em = emf.createEntityManager();
      
      
        
      of.setFecha(new Date());

      of.setClienteId(cliente);
      
      of.setVacanteId(vacanteId);
      
      of.setCostoId(buscarCosto());
      
        try {
            em.getTransaction().begin();
            em.persist(of);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
      
      
      
 

    
    
    }
    
    public void  VerOfertas(Cliente cliente){
     List<OfertaEmpleo> of=null;
        try {
            
        
    EntityManager em = emf.createEntityManager();
    of = em.createNamedQuery("OfertaEmpleo.buscarOfertas", OfertaEmpleo.class)
            .setParameter("idcliente",cliente )
            .getResultList();
    for (OfertaEmpleo ofertaEmpleo : of) {
            System.out.println(ofertaEmpleo.getFecha());
            System.out.println(ofertaEmpleo.getClienteId().getEmpresa());
            System.out.println(ofertaEmpleo.getVacanteId().getPuesto());
            
        }
        } catch (Exception e) {
            
            System.out.println("NO tien vacantes"
                    + "");
            
            
        }
        
    
    }
    
    
    
    
    
    
   
    
    
    
    
    
    public Vacante CrearVacante(Integer experiencia,Integer edad,NivelAcademico nivel,String puesto,String descripcion, Integer salario, CodigoPostal cod){
    
    EntityManager em = emf.createEntityManager();
    Requisito r = new Requisito();
        
        try {
            
        
    r.setExpertenciaAnos(experiencia);
    r.setEdad(edad);
    r.setNivelAcademicoId(nivel);
    
    em.getTransaction().begin();
    em.persist(r);
    em.getTransaction().commit();
    
    
    } catch (Exception e) {
        em.getTransaction().rollback();
        }
    
    
    Vacante v = new Vacante();
    
    
        try {
            
       
    v.setPuesto(puesto);
    v.setDescripcion(descripcion);
    v.setSalario(salario);
    v.setCodPostalId(cod);
    v.getRequisitoId();
    
    em.getTransaction().begin();
    em.persist(v);
    em.getTransaction().commit();
    
     } catch (Exception e) {
         em.getTransaction().rollback();
        }
    return v;
    
    }
}
