/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Genero;
import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Models.Vacante;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author Jovany
 */
public class PostulanteJpaController {
    
     EntityManagerFactory emf;
   public PostulanteJpaController(EntityManagerFactory emf){
   this.emf=emf;

   }
    Scanner sc = new Scanner(System.in);
    
    public Postulante VerPerfil(Long usuarioId) {
    EntityManager em = emf.createEntityManager();
    Postulante postulante = null;
    try {
        postulante = em.createNamedQuery("Postulante.BuscarPerfil", Postulante.class)
                    .setParameter("usuarioID", usuarioId)
                    .getSingleResult();
    } catch (NoResultException e) {
        System.out.println("No se encontró el usuario: " + usuarioId);
    } finally {
        em.close();
    }
    return postulante;
    }
    
    public Postulante BuscarPerfil(Long postulanteBuscar) {
    EntityManager em = emf.createEntityManager();
    Postulante postulante = null;
    try {
        postulante = em.createNamedQuery("Postulante.BuscarPerfil", Postulante.class)
                    .setParameter("usuarioID", postulanteBuscar)
                    .getSingleResult();
    } catch (NoResultException e) {
        System.out.println("No se encontró el usuario: " + postulanteBuscar);
    } finally {
        em.close();
    }
    return postulante;
    }
    
