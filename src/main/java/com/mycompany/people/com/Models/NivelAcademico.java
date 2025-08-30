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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "nivel_academico")
@NamedQueries({
    @NamedQuery(name = "NivelAcademico.findAll", query = "SELECT n FROM NivelAcademico n"),
    @NamedQuery(name = "NivelAcademico.findByNivelAcademicoId", query = "SELECT n FROM NivelAcademico n WHERE n.nivelAcademicoId = :nivelAcademicoId"),
    @NamedQuery(name = "NivelAcademico.findByNombre", query = "SELECT n FROM NivelAcademico n WHERE n.nombre = :nombre")})
public class NivelAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nivel_academico_id")
    private Integer nivelAcademicoId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "nivelAcademicoId")
    private List<Requisito> requisitoList;
    @OneToMany(mappedBy = "nivelAcademicoId")
    private List<Educacion> educacionList;

    public NivelAcademico() {
    }

    public NivelAcademico(Integer nivelAcademicoId) {
        this.nivelAcademicoId = nivelAcademicoId;
    }

    public NivelAcademico(Integer nivelAcademicoId, String nombre) {
        this.nivelAcademicoId = nivelAcademicoId;
        this.nombre = nombre;
    }

    public Integer getNivelAcademicoId() {
        return nivelAcademicoId;
    }

    public void setNivelAcademicoId(Integer nivelAcademicoId) {
        this.nivelAcademicoId = nivelAcademicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelAcademicoId != null ? nivelAcademicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico)) {
            return false;
        }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.nivelAcademicoId == null && other.nivelAcademicoId != null) || (this.nivelAcademicoId != null && !this.nivelAcademicoId.equals(other.nivelAcademicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.NivelAcademico[ nivelAcademicoId=" + nivelAcademicoId + " ]";
    }
    
}
