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
@Table(name = "requisito")
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r"),
    @NamedQuery(name = "Requisito.findByRequisitoId", query = "SELECT r FROM Requisito r WHERE r.requisitoId = :requisitoId"),
    @NamedQuery(name = "Requisito.findByExpertenciaAnos", query = "SELECT r FROM Requisito r WHERE r.expertenciaAnos = :expertenciaAnos"),
    @NamedQuery(name = "Requisito.findByEdad", query = "SELECT r FROM Requisito r WHERE r.edad = :edad")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requisito_id")
    private Integer requisitoId;
    @Column(name = "expertencia_anos")
    private Integer expertenciaAnos;
    @Column(name = "edad")
    private Integer edad;
    @JoinColumn(name = "nivel_academico_id", referencedColumnName = "nivel_academico_id")
    @ManyToOne
    private NivelAcademico nivelAcademicoId;
    @OneToMany(mappedBy = "requisitoId")
    private List<Vacante> vacanteList;

    public Requisito() {
    }

    public Requisito(Integer requisitoId) {
        this.requisitoId = requisitoId;
    }

    public Integer getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(Integer requisitoId) {
        this.requisitoId = requisitoId;
    }

    public Integer getExpertenciaAnos() {
        return expertenciaAnos;
    }

    public void setExpertenciaAnos(Integer expertenciaAnos) {
        this.expertenciaAnos = expertenciaAnos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public NivelAcademico getNivelAcademicoId() {
        return nivelAcademicoId;
    }

    public void setNivelAcademicoId(NivelAcademico nivelAcademicoId) {
        this.nivelAcademicoId = nivelAcademicoId;
    }

    public List<Vacante> getVacanteList() {
        return vacanteList;
    }

    public void setVacanteList(List<Vacante> vacanteList) {
        this.vacanteList = vacanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitoId != null ? requisitoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.requisitoId == null && other.requisitoId != null) || (this.requisitoId != null && !this.requisitoId.equals(other.requisitoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Requisito[ requisitoId=" + requisitoId + " ]";
    }
    
}
