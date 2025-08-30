/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Repository;

import com.mycompany.people.com.Models.Postulante;
import com.mycompany.people.com.Models.Vacante;
import java.util.ArrayList;
import java.util.List;
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

}
 