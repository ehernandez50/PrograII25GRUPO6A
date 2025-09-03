/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Educacion;
import com.mycompany.people.com.Models.EducacionDetalle;
import com.mycompany.people.com.Models.Experiencia;
import com.mycompany.people.com.Models.ExperienciaDetalle;
import com.mycompany.people.com.Models.Genero;
import com.mycompany.people.com.Models.NivelAcademico;
import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Usuario;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;


public class PostulanteJpaController {
    
   EntityManagerFactory emf;
   Scanner sc = new Scanner(System.in);
   
   public PostulanteJpaController(EntityManagerFactory emf){
   this.emf=emf;
   
   }
   
   
   
  
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
   public List<ExperienciaDetalle> BuscarExperienciaDetalle(Postulante postulante){
        EntityManager em =emf.createEntityManager();
        
        Experiencia ex =  em.createNamedQuery("Experiencia.buscarExperiencia", Experiencia.class)
                .setParameter("postulante", postulante)
                .getSingleResult();
        
        
        List<ExperienciaDetalle> exd = em.createNamedQuery("ExperienciaDetalle.BuscarDetalle", ExperienciaDetalle.class)
                .setParameter("experiencia", ex)
                .getResultList();
        
       
       
    return exd;
    }
   public ExperienciaDetalle experienciaDetalle(Long id){
   EntityManager em = emf.createEntityManager();
   
   
   ExperienciaDetalle e= em.createNamedQuery("ExperienciaDetalle.findByExperienciaDetalleId",ExperienciaDetalle.class)
           .setParameter("experienciaDetalleId", id)
           .getSingleResult();
   
   
   return  e;
   }
   public Experiencia BuscarExperiencia(Postulante postulante){
   
    EntityManager em =emf.createEntityManager();
        
        Experiencia ex =  em.createNamedQuery("Experiencia.buscarExperiencia", Experiencia.class)
                .setParameter("postulante", postulante)
                .getSingleResult();
        
       return ex;
   
   
   }
   public Educacion buscarEducacion(Postulante postulante){
    EntityManager em =emf.createEntityManager();
        
        Educacion ed =  em.createNamedQuery("Educacion.buscar", Educacion.class)
                .setParameter("postulante", postulante)
                .getSingleResult();
   return ed;
   }
   public EducacionDetalle BuscarEducacionD(Long id) {
    EntityManager em =emf.createEntityManager();
        
        EducacionDetalle ed =  em.createNamedQuery("EducacionDetalle.findByEducacionDetalleId", EducacionDetalle.class)
                .setParameter("educacionDetalleId", id)
                .getSingleResult();
        return ed;
   }
   public List<EducacionDetalle> BuscarEducacionDetalle(Postulante postulante){
        EntityManager em =emf.createEntityManager();
        
        Educacion ed =  em.createNamedQuery("Educacion.buscar", Educacion.class)
                .setParameter("postulante", postulante)
                .getSingleResult();
        
        
        List<EducacionDetalle> exd = em.createNamedQuery("EducacionDetalle.Buscardetalle", EducacionDetalle.class)
                .setParameter("educacion", ed)
                .getResultList();
        
       
       
    return exd;
  
  
  
  
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
   public void ActulizarExperienciaDetalle(ExperienciaDetalle e){
    
      EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(e); 
        em.getTransaction().commit();
    } finally {
        em.close();
    }
    }
   public void ActualizrEducacionDetalle(EducacionDetalle ed){
   
     EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(ed); 
        em.getTransaction().commit();
    } finally {
        em.close();
    }
   }
   public void ActualizarEducacion(Educacion ed){
   
     EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(ed); 
        em.getTransaction().commit();
    } finally {
        em.close();
    }
   
   }
   
   
   
   
   
   public void RegistrarPOstulante(String nombre,String Apellido,int dpi,int nit,int telefono,int teladicional,String nacionalidad, Usuario usuarioId, Genero generoId, CodigoPostal codPostalId){
        EntityManager em =emf.createEntityManager();
           Postulante p = new Postulante();
        try {
            
       
    
 
    
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
        
    
    FormExperiencia(p);
    FormEducacion(p);
    
    
    
    
    
    
    
    
    
    
    }
   public Experiencia RegistrarExperiencia(int total, Postulante postulante){
    EntityManager em = emf.createEntityManager();
     Experiencia ex  = new Experiencia();
    ex.setExperienciaTotal(total);
    ex.setPostulanteId(postulante);
        try {
            
        
    em.getTransaction().begin();
    em.persist(ex);
    em.getTransaction().commit();
    
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
        return ex;
    }
   public void RegistroExperienciaDetallePostulante(Experiencia experienciaId,String empresa,String cargo,String funcion,Date fechaInicio,Date fechaFin){
    
    ExperienciaDetalle ed= new ExperienciaDetalle();
    
    EntityManager em = emf.createEntityManager();
   
        
        ed.setExperienciaId(experienciaId);
        ed.setEmpresa(empresa);
        ed.setCargo(cargo);
        ed.setFuncion(funcion);
        ed.setFechaInicio(fechaInicio);
        ed.setFechaFin(fechaFin);
        
        try {
            em.getTransaction().begin();
            em.persist(ed);
            em.getTransaction().commit();
        
       
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        
        
    }
   public Educacion RegistroEducacion(NivelAcademico nivelAcademicoId,Postulante postulanteId){
        EntityManager em = emf.createEntityManager();
        Educacion ed = new Educacion();
        ed.setNivelAcademicoId(nivelAcademicoId);
        ed.setPostulanteId(postulanteId);
        
        
        try {
            
      
        em.getTransaction().begin();
        em.persist(ed);
        em.getTransaction().commit();
        
          } catch (Exception e) {
        }
        return ed;
        
    }
   public void RegistroEducacionDetalle(Educacion ed,String centroEducativo,String titulo,String nivelEstudio,Date fechaInicio,Date fechaFin){
        
        EntityManager em = emf.createEntityManager();
        
        EducacionDetalle edud= new EducacionDetalle();
        
        edud.setEducacionId(ed);
        edud.setCentroEducativo(centroEducativo);
        edud.setTitulo(titulo);
        edud.setNivelEstudio(nivelEstudio);
        edud.setFechaInicio(fechaInicio);
        edud.setFechaFin(fechaFin);
        
        try {
            em.getTransaction().begin();
            em.persist(edud);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
        
        
        
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
    usuarioController.CrearUsuario(user, pass, correo, rolCliente);
    
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
   public void FormExperiencia(Postulante postulante){
    System.out.println("Experiencia==========================");
    int total = leerEntero("Ingrese anos de experiencia: ");
    Experiencia ex = RegistrarExperiencia(total, postulante);
    FormExperienciaDetalle(ex);
    
    }
   public void FormExperienciaDetalle(Experiencia experiencia){
            
        
        while (true) {                        
        String empresa = leerTexto("Ingrese el nombre de la empresa: ");
        String cargo = leerTexto("Ingrese el cargo: ");
        String funcion = leerTexto("Ingrese la función: ");
        Date fechaInicio = leerFecha("Ingrese la fecha de inicio (dd/MM/yyyy): ");
        Date fechaFin = leerFecha("Ingrese la fecha de fin (dd/MM/yyyy): ");
        
        RegistroExperienciaDetallePostulante(experiencia,empresa, cargo, funcion, fechaInicio, fechaFin);
        
            System.out.println("1. Ingresar otra experiencia"
                    + "2. salir");
            if (sc.hasNextInt()) {
                  int opcion = sc.nextInt();
                 
                if (opcion==2) {
                    return;
                }
                if (opcion==1) {
                    
                    continue;
                    
                }
                else{
                
                }
               
            }
            else{
            
            
            }
           
            
        }

}
   public void FormEducacion(Postulante postulante){
      System.out.println(" Educacion===============================");
        OfertaEmpleoJpaController of = new OfertaEmpleoJpaController(emf);
         System.out.println("Ingrese su nivel de Estudio Actual: ");
         NivelAcademico nivelAcademicoId = of.ElegirNivel();
         sc.nextLine();
      Educacion ed=   RegistroEducacion(nivelAcademicoId, postulante);
      
        FormEducacionDetalle(ed);
      
    }
   public void FormEducacionDetalle(Educacion ed){
     while (true) {            
            
       
        String colegio = leerTexto("Ingrese el nombre del centro educativo: ");
        String titulo = leerTexto("Ingrese el Titulo Obtenido: ");
        String nivel = leerTexto("Nivel de estudios: ");
        Date fechaInicio = leerFecha("Ingrese la fecha de inicio (dd/MM/yyyy): ");
        Date fechaFin = leerFecha("Ingrese la fecha de fin (dd/MM/yyyy): ");
        
         RegistroEducacionDetalle(ed,colegio, titulo, nivel, fechaInicio, fechaFin);
        
            System.out.println("1. Ingresar otra experiencia"
                    + "2. salir");
            if (sc.hasNextInt()) {
                  int opcion = sc.nextInt();
                  
                if (opcion==2) {
                    return;
                }
                if (opcion==1) {

                    continue;
                    
                }
                else{
                
                }
               
            }
            else{
            
            
            }
    
    }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private  int leerEntero(String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: debe ingresar un número entero.");
            }
        }
    }

    private  String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("❌ Error: el texto no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private  Postulante leerPostulante(String mensaje) {
        String nombre;
        do {
            System.out.print(mensaje);
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("❌ Error: el nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return new Postulante();
    }

    public  Date leerFecha(String mensaje) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // para validar fechas reales
        Date fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                fecha = sdf.parse(entrada);
            } catch (ParseException e) {
                System.out.println("❌ Error: formato inválido. Use dd/MM/yyyy");
            }
        }
        return fecha;
    }
}
 