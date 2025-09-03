/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Servicios;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;
import com.mycompany.people.com.Models.Administrador;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Repository.UsuarioJpaController;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppAdministrador {
    
    EntityManagerFactory emf;
    Scanner sc = new Scanner(System.in);
    UsuarioJpaController us ;
    
    Administrador administrador;
    
    
    public AppAdministrador(EntityManagerFactory emf){
    this.emf = emf;
    this.us  = new UsuarioJpaController(emf);
    
    }
    
    
    
    
 
    public void AppAdministrador(){
    
    
     int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Ver Logs");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("⚠ Entrada inválida, debe ser un número.");
                sc.next(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("👉 Opción: Crear nuevo usuario");
                    break;
                case 2:
                    System.out.println("👉 Opción: Modificar usuario");
                    break;
                case 3:
                    System.out.println("👉 Opción: Eliminar usuario");
                    break;
                case 4:
                    System.out.println("👉 Opción: Ver Logs");
                    break;
                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida.");
            }
        }

        
    
    }
    public void ModificarAdministrador(Administrador admin){
        
        EntityManager em = emf.createEntityManager();
        

        
        
        
    
    
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
    
   
    public void FormAdministrador() throws InterruptedException, NoSuchAlgorithmException{
      
        
      

    String user;
    while (true) {
        System.out.print("Nombre de usuario: ");
        user = sc.next().trim();
        
        Usuario validacion= us.buscarUsuario(user);
        
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
        
        
        
        System.out.print("Ingrese el código Usuario: ");
        int coduser;
        
        while (true) {
            if (sc.hasNextInt()) {
                coduser = sc.nextInt();
                sc.nextLine(); 
                break;
            } else {
                System.out.print("Valor inválido, ingrese un número entero: ");
                sc.next(); 
            }
        }

        
       Date creacion= new Date();

        
        System.out.print("Ingrese el puesto del empleado (solo letras y espacios): ");
        String puestoEmpleado;
        while (true) {
            puestoEmpleado = sc.nextLine();
            if (puestoEmpleado.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+")) {
                break;
            } else {
                System.out.print("Entrada inválida, use solo letras y espacios: ");
            }
        }
        int cod=1;
        

        us.CrearUsuario(user, pass, correo, cod);
        Thread.sleep(100);
        Usuario userb=  us.buscarUsuario(user);
        Thread.sleep(100);
        CrearAdministrador(userb,coduser, creacion, puestoEmpleado);
        Thread.sleep(1000);
        
       
      
        
    
    }
    public void FormModificarAdmin(){
    
        
        
    
    }
    
    public void Logs(){
    
    
    


}
   
    
    
    
    
    
}
