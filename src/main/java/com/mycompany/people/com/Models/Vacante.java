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
@Table(name = "vacante")
@NamedQueries({
    @NamedQuery(name = "Vacante.findAll", query = "SELECT v FROM Vacante v"),
  
    @NamedQuery(name = "Vacante.findByVacanteId", query = "SELECT v FROM Vacante v WHERE v.vacanteId = :vacanteId"),
    @NamedQuery(name = "Vacante.findByPuesto", query = "SELECT v FROM Vacante v WHERE v.puesto = :puesto"),
    @NamedQuery(name = "Vacante.findByDescripcion", query = "SELECT v FROM Vacante v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vacante.findBySalario", query = "SELECT v FROM Vacante v WHERE v.salario = :salario")})
public class Vacante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vacante_id")
    private Long vacanteId;
    @Basic(optional = false)
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "salario")
    private Integer salario;
    @OneToMany(mappedBy = "vacanteId")
    private List<OfertaEmpleo> ofertaEmpleoList;
    @OneToMany(mappedBy = "vacanteId")
    private List<Proceso> procesoList;
    @JoinColumn(name = "cod_postal_id", referencedColumnName = "cod_postal_id")
    @ManyToOne
    private CodigoPostal codPostalId;
    @JoinColumn(name = "requisito_id", referencedColumnName = "requisito_id")
    @ManyToOne
    private Requisito requisitoId;

    public Vacante() {
    }

    public Vacante(Long vacanteId) {
        this.vacanteId = vacanteId;
    }

    public Vacante(Long vacanteId, String puesto) {
        this.vacanteId = vacanteId;
        this.puesto = puesto;
    }

    public Long getVacanteId() {
        return vacanteId;
    }

    public void setVacanteId(Long vacanteId) {
        this.vacanteId = vacanteId;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public List<OfertaEmpleo> getOfertaEmpleoList() {
        return ofertaEmpleoList;
    }

    public void setOfertaEmpleoList(List<OfertaEmpleo> ofertaEmpleoList) {
        this.ofertaEmpleoList = ofertaEmpleoList;
    }

    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    public CodigoPostal getCodPostalId() {
        return codPostalId;
    }

    public void setCodPostalId(CodigoPostal codPostalId) {
        this.codPostalId = codPostalId;
    }

    public Requisito getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(Requisito requisitoId) {
        this.requisitoId = requisitoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacanteId != null ? vacanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacante)) {
            return false;
        }
        Vacante other = (Vacante) object;
        if ((this.vacanteId == null && other.vacanteId != null) || (this.vacanteId != null && !this.vacanteId.equals(other.vacanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Vacante[ vacanteId=" + vacanteId + " ]";
    }
    
}
