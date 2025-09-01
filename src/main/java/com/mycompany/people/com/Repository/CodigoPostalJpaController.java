/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.CodigoPostal;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Jovany
 */
public class CodigoPostalJpaController {
 
    EntityManagerFactory emf;
    
    public CodigoPostalJpaController(EntityManagerFactory emf){
    this.emf = emf;
    
    }
    public static void main(String[] args) throws InterruptedException {
           Scanner sc = new Scanner(System.in);
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
          CodigoPostalJpaController c = new CodigoPostalJpaController(emf);
          
          
         int postal = -1;
         CodigoPostal codigoPostal = new CodigoPostal();
        
         
        while (true) {
        System.out.print("Código Postal: ");
        if (sc.hasNextInt()) {
            postal = sc.nextInt();
            Thread.sleep(1000);
            CodigoPostal cod = c.buscar(postal);
            
            if (cod!= null) {
                codigoPostal = cod;
                System.out.println("si ");
                break;
                
            }
            else{
            System.out.println("no.");
            
            
            }
 
            
        } else {
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.next(); 
        }
    }
          
          
          
          
    }
    
    
     public CodigoPostal buscar(Integer codigo) {
    EntityManager em = emf.createEntityManager();
    CodigoPostal postal = null;
    try {
        postal = em.createNamedQuery("CodigoPostal.BuscarCodigo", CodigoPostal.class)
                    .setParameter("cod", codigo)
                    .getSingleResult();
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
    return postal;
    }
}
