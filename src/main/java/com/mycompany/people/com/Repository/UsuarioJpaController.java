
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Rol;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Models.UsuarioRol;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioJpaController {
   EntityManagerFactory emf;
   public UsuarioJpaController(EntityManagerFactory emf){
   this.emf=emf;

   }
    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
        

EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
        UsuarioJpaController usuarioController = new UsuarioJpaController(emf);
        PostulanteJpaController postulanteController = new PostulanteJpaController(emf);
      

        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Postulante");
            System.out.println("3. Registrar Admin");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            String user, pass, correo;

            switch (opcion) {
                case 1: 
                    System.out.println("\n--- Registro de Cliente ---");
                    System.out.print("Nombre de usuario: ");
                    user = sc.nextLine();
                    System.out.print("Contraseña: ");
                    pass = sc.nextLine();
                    System.out.print("Correo: ");
                    correo = sc.nextLine();
                    
                    int rolCliente = 1; 
                    Thread.sleep(1000);
                    usuarioController.register(user, pass, correo, rolCliente);
                    Thread.sleep(1000);
                    Usuario uscliente = usuarioController.buscarUsuario(user);
                    
                    
                    System.out.print("Nombre de empresa: ");
                    String empresa = sc.nextLine();
                    System.out.print("nombre contacto: ");
                    String telefono = sc.nextLine();
                    System.out.print("correo: ");
                    String direccion = sc.nextLine();
                    System.out.print("Codigo Postal: ");
                    int postal = sc.nextInt();
                    System.out.println("Nit: ");
                    Long nitc = sc.nextLong();
                    System.out.println("Puesto del Contacto: ");
                    String puesto= sc.next();
                    System.out.println("Telefono");
                    int tel = sc.nextInt();
                    ClienteJpaController cliente = new  ClienteJpaController(emf);
                    
                    cliente.registroCliente(uscliente,empresa, correo, correo, postal, nitc, puesto, tel);
                    System.out.println("✅ Cliente registrado correctamente.");
                    break;

                case 2: 
                    System.out.println("\n--- Registro de Postulante ---");
                    System.out.print("Nombre de usuario: ");
                    user = sc.nextLine();
                    System.out.print("Contraseña: ");
                    pass = sc.nextLine();
                    System.out.print("Correo: ");
                    correo = sc.nextLine();

                    int rolPostulante = 2; 
                    usuarioController.register(user, pass, correo,rolPostulante);
                    Usuario usPostulante = usuarioController.buscarUsuario(user);

                    // Datos extra de Postulante
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("DPI: ");
                    long dpi = sc.nextLong();
                    sc.nextLine();
                    System.out.print("NIT: ");
                    long nit = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telp = sc.nextLine();
                    System.out.print("Teléfono adicional: ");
                    String telAdicional = sc.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = sc.nextLine();
                    System.out.println("Genero: 1. hombre    2. mujer");
                    int genero= sc.nextInt();
                    System.out.println("Codigo Postal");
                    int codPostal = sc.nextInt();
                    
                    Postulante postulante = new Postulante();
                   

                
                    System.out.println("✅ Postulante registrado correctamente.");
                    break;

                case 3: 
                    System.out.println("\n--- Registro de Admin ---");
                    System.out.print("Nombre de usuario: ");
                    user = sc.nextLine();
                    System.out.print("Contraseña: ");
                    pass = sc.nextLine();
                    System.out.print("Correo: ");
                    correo = sc.nextLine();

                    int rolAdmin = 3; 
                     usuarioController.register(user, pass, correo, rolAdmin);

                    System.out.print("Nombre: ");
                    String nombreAdmin = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.print("Correo institucional: ");
                    String correoInst = sc.nextLine();

                  

                    
                    System.out.println("✅ Admin registrado correctamente.");
                    break;

                case 4:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
        emf.close();



        
      
        
    }
   
   
   
   
    public Usuario buscarUsuario(String nombreUsuario) {
    EntityManager em = emf.createEntityManager();
    Usuario usuario = null;
    try {
        usuario = em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class)
                    .setParameter("nombreUsuario", nombreUsuario)
                    .getSingleResult();
    } catch (NoResultException e) {
        
    } finally {
        em.close();
    }
    return usuario;
    }
    
    
    
    
    
    
      public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

      
      
      
      
      
    public static boolean verificarPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    
    
    
    
    
public  void register(String username, String password, String correo, int roles) throws NoSuchAlgorithmException{

EntityManager em = emf.createEntityManager();


if (buscarUsuario(username)==null) {
String hash = hashPassword(password);
Usuario usuario = new Usuario();



usuario.setNombreUsuario(username);
usuario.setPasswordHash(hash);
usuario.setCorreo(correo);
usuario.setStatus(true);
em.getTransaction().begin();
em.persist(usuario);
em.getTransaction().commit();





UsuarioRol rol = new UsuarioRol();
em.getTransaction().begin();
Rol r =em.find(Rol.class, roles);
Usuario userRol= em.find(Usuario.class,usuario.getUsuarioId());
rol.setRolId(r);
rol.setUsuarioId(usuario);
em.persist(rol);
em.getTransaction().commit();





    }
    else{
        System.out.println("Ya existe el usuario");
    }


    }
    
    
public Integer login(String user, String pass) {
    EntityManager em = emf.createEntityManager();

    try {
        Usuario u = buscarUsuario(user);

        if (u != null) {
            String storedHash = u.getPasswordHash();

            if (storedHash == null || storedHash.isEmpty()) {
                System.out.println(" Usuario no tiene contraseña configurada");
                
            }

            if (verificarPassword(pass, storedHash)) {
                System.out.println(" Contraseña correcta!");
               
              
           
Integer rolId = em.createNamedQuery("UsuarioRol.buscarRolPorUsuario", Integer.class)
                  .setParameter("usuarioId", u.getUsuarioId())
                  .getSingleResult();
return rolId;

                
                
                
                
                
                
            } else {
                System.out.println("Contraseña incorrecta!");
            }
        } else {
            System.out.println(" Usuario no encontrado");
        }
    } finally {
        em.close();
    }
    return null;
}


}
