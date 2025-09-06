
package com.mycompany.people.com;







import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.apps.AppAdministrador;
import com.mycompany.people.com.servicios.ServiciosCliente;
import com.mycompany.people.com.servicios.ServiciosPostulante;
import com.mycompany.people.com.servicios.ServiciosUsuario;
import com.mycompany.people.com.apps.AppCliente;
import com.mycompany.people.com.apps.AppPostulante;
import com.mycompany.people.com.servicios.register;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UnsupportedLookAndFeelException;


public class Inicio {
    
     EntityManagerFactory emf;
     Scanner sc= new Scanner(System.in);
   
   public Inicio(EntityManagerFactory emf){
   this.emf=emf;

   }
    
    
   public static void main(String[] args) throws UnsupportedLookAndFeelException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
        Inicio inicio = new Inicio(emf);
        inicio.menu();
   
   
   }
 

       
    
    
      

    void menu(){
        while (true) {            
            
            try {
                
         System.out.println("╔══════════════════╗");
        System.out.println("║   MENÚ PRINCIPAL ║");
        System.out.println("╚══════════════════╝");
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
                        ServiciosPostulante p = new ServiciosPostulante(emf);
                        p.FormPostulante();
                        
                        
                    break;
                    case 2:
                      ServiciosCliente servicios = new ServiciosCliente(emf);
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
                           +   "2. Salir");  
            
            if (sc.hasNextInt()) {
            int op = sc.nextInt();
            if (op==1||op==2) {
            if (op==1) {
            try {            
          System.out.println("Usuario");
          String usuario = sc.next();
          
          
          System.out.println("Contrasena");
          String contrasena = sc.next();
          
                  
          
         ServiciosUsuario usuarioJpa = new ServiciosUsuario(emf);
          
         Integer rol=  usuarioJpa.login(usuario, contrasena);
         Usuario UsuarioLogeado = usuarioJpa.buscarUsuario(usuario);
         
                   
                   
                   if (rol !=null) {
                    
                       switch (rol) {
                           case 3:
                               AppCliente cliente = new AppCliente(emf,UsuarioLogeado);
                               cliente.AppCliente();
                               
                               register r2 = new register(emf);
                               r2.log(UsuarioLogeado, "login", new Date(), "El usuario :"+UsuarioLogeado.getNombreUsuario()+" se logeo"+ " como cliente");
                                   
                               
                               break;
                               case 2:
                                   AppPostulante p = new AppPostulante(UsuarioLogeado.getUsuarioId());
                                   p.PostulanteApp();
                                   register r3 = new register(emf);
                                 r3.log(UsuarioLogeado, "login ", new Date(),"El usuario :"+UsuarioLogeado.getNombreUsuario()+" se logeo"+" como postulante");
                                   
                                   
                               
                               break;
                               case 1:
                                   AppAdministrador admin = new AppAdministrador(emf);
                                               register r = new register(emf);
                                 r.log(UsuarioLogeado, "login ", new Date(), "El usuario :"+UsuarioLogeado.getNombreUsuario()+" se logeo");
                                   
                                   admin.AppAdministrador();
                              
                    
                               
                               break;
                           default:
                               throw new AssertionError();
                       }
                       
                       
                       
                       
                       
                       
                   }
                   else{
                       
                   //    System.out.println("El usuario no existe");
                   }
         
           
                   
           } catch (Exception e) {
                   System.out.println(e);
                 //  System.out.println("El usuario no existe");
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
