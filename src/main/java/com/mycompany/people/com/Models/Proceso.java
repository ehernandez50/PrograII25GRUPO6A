/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "proceso")
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p"),
    @NamedQuery(name = "Proceso.findByProcesoId", query = "SELECT p FROM Proceso p WHERE p.procesoId = :procesoId")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proceso_id")
    private Long procesoId;
    @JoinColumn(name = "fase_id", referencedColumnName = "fase_id")
    @ManyToOne
    private Fase faseId;
    @JoinColumn(name = "postulante_id", referencedColumnName = "postulante_id")
    @ManyToOne
    private Postulante postulanteId;
    @JoinColumn(name = "vacante_id", referencedColumnName = "vacante_id")
    @ManyToOne
    private Vacante vacanteId;

    public Proceso() {
    }

    public Proceso(Long procesoId) {
        this.procesoId = procesoId;
    }

    public Long getProcesoId() {
        return procesoId;
    }

    public void setProcesoId(Long procesoId) {
        this.procesoId = procesoId;
    }

    public Fase getFaseId() {
        return faseId;
    }

    public void setFaseId(Fase faseId) {
        this.faseId = faseId;
    }

    public Postulante getPostulanteId() {
        return postulanteId;
    }

    public void setPostulanteId(Postulante postulanteId) {
        this.postulanteId = postulanteId;
    }

    public Vacante getVacanteId() {
        return vacanteId;
    }

    public void setVacanteId(Vacante vacanteId) {
        this.vacanteId = vacanteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoId != null ? procesoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.procesoId == null && other.procesoId != null) || (this.procesoId != null && !this.procesoId.equals(other.procesoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Proceso[ procesoId=" + procesoId + " ]";
    }
    
}
