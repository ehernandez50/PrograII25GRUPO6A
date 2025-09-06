/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.apps;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;
import com.mycompany.people.com.Models.Administrador;
import com.mycompany.people.com.Models.LogSesion;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.servicios.ServiciosAdministrador;
import com.mycompany.people.com.servicios.ServiciosUsuario;
import com.mycompany.people.com.servicios.register;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppAdministrador {
    
    EntityManagerFactory emf;
    Scanner sc = new Scanner(System.in);
    ServiciosUsuario us ;
    
    Administrador administrador;
    ServiciosAdministrador serviAdmin;
    ServiciosUsuario serviUsuer;
    
    public AppAdministrador(EntityManagerFactory emf){
    this.emf = emf;
    this.us  = new ServiciosUsuario(emf);
    this.serviAdmin= new ServiciosAdministrador(emf);
    this.serviUsuer=new ServiciosUsuario(emf);
    
    }
    
    
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
        AppAdministrador a = new AppAdministrador(emf);
            Scanner sc = new Scanner(System.in);
        
        a.FormModificarUsuario();
    }
 
    public void AppAdministrador() throws InterruptedException, NoSuchAlgorithmException{
    
    
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
                   FormRegistrarAdministrador();
                    break;
                case 2:
                    FormModificarUsuario();
                    break;
                case 3:
                    FormEliminarUsuario();
                    break;
                case 4:
                    Logs();
                    break;
                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida.");
            }
        }

        
    
    }
    
    public void FormRegistrarAdministrador() throws InterruptedException, NoSuchAlgorithmException{
      
        
      

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
        serviAdmin.CrearAdministrador(userb,coduser, creacion, puestoEmpleado);
        Thread.sleep(1000);
        
       
      
        
    
    }
    public void FormModificarUsuario(){
    
     
        while (true) {            
            
        
    System.out.println("Ingrese el Username: ");
    
    String username = sc.nextLine().trim();
    Usuario user = serviUsuer.buscarUsuario(username);
    
    
    
    if (user==null) {
            System.out.println("No existe el usuario"); 
            return;
        }
    
    
    
    
    
    
    
    System.out.println("Seleccione el campo a modificar: ");
    System.out.println("   1. Username"
                + "         2. correo"
                + "         3. status");
    
            if (sc.hasNextInt()) {
                
                int opcion = sc.nextInt();
                if (opcion<=3&&opcion>=1) {
                    
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo username: ");
                            String username2= sc.nextLine().trim();
                            user.setNombreUsuario(username2);
                            serviUsuer.ModificarUsuario(user);
                            return;
                            case 2:
                                
                                System.out.println("Ingrese el nuevo correo: ");
                                String correo = sc.nextLine().trim();
                                user.setCorreo(correo);
                                serviUsuer.ModificarUsuario(user);
                                return;
                            
                            
                            case 3:
                                System.out.println("Status: ");
                                if (sc.hasNextBoolean()) {
                                   boolean status = sc.nextBoolean();
                                    user.setStatus(status);
                                    serviUsuer.ModificarUsuario(user);
                                    return;
                                }
                                else{
                                    System.out.println("Ingrese true o false");
                                }
                                
                               
                                        
                                
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                    
                }
            }
            else{
                System.out.println("elija una opcion valida");
                continue;
            }
 
        
        
        
        
        
        
        
        }
    }
    public void FormEliminarUsuario(){
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Ingrese el nombre de usuario a desactivar: ");
        String nombreUsuario= sc.nextLine();
        Usuario user = serviUsuer.buscarUsuario(nombreUsuario);
        
        if (user ==null) {
            System.out.println("El usuario no existe");
            
        }
        else{
            serviAdmin.EliminarUsuario(user);
            System.out.println("El usuario "+ nombreUsuario+ "  Ha sido desactivado");
        }
    
    
    }
    public void Logs(){
    
        register r = new register(emf);
        List<LogSesion> logs =r.notificacion();
    
        for (LogSesion log : logs) {
            System.out.println("=============================");
            
            System.out.println("evento: "+log.getEvento());
            System.out.println("detalle: "+log.getDetalle());
            System.out.println("hora: "+log.getTiempo());
            System.out.println("Usuario: "+ log.getUsuarioId().getNombreUsuario());
            System.out.println("Ip: "+log.getip());
            System.out.println("=============================");
        }


}
   
    
    
    
    
    
}
