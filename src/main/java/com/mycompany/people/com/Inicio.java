/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com;

import com.mycompany.people.com.Repository.UsuarioJpaController;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sound.midi.Soundbank;

/**
 *
 * @author Jovany
 */
public class Inicio {
    public static void main(String[] args) {
        
        
        
        Inicio inicio=new Inicio();
        inicio.menu();
        
        
        
    }
    EntityManagerFactory emf;
    UsuarioJpaController usuarioJpa = new UsuarioJpaController(emf);
    
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
                           Registrarse();
                        break;
                        case 2:
                        
                        break;
                        case 3:
                        return;
                        
                    default:
                        throw new AssertionError();
                }
        } catch (Exception e) {
                System.out.println("Ingrese una opcion valida");
            }
        }
        
        
        
        
        
    }
    
    
    void Registrarse(){
        
        while (true) {            
            
            try {
                
            
        System.out.println("1. Postulante");
        System.out.println("2. Empresa");
        int opcion = sc.nextInt();
        
        
        
            switch (opcion) {
                    case 1:
                        System.out.println("postulante");
                        
                        
                    break;
                    case 2:
                        System.out.println("empresa");
                    break;
                    
                    
                    
                default:
                    
                    System.out.println("otra");
                    throw new AssertionError();
            }
    
    } catch (Exception e) {
                System.out.println("Ingrese un opcion valida");
            }
            
            
            
            
            
            
            
        }
        
        
     
            
            
            
            
    }
    
    
    
       void IniciarSesion(){
           
           while (true) {               
               
               try {
                   
               
           System.out.println("Usuario");
           String usuario = sc.next();
           
           System.out.println("Contrasena");
           String contrasena = sc.next();
           
           usuarioJpa.login(usuario, contrasena);
           
                   
           } catch (Exception e) {
               
                   System.out.println("Ingrese un opcion valida");
               }
           }
    
    }
}
