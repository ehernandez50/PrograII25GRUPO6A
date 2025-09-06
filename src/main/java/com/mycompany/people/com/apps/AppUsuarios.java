/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.apps;

import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.servicios.ServiciosUsuario;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jovany
 */
public class AppUsuarios {
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf;
public AppUsuarios(EntityManagerFactory emf){
this.emf = emf;

}
    public void FormUsuarioRegistrar() throws InterruptedException, NoSuchAlgorithmException{
    
            EntityManager em = emf.createEntityManager();
    while (true) {
        ServiciosUsuario usuarioController = new ServiciosUsuario(emf);
        System.out.println("\n--- Registro de Persona ---");
        

    String user;
    while (true) {
        System.out.print("Nombre de usuario: ");
        user = sc.next().trim();
        
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
        pass = sc.next().trim();
        if (pass.isEmpty()) {
            System.out.println("⚠️ La contraseña no puede estar vacía.");
            
        }
        else{
        break;
        }
    }

    
    String correo;
    while (true) {
        System.out.print("Correo: ");
        correo = sc.next().trim();
        
        if (correo.isEmpty() || !correo.contains("@")) {
            System.out.println("⚠️ Ingrese un correo válido.");
            
        }
        else{
        
        break;}
    }

    int rolCliente = 1; 
    Thread.sleep(1000);
    usuarioController.CrearUsuario(user, pass, correo, rolCliente);
    
    Thread.sleep(1000);
    Usuario uscliente = usuarioController.buscarUsuario(user);
    return;
    
    }
    }
}
