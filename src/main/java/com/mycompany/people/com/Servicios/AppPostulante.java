/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Servicios;


import com.mycompany.people.com.Models.CodigoPostal;
import com.mycompany.people.com.Models.Educacion;
import com.mycompany.people.com.Models.EducacionDetalle;
import com.mycompany.people.com.Models.Experiencia;
import com.mycompany.people.com.Models.ExperienciaDetalle;
import com.mycompany.people.com.Models.NivelAcademico;
import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Vacante;
import com.mycompany.people.com.Repository.OfertaEmpleoJpaController;
import com.mycompany.people.com.Repository.PostulanteJpaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppPostulante {
    
    
    Scanner sc = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_People.com_jar_1.0-SNAPSHOTPU");
    Long UsuarioID;
    PostulanteJpaController postulanteController = new PostulanteJpaController(emf);
    Postulante pos;
    Educacion educacion;
    
    
    
    public AppPostulante(Long UsuarioID){
    this.UsuarioID =UsuarioID;
    this.pos=postulanteController.BuscarPerfil(UsuarioID);
    this.educacion=postulanteController.buscarEducacion(pos);
    }
    
    
    
    public void PostulanteApp(){
    
        while (true) {            
    try {
        System.out.println("===================PANEL POSTULANTE====================");
        System.out.println("Opciones");
        System.out.println("1. Ver Perfil");
        System.out.println("2. Modificar Perfil");
        System.out.println("6. modificar Experiencia");
        System.out.println("3. Buscar Vacantes");
        System.out.println("5. exit");
        System.out.println("7. Actualizar Educacion");
        System.out.println("8. Agregar experiencia");
        System.out.println("9. agregar Educacion");
        System.out.println("10. Actualizar Nivel Actual de Estudio");

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
                case 6:
                ModificarExperienia();
                break;
                case 7:
                ModificarEducacionDetalle();
                break;
                case 8:
                    AgregarExperiencia();
                
                break;
                case 9:
                agregarEducacion();
                break;
                case 10:
                    ModificarEducacion();
                
                break;
            default:
                System.out.println("Ingrese una opción válida");
                break;
        }
    } catch (Exception e) {
        System.out.println("opcion no valida");
        System.out.println(e);
        sc.nextLine(); 
    } 
}

    
    }
    public void Perfil(){
        
        
Postulante perfil=  postulanteController.VerPerfil(UsuarioID);
List<ExperienciaDetalle>experiencias = postulanteController.BuscarExperienciaDetalle(perfil);
List<EducacionDetalle> d = postulanteController.BuscarEducacionDetalle(perfil);
this.educacion=postulanteController.buscarEducacion(pos);
    if (perfil != null) {
System.out.println("==================================================");
System.out.printf("| %-20s | %-25s |\n", "Campo", "Valor");
System.out.println("==================================================");
System.out.printf("| %-20s | %-25s |\n", "Nombre", perfil.getNombre());
System.out.printf("| %-20s | %-25s |\n", "Apellido", perfil.getApellido());
System.out.printf("| %-20s | %-25s |\n", "DPI", perfil.getDpi());
System.out.printf("| %-20s | %-25s |\n", "NIT", perfil.getNit());
System.out.printf("| %-20s | %-25s |\n", "Género", perfil.getGeneroId().getNombre());
System.out.printf("| %-20s | %-25s |\n", "Teléfono", perfil.getTelefono());
System.out.printf("| %-20s | %-25s |\n", "Teléfono Adicional", perfil.getTelefonoAdicional());
System.out.printf("| %-20s | %-25s |\n", "Nacionalidad", perfil.getNacionalidad());
System.out.printf("| %-20s | %-25s |\n", "Código Postal", perfil.getCodPostalId().getCodigo());
System.out.printf("| %-20s | %-25s |\n", "Residencia", perfil.getCodPostalId().getMunicipioId().getNombre());
  System.out.printf("| %-20s | %-25s |\n", "Nivel Actual Estudios: ",educacion.getNivelAcademicoId().getNombre());
System.out.println("==================================================");

        for (ExperienciaDetalle experiencia : experiencias) {
            ExperienciaDetalle e = experiencia;
            System.out.println(e.getEmpresa());
            System.out.println(e.getCargo());            
        }

        for (EducacionDetalle educacionDetalle : d) {
            EducacionDetalle d2 = educacionDetalle;
            System.out.println(d2.getCentroEducativo());
            System.out.println(d2.getTitulo());
        }


} else {
    System.out.println("No se encontró el perfil del postulante.");
}
    
    
    
    }
    public void ModificarPerfil(){
   Postulante postulante= postulanteController.BuscarPerfil(UsuarioID);
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
        
        postulanteController.actualizarPostulante(postulante);
        System.out.println("Campo actualizado correctamente.\n");
    }

    
    
    
    
    
    
    
    }}
    public void ModificarExperienia(){ 
    Postulante perfil7=  postulanteController.VerPerfil(UsuarioID);
    List<ExperienciaDetalle>experiencias = postulanteController.BuscarExperienciaDetalle(perfil7);
    Experiencia experiencia = postulanteController.BuscarExperiencia(perfil7);
    
    
     for (ExperienciaDetalle experienciaIndex : experiencias) {
         System.out.println("==========================================");
            ExperienciaDetalle e = experienciaIndex;
            
            System.out.println(String.valueOf( e.getExperienciaDetalleId()));
            
            System.out.println(e.getEmpresa());
            System.out.println(e.getCargo());    
            System.out.println(e.getFuncion());
            System.out.println(e.getFechaInicio());
            System.out.println(e.getFechaFin());
            System.out.println("==========================================");
            
        }
     
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print("Ingrese el ID de la experiencia a modificar (0 para salir): ");
            if (sc.hasNextLong()) {
                long idExperiencia = sc.nextLong();
                sc.nextLine(); 

                if (idExperiencia == 0) {
                    System.out.println("Saliendo del programa...");
                    break;
                }
                
                    
                
                  ExperienciaDetalle e = postulanteController.experienciaDetalle(idExperiencia);
                
                String empresa = "";
                String cargo = "";
                String funcion = "";
                Date fechaInicio = null;
                Date fechaFin = null;

                
                while (true) {
                    System.out.println("\n--- Formulario ---");
                    System.out.println("1. Empresa");
                    System.out.println("2. Cargo");
                    System.out.println("3. Función");
                    System.out.println("4. Fecha Inicio");
                    System.out.println("5. Fecha Fin");
                    System.out.println("0. Volver al menú de ID");
                    System.out.print("Seleccione el dato a modificar: ");

                    if (sc.hasNextInt()) {
                        int opcion = sc.nextInt();
                        
                        
                        if (opcion>=0&&opcion<=5) {
                            
                        
                        sc.nextLine(); 

                        switch (opcion) {
                            case 1:
                                System.out.print("Ingrese el nombre de la empresa: ");
                                empresa = sc.nextLine();
                                e.setEmpresa(empresa);
                                System.out.println("Empresa actualizada a: " + empresa);
                                break;
                            case 2:
                                System.out.print("Ingrese el cargo: ");
                                cargo = sc.nextLine();
                                e.setCargo(cargo);
                                System.out.println("Cargo actualizado a: " + cargo);
                                break;
                            case 3:
                                System.out.print("Ingrese la función: ");
                                funcion = sc.nextLine();
                                e.setFuncion(funcion);
                                System.out.println("Función actualizada a: " + funcion);
                                break;
                            case 4:
                                System.out.println("Ingrese fecha nueva dd/mm/aa/");
                                String fechaInicio1= sc.next();
                                fechaInicio = postulanteController.leerFecha(funcion);
                                System.out.println("Fecha Inicio actualizada a: " + fechaInicio);
                                e.setFechaInicio(fechaInicio);
                                break;
                            case 5:
                                System.out.println("Ingrese fecha nueva dd/mm/aa/");
                                String fecha = sc.next();
                                fechaFin = postulanteController.leerFecha(fecha);
                                System.out.println("Fecha Fin actualizada a: " + fechaFin);
                                e.setFechaFin(fechaFin);
                                break;
                            case 0:
                                System.out.println("Volviendo al menú de ID...");
                                break;
                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }

                        if (opcion == 0) {
                            break; 
                        }

                    }
                        
                        
                        else {
                        System.out.println("Entrada no válida. Debe ingresar un número.");
                        sc.nextLine();
                    }
                        
                       postulanteController.ActulizarExperienciaDetalle(e);
                        
                        
                        
                        
                        
                    }
                }

            } else {
                System.out.println("Entrada no válida. Debe ingresar un número de ID.");
                sc.nextLine(); // Limpiar entrada incorrecta
            
                  
                
                
            }//if <.
                
        }

            
        
       
        
        
        
        
        
        
    }
    public void ModificarEducacionDetalle(){
    
       Postulante p = postulanteController.VerPerfil(UsuarioID);
       List<EducacionDetalle>educaciones = postulanteController.BuscarEducacionDetalle(p);
       
       
       
       
           System.out.println("\n=== Registros de Educación ===");
        for (EducacionDetalle e : educaciones) {
            
           System.out.println(e.getEducacionDetalleId()+"-"+e.getCentroEducativo() + " - " + e.getTitulo());  
        }
           
        

        System.out.print("\nSeleccione el número del registro a modificar: ");
        Long opcion = sc.nextLong();
        sc.nextLine(); 

      

        EducacionDetalle seleccionado =postulanteController.BuscarEducacionD(opcion);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Modificar Registro ===");
            System.out.println("1. Centro Educativo (Actual: " + seleccionado.getCentroEducativo() + ")");
            System.out.println("2. Fecha Inicio (Actual: " + seleccionado.getFechaInicio() + ")");
            System.out.println("3. Fecha Fin (Actual: " + seleccionado.getFechaFin() + ")");
            System.out.println("4. Título (Actual: " + seleccionado.getTitulo() + ")");
            System.out.println("5. Nivel de Estudios (Actual: " + seleccionado.getNivelEstudio() + ")");
            System.out.println("0. Guardar y salir");
            System.out.print("Seleccione el campo a modificar: ");

            int campo = sc.nextInt();
            sc.nextLine();

            switch (campo) {
                case 1:
                    System.out.print("Ingrese el nuevo Centro Educativo: ");
                    seleccionado.setCentroEducativo(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Ingrese fecha nueva dd/mm/aa/");
                                String fechaInicio1= sc.next();
                              Date  fechaInicio = postulanteController.leerFecha(fechaInicio1);
                                System.out.println("Fecha Inicio actualizada a: " + fechaInicio);
                                seleccionado.setFechaInicio(fechaInicio);
                    break;
                case 3:
                    System.out.println("Ingrese fecha nueva dd/mm/aa/");
                                String fechafin= sc.next();
                              Date  fecha = postulanteController.leerFecha(fechafin);
                                System.out.println("Fecha Inicio actualizada a: " + fecha);
                                seleccionado.setFechaFin(fecha);
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo Título: ");
                    seleccionado.setTitulo(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Ingrese el nuevo Nivel de Estudios: ");
                    seleccionado.setNivelEstudio(sc.nextLine());
                    break;
                case 0:
                    continuar = false;
                    System.out.println("✅ Cambios guardados en el registro.");
                    break;
                default:
                    System.out.println("⚠ Opción inválida.");
            }
            postulanteController.ActualizrEducacionDetalle(seleccionado);
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
    public void AgregarExperiencia(){
    
        Experiencia e =postulanteController.BuscarExperiencia(pos);
        postulanteController.FormExperienciaDetalle(e);
    
   }
    public void  agregarEducacion(){
    Educacion ed= postulanteController.buscarEducacion(pos);
    postulanteController.FormEducacionDetalle(ed);
    
    }
    
    public void ModificarEducacion(){
        Educacion ed = postulanteController.buscarEducacion(pos);
        
         System.out.println(" Educacion===============================");
        OfertaEmpleoJpaController of = new OfertaEmpleoJpaController(emf);
         System.out.println("Ingrese su nivel de Estudio Actual: ");
         NivelAcademico nivelAcademicoId = of.ElegirNivel();
         ed.setNivelAcademicoId(nivelAcademicoId);
         
         sc.nextLine();
         postulanteController.ActualizarEducacion(ed);
    
    
    
    }
    
    
    
    
       
}
