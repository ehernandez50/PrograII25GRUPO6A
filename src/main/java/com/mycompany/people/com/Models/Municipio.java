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
@Table(name = "municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByMunicipioId", query = "SELECT m FROM Municipio m WHERE m.municipioId = :municipioId"),
    @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipio_id")
    private Integer municipioId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "municipioId")
    private List<CodigoPostal> codigoPostalList;
    @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id")
    @ManyToOne
    private Departamento departamentoId;

    public Municipio() {
    }

    public Municipio(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public Municipio(Integer municipioId, String nombre) {
        this.municipioId = municipioId;
        this.nombre = nombre;
    }

    public Integer getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Integer municipioId) {
        this.municipioId = municipioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CodigoPostal> getCodigoPostalList() {
        return codigoPostalList;
    }

    public void setCodigoPostalList(List<CodigoPostal> codigoPostalList) {
        this.codigoPostalList = codigoPostalList;
    }

    public Departamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamento departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioId != null ? municipioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioId == null && other.municipioId != null) || (this.municipioId != null && !this.municipioId.equals(other.municipioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Municipio[ municipioId=" + municipioId + " ]";
    }
    
}
