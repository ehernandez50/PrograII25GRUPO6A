/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Servicios;

import com.mycompany.people.com.Models.Cliente;
import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Costo;
import com.mycompany.people.com.Models.NivelAcademico;
import com.mycompany.people.com.Models.OfertaEmpleo;
import com.mycompany.people.com.Models.Usuario;
import com.mycompany.people.com.Models.Vacante;

import com.mycompany.people.com.Repository.ClienteJpaController;
import com.mycompany.people.com.Repository.CodigoPostalJpaController;
import com.mycompany.people.com.Repository.OfertaEmpleoJpaController;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class ServiciosCliente {
    
    
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf;
    ClienteJpaController clienteController;
    Cliente cliente;
    Usuario id;
    
    

    public ServiciosCliente(EntityManagerFactory emf, Usuario id) throws InterruptedException {
        this.emf = emf; 
        this.id = id;
        
         clienteController= new ClienteJpaController(emf);
      this.cliente =   clienteController.buscarCliente(id);
 }
    
     public void AppCliente() throws InterruptedException{
          
    while(true){
   System.out.println("\n========= PANEL DE CLIENTE =========");
            System.out.println("1. Ver perfil");
            System.out.println("2. Editar perfil");
            
            System.out.println("3. Publicar vacante");
            System.out.println("4. Ver vacantes publicadas");
            System.out.println("5. Eliminar Vacante");
            System.out.println("6 Salir");
            System.out.print("Seleccione una opción: ");
            
            if (sc.hasNextInt()) {
            int opcion = sc.nextInt();
            sc.nextLine();
                switch (opcion) {
                    case 1:
                        VerPerfilCliente();
                        break;
                        case 2:
                            ModificarPerfil();
                        
                        break;
                        case 3:
                            Oferta();
                        
                        break;
                        case 4:
                            verOf();
                        
                        break;
                        case 5:
                            EliminarVacante();
                        
                        return;
                        case 6:
                            return;
                        
                        
                    default:
                        throw new AssertionError();
                }
        }
            else{
                System.out.println("Ingrese un opcion correcta");
            }
            

        
    }
    
    }
    
    
    
    
    
   
    
 
 
  public void ModificarPerfil(){
  
boolean salir = false;
while (!salir) {
    System.out.println("=====================================");
    System.out.println("Seleccione el campo que desea modificar:");
    System.out.println("1. Empresa");
    System.out.println("2. Contacto");
    System.out.println("3. Correo");
    System.out.println("4. NIT");
    System.out.println("5. Teléfono");
    System.out.println("6. Codigo Postal");
    System.out.println("7. Salir");
    System.out.println("=====================================");

    int opcion = sc.nextInt();
    sc.nextLine();

    switch (opcion) {
        case 1:
            System.out.print("Ingrese nuevo Nombre de la Empresa: ");
            
            String nombre = sc.nextLine();
            cliente.setEmpresa(nombre);
            break;
        case 2:
            System.out.print("Ingrese nuevo Nombre contacto: ");
            String contacto = sc.nextLine();
            cliente.setNombreContacto(contacto);
            break;
        case 3:
            System.out.print("Ingrese nuevo correo: ");
            String correo = sc.next();
            sc.nextLine();
            cliente.setCorreo(correo);
            break;
        case 4:
            System.out.print("Ingrese nuevo NIT: ");
            
            if (sc.hasNextInt()) {
            Integer nit = sc.nextInt();
            sc.nextLine();
            cliente.setNit(nit);
            }
            else{
                System.out.println("Ingrese un dato valido");
            }
            
            break;
        case 5:
            System.out.print("Ingrese nuevo Teléfono: ");
            
            if (sc.hasNextInt()) {
            Integer tel = sc.nextInt();
            sc.nextLine();
            cliente.setTelefono(tel);
            }
            else{
            
                System.out.println("INgrese una opcion valida");
            }
            
            break;
        
        
        case 6:
            System.out.print("Ingrese nuevo Código Postal: ");
            int codPostal = sc.nextInt();
            sc.nextLine();
            
            EntityManager em = emf.createEntityManager();
           CodigoPostal cod = em.createNamedQuery("CodigoPostal.findByCodigo", CodigoPostal.class)
                    .setParameter("codigo", codPostal)
                    .getSingleResult();
           
            if (cod != null) {
                cliente.setCodPostal(cod);
            } else {
                System.out.println("Código postal no encontrado.");
            }
            break;
        case 7:
            salir = true;
            break;
        default:
            System.out.println("Opción no válida");
    }

    if (!salir) {
        
        clienteController.actualizarCliente(cliente);
        System.out.println("Campo actualizado correctamente.\n");
    }
  
    
  } }





  public void VerPerfilCliente(){
  
      
      
    
    
      System.out.println("================================="); 
     System.out.println("Empresa: "+cliente.getEmpresa());
      System.out.println("Correo: "+ cliente.getCorreo());
      System.out.println("Nombre Contacto: "+ cliente.getNombreContacto());
      System.out.println("Puesto Contacto; "+cliente.getPuestoContacto());
      System.out.println("Municipio: "+cliente.getCodPostal().getMunicipioId().getNombre());
      System.out.println("Departamento: "+ cliente.getCodPostal().getMunicipioId().getDepartamentoId().getNombre());
      System.out.println("COdigo Postal: "+ cliente.getCodPostal().getCodigo());
      System.out.println("=================================");
      
      
  
  
  }

  
  public void Oferta() throws InterruptedException{
      OfertaEmpleoJpaController of = new OfertaEmpleoJpaController(emf);
      
      System.out.println("Puesto: ");
      String puesto = sc.nextLine();
      
      System.out.println("Cuantos Anos de experiencia: ");
      int experiencia = sc.nextInt();
      sc.nextLine();
      
      
      System.out.println("Ingrese la edad: ");
      int edad = sc.nextInt();
      sc.nextLine();
      
      System.out.println("Seleccione el nivel Academico: ");
      NivelAcademico nivel =of.ElegirNivel();
      
     
      System.out.println("Descricion");
      String descripcion = sc.nextLine();
      
      System.out.println("Ingrese el salrio:");
      Integer salario = sc.nextInt();
      sc.nextLine();
      
      System.out.println("ingrese el codigo Postal de la oferta:");
      int postal;
    CodigoPostal codigoPostal = new CodigoPostal();
    CodigoPostalJpaController c = new CodigoPostalJpaController(emf);
    while (true) {
        System.out.print("Código Postal: ");
        if (sc.hasNextInt()) {
            postal = sc.nextInt();
            Thread.sleep(1000);
            CodigoPostal cod = c.buscar(postal);
            
            if (cod!= null) {
                codigoPostal = cod;
                sc.nextLine();
                break;
                
            }
            else{
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
            
            }
 
            
        } else {
            System.out.println("⚠️ Debe ingresar un número válido.");
            sc.nextLine();
        }
    }

    
     System.out.println("Costos: ");
     Costo co= of.buscarCosto();
 
 
 Vacante vacanteId = of.CrearVacante(experiencia, edad, nivel, puesto, descripcion, salario, codigoPostal);
 of.CrearOferta(cliente, vacanteId, co);
      
      
      
      
      
      
      
      
  
  
  }
     
     public void verOf(){
     
     OfertaEmpleoJpaController of = new OfertaEmpleoJpaController(emf);
     of.VerOfertas(cliente);
     }
    
  public void EliminarVacante(){
  EntityManager em = emf.createEntityManager();
  verOf();
  
      System.out.println("ingrese el cod de vacante: ");
      
      Long v = sc.nextLong();
      
      
      try { 
          em.getTransaction().begin();
          
          em.createNamedQuery("OfertaEmpleo.borrar")
          .setParameter("id", v)
          .executeUpdate();
          
          em.getTransaction().commit();
          
      sc.nextLine();
          
          System.out.println("Se elimino la Oferta laboral");
          
      } catch (Exception e) {
          System.out.println(e);
      }
  
  
  
  
  
  
  
  
  }
  
    
}
