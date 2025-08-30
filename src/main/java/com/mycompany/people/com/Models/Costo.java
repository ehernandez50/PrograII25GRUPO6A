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
@Table(name = "costo")
@NamedQueries({
    @NamedQuery(name = "Costo.findAll", query = "SELECT c FROM Costo c"),
    @NamedQuery(name = "Costo.findByCostoId", query = "SELECT c FROM Costo c WHERE c.costoId = :costoId"),
    @NamedQuery(name = "Costo.findByDias", query = "SELECT c FROM Costo c WHERE c.dias = :dias"),
    @NamedQuery(name = "Costo.findByPrecio", query = "SELECT c FROM Costo c WHERE c.precio = :precio")})
public class Costo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "costo_id")
    private Long costoId;
    @Column(name = "dias")
    private Integer dias;
    @Column(name = "precio")
    private Integer precio;
    @OneToMany(mappedBy = "costoId")
    private List<OfertaEmpleo> ofertaEmpleoList;

    public Costo() {
    }

    public Costo(Long costoId) {
        this.costoId = costoId;
    }

    public Long getCostoId() {
        return costoId;
    }

    public void setCostoId(Long costoId) {
        this.costoId = costoId;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<OfertaEmpleo> getOfertaEmpleoList() {
        return ofertaEmpleoList;
    }

    public void setOfertaEmpleoList(List<OfertaEmpleo> ofertaEmpleoList) {
        this.ofertaEmpleoList = ofertaEmpleoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costoId != null ? costoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costo)) {
            return false;
        }
        Costo other = (Costo) object;
        if ((this.costoId == null && other.costoId != null) || (this.costoId != null && !this.costoId.equals(other.costoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Costo[ costoId=" + costoId + " ]";
    }
    
}
