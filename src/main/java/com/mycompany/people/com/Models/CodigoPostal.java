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
@Table(name = "codigo_postal")
@NamedQueries({
    @NamedQuery(name = "CodigoPostal.findAll", query = "SELECT c FROM CodigoPostal c"),
    @NamedQuery(name = "CodigoPostal.findByCodPostalId", query = "SELECT c FROM CodigoPostal c WHERE c.codPostalId = :codPostalId"),
    @NamedQuery(name = "CodigoPostal.findByCodigo", query = "SELECT c FROM CodigoPostal c WHERE c.codigo = :codigo")})
public class CodigoPostal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_postal_id")
    private Integer codPostalId;
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "municipio_id", referencedColumnName = "municipio_id")
    @ManyToOne
    private Municipio municipioId;
    @OneToMany(mappedBy = "codPostalId")
    private List<Postulante> postulanteList;
    @OneToMany(mappedBy = "codPostalId")
    private List<Vacante> vacanteList;

    public CodigoPostal() {
    }

    public CodigoPostal(Integer codPostalId) {
        this.codPostalId = codPostalId;
    }

    public Integer getCodPostalId() {
        return codPostalId;
    }

    public void setCodPostalId(Integer codPostalId) {
        this.codPostalId = codPostalId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public List<Postulante> getPostulanteList() {
        return postulanteList;
    }

    public void setPostulanteList(List<Postulante> postulanteList) {
        this.postulanteList = postulanteList;
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
        hash += (codPostalId != null ? codPostalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoPostal)) {
            return false;
        }
        CodigoPostal other = (CodigoPostal) object;
        if ((this.codPostalId == null && other.codPostalId != null) || (this.codPostalId != null && !this.codPostalId.equals(other.codPostalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.CodigoPostal[ codPostalId=" + codPostalId + " ]";
    }
    
}
