
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.CodigoPostal;
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

    
   
   
   
   
    public Usuario buscarUsuario(String nombreUsuario) {
    EntityManager em = emf.createEntityManager();
    Usuario usuario = null;
    
    try {
        usuario = em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class)
                    .setParameter("nombreUsuario", nombreUsuario)
                    .getSingleResult();
    } catch (NoResultException e) {
        return null;
        
    } finally {
        
    }
    return usuario;
    }
    
    
    
    
    
    
      public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

      
      
      
      
      
    public static boolean verificarPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    
    
    
    
    
public  void CrearUsuario(String username, String password, String correo, int roles) throws NoSuchAlgorithmException{

EntityManager em = emf.createEntityManager();

    try {
        
    
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
Rol r =em.find(Rol.class, roles);
Usuario userRol= em.find(Usuario.class,usuario.getUsuarioId());
rol.setRolId(r);

rol.setUsuarioId(usuario);


em.getTransaction().begin();
em.persist(rol);
em.getTransaction().commit();




    }
    else{
        System.out.println("Ya existe el usuario");
    }

} catch (Exception e) {
    
    em.getTransaction().rollback();
    
    }

    }
    
    
public Integer login(String user, String pass) {
    EntityManager em = emf.createEntityManager();

    try {
        Usuario u = buscarUsuario(user);

        if (u != null) {
            String storedHash = u.getPasswordHash();


            if (verificarPassword(pass, storedHash)) {
               
              
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
        
    }
    return null;
}


}
