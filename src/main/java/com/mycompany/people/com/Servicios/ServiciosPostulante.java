/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Servicios;


import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Vacante;
import com.mycompany.people.com.Repository.PostulanteJpaController;
import java.math.BigInteger;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ServiciosPostulante {
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
    Long UsuarioID;
    PostulanteJpaController perfil = new PostulanteJpaController(emf);
    public ServiciosPostulante(Long UsuarioID){
    this.UsuarioID =UsuarioID;
    }
    
    public void PostulanteApp(){
    
        while (true) {            
    try {
        System.out.println("Opciones");
        System.out.println("1. Ver Perfil");
        System.out.println("2. Modificar Perfil");
        System.out.println("3. Buscar Vacantes");
        System.out.println("5. exit");

        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                Perfil();
                break;
            case 2:
                ModificarPerfil();
                break;
            case 3:
                buscarVacantes();
                break;
            case 5:
                return; // sale del menú
            default:
                System.out.println("Ingrese una opción válida");
                break;
        }
    } catch (Exception e) {
        System.out.println("No válida");
        sc.nextLine(); // limpia buffer para que no se repita error infinito
    } 
}

    
    }
    
    public void Perfil(){
        
        
      Postulante perfil7=  perfil.VerPerfil(UsuarioID);
        
        
    if (perfil7 != null) {
System.out.println("==================================================");
System.out.printf("| %-20s | %-25s |\n", "Campo", "Valor");
System.out.println("==================================================");
System.out.printf("| %-20s | %-25s |\n", "Nombre", perfil7.getNombre());
System.out.printf("| %-20s | %-25s |\n", "Apellido", perfil7.getApellido());
System.out.printf("| %-20s | %-25s |\n", "DPI", perfil7.getDpi());
System.out.printf("| %-20s | %-25s |\n", "NIT", perfil7.getNit());
System.out.printf("| %-20s | %-25s |\n", "Género", perfil7.getGeneroId().getNombre());
System.out.printf("| %-20s | %-25s |\n", "Teléfono", perfil7.getTelefono());
System.out.printf("| %-20s | %-25s |\n", "Teléfono Adicional", perfil7.getTelefonoAdicional());
System.out.printf("| %-20s | %-25s |\n", "Nacionalidad", perfil7.getNacionalidad());
System.out.printf("| %-20s | %-25s |\n", "Código Postal", perfil7.getCodPostalId().getCodigo());
System.out.printf("| %-20s | %-25s |\n", "Residencia", perfil7.getCodPostalId().getMunicipioId().getNombre());
System.out.println("==================================================");

} else {
    System.out.println("No se encontró el perfil del postulante.");
}
    
    
    
    }
    
    
    
    public void ModificarPerfil(){
    
    
   Postulante postulante= perfil.BuscarPerfil(UsuarioID);
   if (postulante == null) {
    System.out.println("No se encontró el perfil.");
    return;
}

boolean salir = false;
while (!salir) {
    System.out.println("=====================================");
    System.out.println("Seleccione el campo que desea modificar:");
    System.out.println("1. Nombre");
    System.out.println("2. Apellido");
    System.out.println("3. DPI");
    System.out.println("4. NIT");
    System.out.println("5. Teléfono");
    System.out.println("6. Teléfono Adicional");
    System.out.println("7. Nacionalidad");
    System.out.println("8. Código Postal");
    System.out.println("9. Salir");
    System.out.println("=====================================");

    int opcion = sc.nextInt();
    sc.nextLine(); // limpiar buffer

    switch (opcion) {
        case 1:
            System.out.print("Ingrese nuevo Nombre: ");
            String nombre = sc.nextLine();
            postulante.setNombre(nombre);
            break;
        case 2:
            System.out.print("Ingrese nuevo Apellido: ");
            String apellido = sc.nextLine();
            postulante.setApellido(apellido);
            break;
        case 3:
            System.out.print("Ingrese nuevo DPI: ");
            Integer dpi = sc.nextInt();
            sc.nextLine();
            postulante.setDpi(dpi);
            break;
        case 4:
            System.out.print("Ingrese nuevo NIT: ");
            Integer nit = sc.nextInt();
            sc.nextLine();
            postulante.setNit(nit);
            break;
        case 5:
            System.out.print("Ingrese nuevo Teléfono: ");
            Integer tel = sc.nextInt();
            sc.nextLine();
            postulante.setTelefono(tel);
            break;
        case 6:
            System.out.print("Ingrese nuevo Teléfono Adicional: ");
            Integer telAd = sc.nextInt();
            sc.nextLine();
            postulante.setTelefonoAdicional(telAd);
            break;
        case 7:
            System.out.print("Ingrese nueva Nacionalidad: ");
            String nac = sc.nextLine();
            postulante.setNacionalidad(nac);
            break;
        case 8:
            System.out.print("Ingrese nuevo Código Postal: ");
            int codPostal = sc.nextInt();
            sc.nextLine();
            
            EntityManager em = emf.createEntityManager();
           CodigoPostal cod = em.createNamedQuery("CodigoPostal.findByCodigo", CodigoPostal.class)
                    .setParameter("codigo", codPostal)
                    .getSingleResult();
           
            if (cod != null) {
                postulante.setCodPostalId(cod);
            } else {
                System.out.println("Código postal no encontrado.");
            }
            break;
        case 9:
            salir = true;
            break;
        default:
            System.out.println("Opción no válida");
    }

    if (!salir) {
        
        perfil.actualizarPostulante(postulante);
        System.out.println("Campo actualizado correctamente.\n");
    }

    
    
    
    
    
    
    
    }}
    
    
    public void buscarVacantes(){
    
    perfil.buscarVacantes();
    
    
    }
    
    
    
    
    
    
}
