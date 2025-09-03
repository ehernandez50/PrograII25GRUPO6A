/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Servicios;

import com.mycompany.people.com.Models.Rol;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Models.UsuarioRol;
import static com.mycompany.people.com.Repository.UsuarioJpaController.hashPassword;
import java.security.NoSuchAlgorithmException;
import javax.persistence.EntityManager;

/**
 *
 * @author Jovany
 */
public class ServiciosUsuarios {
    
    
    
    
    
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
    
}