    public void actualizarPostulante(Postulante p) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(p); 
        em.getTransaction().commit();
    } finally {
        em.close();
    }
    }
    
    
    
    
    
    
    
    
    
    
    public List<Vacante> buscarVacantes() {
    EntityManager em = emf.createEntityManager();
    List<Vacante> vacantes = new ArrayList<>(); // inicializar vacía
    try {
        vacantes = em.createNamedQuery("Vacante.findAll", Vacante.class)
                     .getResultList();
    } finally {
        em.close();
    }

    
        for (Vacante vacante : vacantes) {
            System.out.println("-------------------------");
            System.out.println(vacante.getVacanteId());
            System.out.println("Lugar: "+vacante.getCodPostalId().getMunicipioId().getNombre());
            System.out.println("Puesto: "+vacante.getPuesto());
            System.out.println("Descripcion: "+vacante.getDescripcion());
            System.out.println("Nivel Academico: "+vacante.getRequisitoId().getNivelAcademicoId().getNombre());
            System.out.println("Anos de Experiencia: "+vacante.getRequisitoId().getExpertenciaAnos()+ "anos");
            System.out.println("Edad: "+vacante.getRequisitoId().getEdad());
            System.out.println("-------------------------");
        }

    return vacantes;
}
    
    
    
    public void FormPostulante() throws InterruptedException, NoSuchAlgorithmException {
        EntityManager em = emf.createEntityManager();
    while (true) {
        UsuarioJpaController usuarioController = new UsuarioJpaController(emf);
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

    int rolCliente = 2; 
    Thread.sleep(1000);
    usuarioController.register(user, pass, correo, rolCliente);
    
    Thread.sleep(1000);
    Usuario uscliente = usuarioController.buscarUsuario(user);
    
String nombre;
while (true) {
            System.out.print("Nombre: ");
            
            if (sc.hasNextInt()) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
                sc.nextLine();
            } else {
                nombre = sc.next().trim();
                break;
            }
        }


        String apellido;
        while (true) {
            System.out.print("Apellido: ");
            
            if (sc.hasNextInt()) {
                
                System.out.println("⚠️ El apellido no puede estar vacío.");
                sc.nextLine();
            } else {
                apellido = sc.next().trim();
                break;
            }
        }

        
        Long dpi;
        while (true) {
            System.out.print("DPI: ");
            if (sc.hasNextLong()) {
                dpi = sc.nextLong();
                sc.nextLine();
                break;
            } else {
                System.out.println("⚠️ Debe ingresar un número válido.");
                sc.nextLine();
            }
        }

        
        Long nit;
        while (true) {
            System.out.print("NIT: ");
            if (sc.hasNextLong()) {
                nit = sc.nextLong();
                sc.nextLine();
                break;
            } else {
                System.out.println("⚠️ Debe ingresar un número válido.");
                sc.nextLine();
            }
        }

        
        int telefono;
        while (true) {
            System.out.print("Teléfono: ");
            if (sc.hasNextInt()) {
            telefono = sc.nextInt();
            sc.nextLine();
           break;
           
            } else {
                 System.out.println("⚠️ Debe ingresar un número válido.");
                
            }
        }

        
       int telAdicional;
        while (true) {
            System.out.print("Teléfono: ");
            if (sc.hasNextInt()) {
            telAdicional = sc.nextInt();
            sc.nextLine();
           break;
           
            } else {
                System.out.println("⚠️ Debe ingresar un número válido.");
                sc.nextLine();
            }
        }
        
        
        String nacionalidad;
        while (true) {
            System.out.print("Nacionalidad:  ");
            
            if (sc.hasNextInt()) {
                
                System.out.println("⚠️ Debe ingresar una nacionalidad válido o dejarlo vacío.");
                sc.nextLine();
            } 
            else {
                nacionalidad = sc.next().trim();
                break;
            }
        }

        
        String genero;
        Genero g;
        while (true) {
            System.out.print("Género (M/F/O): ");
            genero = sc.next().trim().toUpperCase();
            
            if (!(genero.equals("M") || genero.equals("F") || genero.equals("O"))) {
                System.out.println("⚠️ Ingrese M (Masculino), F (Femenino) o O (Otro).");
               
            } else {
                 int id=0;
                switch (genero) {
                    case "M":
                        id=1;
                        g = em.createNamedQuery("Genero.findByGeneroId",Genero.class)
                                .setParameter("generoId", id)
                                .getSingleResult();
                        break;
                        case "F":
                        id=2;
                        g = em.createNamedQuery("Genero.findByGeneroId",Genero.class)
                                .setParameter("generoId", id)
                                .getSingleResult();
                        break;
                        case "O":
                            id=3;
                        g = em.createNamedQuery("Genero.findByGeneroId",Genero.class)
                                .setParameter("generoId", id)
                                .getSingleResult();
                        
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            }
        }

        
        int postal;
        CodigoPostal codigoPostal = new CodigoPostal();
        CodigoPostalJpaController c = new CodigoPostalJpaController(emf);
        while (true) {
            System.out.print("Código Postal: ");
            if (sc.hasNextInt()) {
                postal = sc.nextInt();
                Thread.sleep(500);
                CodigoPostal cod = c.buscar(postal);

                if (cod != null) {
                    codigoPostal = cod;
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("⚠️ Debe ingresar un código postal válido.");
                    sc.nextLine();
                }
            } else {
                System.out.println("⚠️ Debe ingresar un número válido.");
                sc.nextLine();
            }
        }

       
      RegistrarPOstulante(nombre, apellido, postal, postal, telefono, telAdicional, nacionalidad, uscliente, g, codigoPostal);
        break;
    }
}

    
    public void RegistrarPOstulante(String nombre,String Apellido,int dpi,int nit,int telefono,int teladicional,String nacionalidad, Usuario usuarioId, Genero generoId, CodigoPostal codPostalId){
        EntityManager em =emf.createEntityManager();
        try {
            
       
    
    Postulante p = new Postulante();
    
    p.setNombre(nombre);
    p.setApellido(nombre);
    p.setDpi(dpi);
    p.setNit(nit);
    p.setTelefono(telefono);
    p.setTelefonoAdicional(teladicional);
    p.setNacionalidad(nacionalidad);
    p.setUsuarioId(usuarioId);
    p.setGeneroId(generoId);
    p.setCodPostalId(codPostalId);
    
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
            System.out.println("Usuario Registrado con exito");
     } catch (Exception e) {
         
         em.getTransaction().rollback();
                
        }
    
    
    
    
    
    
    
    
    
    
    
    }
    

}
 