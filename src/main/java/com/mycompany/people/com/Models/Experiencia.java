/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Models;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "experiencia")
@NamedQueries({
    @NamedQuery(name ="Experiencia.buscarExperiencia", query="SELECT e FROM Experiencia e WHERE e.postulanteId=:postulante"),
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e"),
    @NamedQuery(name = "Experiencia.findByExperienciaId", query = "SELECT e FROM Experiencia e WHERE e.experienciaId = :experienciaId"),
    @NamedQuery(name = "Experiencia.findByExperienciaTotal", query = "SELECT e FROM Experiencia e WHERE e.experienciaTotal = :experienciaTotal")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "experiencia_id")
    private Integer experienciaId;
    @Column(name = "experiencia_total")
    private Integer experienciaTotal;
    @JoinColumn(name = "postulante_id", referencedColumnName = "postulante_id")
    @ManyToOne
    private Postulante postulanteId;
    @OneToMany(mappedBy = "experienciaId")
    private List<ExperienciaDetalle> experienciaDetalleList;

    public Experiencia() {
    }

    public Experiencia(Integer experienciaId) {
        this.experienciaId = experienciaId;
    }

    public Integer getExperienciaId() {
        return experienciaId;
    }

    public void setExperienciaId(Integer experienciaId) {
        this.experienciaId = experienciaId;
    }

    public Integer getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(Integer experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    public Postulante getPostulanteId() {
        return postulanteId;
    }

    public void setPostulanteId(Postulante postulanteId) {
        this.postulanteId = postulanteId;
    }

    public List<ExperienciaDetalle> getExperienciaDetalleList() {
        return experienciaDetalleList;
    }

    public void setExperienciaDetalleList(List<ExperienciaDetalle> experienciaDetalleList) {
        this.experienciaDetalleList = experienciaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experienciaId != null ? experienciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.experienciaId == null && other.experienciaId != null) || (this.experienciaId != null && !this.experienciaId.equals(other.experienciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Experiencia[ experienciaId=" + experienciaId + " ]";
    }
    
}
