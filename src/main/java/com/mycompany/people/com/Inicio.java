/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com;



import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Repository.ClienteJpaController;

import com.mycompany.people.com.Repository.PostulanteJpaController;
import com.mycompany.people.com.Repository.UsuarioJpaController;
import com.mycompany.people.com.Servicios.AppCliente;
import com.mycompany.people.com.Servicios.AppPostulante;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jovany
 */
public class Inicio {
    
     EntityManagerFactory emf;
   
   public Inicio(EntityManagerFactory emf){
   this.emf=emf;

   }
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
   

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
        Inicio inicio = new Inicio(emf);
        inicio.menu();
        
        
        
    }
    
    
    
    
    
    
    
   
   
    
    Scanner sc= new Scanner(System.in);
    
    
    public  void menu(){
        while (true) {            
            
            try {
                
            
        System.out.println("-------------------------------------");
        System.out.println("1. Registrase");
        System.out.println("2. Iniciar Sesion");
        System.out.println("3. Exit");
        System.out.println("--------------------------------------");
        
        int opcion = sc.nextInt();
                switch (opcion) {
                       case 1:
                           MenuRegistrarse();
                        break;
                        case 2:
                        IniciarSesion();
                        break;
                        case 3:
                        return;
                        
                    default:
                        throw new AssertionError();
                }
        } catch (Exception e) {
                System.out.println("Ingrese una opcion valida");
                sc.nextLine();
            }
        }
        
        
        
        
        
    }
    
    
       void MenuRegistrarse(){
        
        while (true) {            
            
            try {
                
            
                System.out.println("1. Postulante");
                System.out.println("2. Empresa");
                System.out.println("3. exit");
        int opcion = sc.nextInt();
        
        
        
            switch (opcion) {
                    case 1:
                        PostulanteJpaController p = new PostulanteJpaController(emf);
                        p.FormPostulante();
                        
                        
                    break;
                    case 2:
                      ClienteJpaController servicios = new ClienteJpaController(emf);
                      servicios.FormCliente();
                      
                    break;
                    
                    
                    case 3:
                        return;
                    
                   
                default:
                    
                    System.out.println("otra");
                    throw new AssertionError();
            }
    
    } catch (Exception e) {
                System.out.println("Ingrese un opcion valida");
                System.out.println(e);
            }
            
            
            
            
            
            
            
        }
        
        
     
            
            
            
            
    }
    
    
    
       void IniciarSesion(){
           
           while (true) {               
               
            
                   
          
           
           System.out.println("1. Sing In\n"
                           +          "2. Salir");  
            
                   if (sc.hasNextInt()) {
                       int op = sc.nextInt();
                       
                       if (op==1||op==2) {
                           if (op==1) {
                               
                      try {            
                                  System.out.println("Usuario");
          String usuario = sc.next();
          
          
          System.out.println("Contrasena");
          String contrasena = sc.next();
          
                  
          
         UsuarioJpaController usuarioJpa = new UsuarioJpaController(emf);
          
         Integer rol=  usuarioJpa.login(usuario, contrasena);
         Usuario userId = usuarioJpa.buscarUsuario(usuario);
         
                   System.out.println(rol);
                   System.out.println("");
                   
                   if (rol !=null) {
                    
                       switch (rol) {
                           case 3:
                               AppCliente cliente = new AppCliente(emf,userId);
                               cliente.AppCliente();
                               break;
                               case 2:
                                   AppPostulante p = new AppPostulante(userId.getUsuarioId());
                                   p.PostulanteApp();
                               
                               break;
                           default:
                               throw new AssertionError();
                       }
                       
                       
                       
                       
                       
                       
                   }
                   else{
                       
                       System.out.println("El usuario no existe");
                   }
         
           
                   
           } catch (Exception e) {
                   System.out.println(e);
                   System.out.println("El usuario no existe");
               } 
                               
                               
                               
                               
                           }
                           if (op==2) {
                               break;
                               
                           }
                           
                       }
                       else{
                           System.out.println("Vuelva a elegir");
                           sc.nextLine();
                           continue;
                       }
                   }
                   else{
                   sc.nextLine();
                   }
          
                   
                   
      
           }
    
    }
       
       
       
   
}
