/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.OfertaEmpleo;
import com.mycompany.people.com.Models.Usuario;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;



public class ClienteJpaController implements Serializable {
    
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf;
    
    
    
    public ClienteJpaController(EntityManagerFactory emf){
     
    this.emf =emf;
   
    }
    
 
    
    
    
    
  public Cliente buscarCliente(Usuario idUser) {
    EntityManager em = emf.createEntityManager();
    Cliente cliente = null;
    try {
        cliente = em.createNamedQuery("Cliente.buscarPerfil", Cliente.class)
                    .setParameter("iduser",idUser )
                    .getSingleResult();
        
    } catch (NoResultException e) {
        System.out.println("No se encontró el usuario: " );
    } finally {
        
    }
    return cliente;
    }
   
  
  public void   registroCliente(Usuario Id,String empresa,String contacto, String correo, CodigoPostal postal,Long nit,String puesto,int tel){
    EntityManager em = emf.createEntityManager(); 
     Cliente cliente = new Cliente();
     
     cliente.setUsuarioId(Id);
     empresa.toLowerCase();
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
    
  public void FormCliente() throws InterruptedException, NoSuchAlgorithmException{
           
       
        
        

           while (true) {               
               
           UsuarioJpaController usuarioController = new UsuarioJpaController(emf);
    System.out.println("\n--- Registro de Cliente ---");

    String user;
    while (true) {
        System.out.print("Nombre de usuario: ");
        user = sc.nextLine().trim();
        
        Usuario validacion= usuarioController.buscarUsuario(user);
        
        if (user.isEmpty()||validacion!=null) {
            System.out.println(" El nombre de usuario no puede estar vacío o ya existe.");
        }
        else{
        break;}
    }

    
    String pass ;
    while (true) {
        System.out.print("Contraseña: ");
        pass = sc.nextLine().trim();
        if (pass.isEmpty()) {
            System.out.println("⚠️ La contraseña no puede estar vacía.");
            
        }
        else{
        break;
        }
    }

    
    String correo;
    while (true) {
        System.out.print("Correo de Empresa: ");
        correo = sc.nextLine().trim();
        
        if (correo.isEmpty() || !correo.contains("@")) {
            System.out.println("⚠️ Ingrese un correo válido.");
            
        }
        else{
        
        break;}
    }

    int rolCliente = 3; 
    Thread.sleep(1000);
    usuarioController.CrearUsuario(user, pass, correo, rolCliente);
    
    Thread.sleep(1000);
    Usuario uscliente = usuarioController.buscarUsuario(user);

    
    String empresa ;
    while (true) {
        System.out.print("Nombre de empresa: ");
        empresa = sc.nextLine().trim();
        if (empresa.isEmpty()) {
            System.out.println("⚠️ La empresa no puede estar vacía.");
            
        }
        else{
        break;}
        
    }
 String contacto;
    while (true) {
    System.out.print("Nombre Persona Contacto: ");
    contacto = sc.nextLine();
 if (contacto.isEmpty()) {
            System.out.println("⚠️ La empresa no puede estar vacía.");
            
        }
 else{
 break;}
    }
   

    int postal;
    CodigoPostal codigoPostal = new CodigoPostal();
    CodigoPostalJpaController c = new CodigoPostalJpaController(emf);
    while (true) {
        System.out.print("Código Postal: ");
        if (sc.hasNextInt()) {
            postal = sc.nextInt();
            Thread.sleep(1000);
            CodigoPostal cod = c.buscar(postal);
            
            if (cod!= null) {
                codigoPostal = cod;
                sc.nextLine();
                break;
                
            }
            else{
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
            
            }
 
            
        } else {
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
        }
    }

    Long nitc=null;
    while (true) {
        System.out.print("Nit: ");
        
        if (sc.hasNextLong()) {
            nitc = sc.nextLong();
            sc.nextLine();
            break;
            
        } else {
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
            
        }
    }
   
    
   String puesto;
  while (true) {   
      System.out.print("Puesto del contacto: ");
       puesto = sc.next();
      if (empresa.isEmpty()) {
    
          System.out.println("inlids");
      }
      else{
      
      break;}
      
  
 }
    int tel;
    while (true) {
        System.out.print("Teléfono: ");
        if (sc.hasNextInt()) {
            tel = sc.nextInt();
            sc.nextLine();
            break;
        } else {
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
            
        }
    }

     
    registroCliente(uscliente, empresa, contacto,correo, codigoPostal, nitc, puesto, tel);
    System.out.println("✅ Cliente registrado correctamente.");
    
    break;
    
    
      
           }

        
        

       
       }

  public void actualizarCliente(Cliente c) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(c); 
        em.getTransaction().commit();
    } finally {
        em.close();
    }
    }
 
  
  
  

 
 
 
}
