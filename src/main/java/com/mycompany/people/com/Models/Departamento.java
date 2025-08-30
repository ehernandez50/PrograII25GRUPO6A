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
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDepartamentoId", query = "SELECT d FROM Departamento d WHERE d.departamentoId = :departamentoId"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departamento_id")
    private Integer departamentoId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "departamentoId")
    private List<Municipio> municipioList;

    public Departamento() {
    }

    public Departamento(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Departamento(Integer departamentoId, String nombre) {
        this.departamentoId = departamentoId;
        this.nombre = nombre;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentoId != null ? departamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.departamentoId == null && other.departamentoId != null) || (this.departamentoId != null && !this.departamentoId.equals(other.departamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Departamento[ departamentoId=" + departamentoId + " ]";
    }
    
}
