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
@Table(name = "educacion")
@NamedQueries({
    @NamedQuery(name = "Educacion.buscar", query ="SELECT d FROM Educacion d WHERE d.postulanteId=:postulante"),
    @NamedQuery(name = "Educacion.findAll", query = "SELECT e FROM Educacion e"),
    @NamedQuery(name = "Educacion.findByEducacionId", query = "SELECT e FROM Educacion e WHERE e.educacionId = :educacionId")})
public class Educacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "educacion_id")
    private Integer educacionId;
    @OneToMany(mappedBy = "educacionId")
    private List<EducacionDetalle> educacionDetalleList;
    @JoinColumn(name = "nivel_academico_id", referencedColumnName = "nivel_academico_id")
    @ManyToOne
    private NivelAcademico nivelAcademicoId;
    @JoinColumn(name = "postulante_id", referencedColumnName = "postulante_id")
    @ManyToOne
    private Postulante postulanteId;

    public Educacion() {
    }

    public Educacion(Integer educacionId) {
        this.educacionId = educacionId;
    }

    public Integer getEducacionId() {
        return educacionId;
    }

    public void setEducacionId(Integer educacionId) {
        this.educacionId = educacionId;
    }

    public List<EducacionDetalle> getEducacionDetalleList() {
        return educacionDetalleList;
    }

    public void setEducacionDetalleList(List<EducacionDetalle> educacionDetalleList) {
        this.educacionDetalleList = educacionDetalleList;
    }

    public NivelAcademico getNivelAcademicoId() {
        return nivelAcademicoId;
    }

    public void setNivelAcademicoId(NivelAcademico nivelAcademicoId) {
        this.nivelAcademicoId = nivelAcademicoId;
    }

    public Postulante getPostulanteId() {
        return postulanteId;
    }

    public void setPostulanteId(Postulante postulanteId) {
        this.postulanteId = postulanteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educacionId != null ? educacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educacion)) {
            return false;
        }
        Educacion other = (Educacion) object;
        if ((this.educacionId == null && other.educacionId != null) || (this.educacionId != null && !this.educacionId.equals(other.educacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Educacion[ educacionId=" + educacionId + " ]";
    }
    
}
