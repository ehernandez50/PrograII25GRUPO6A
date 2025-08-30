/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "oferta_empleo")
@NamedQueries({
    @NamedQuery(name = "OfertaEmpleo.findAll", query = "SELECT o FROM OfertaEmpleo o"),
    @NamedQuery(name = "OfertaEmpleo.findByOfertaEmpleoId", query = "SELECT o FROM OfertaEmpleo o WHERE o.ofertaEmpleoId = :ofertaEmpleoId"),
    @NamedQuery(name = "OfertaEmpleo.findByFecha", query = "SELECT o FROM OfertaEmpleo o WHERE o.fecha = :fecha")})
public class OfertaEmpleo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oferta_empleo_id")
    private Long ofertaEmpleoId;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "ofertaEmpleoId")
    private List<FacturaDetalle> facturaDetalleList;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne
    private Cliente clienteId;
    @JoinColumn(name = "costo_id", referencedColumnName = "costo_id")
    @ManyToOne
    private Costo costoId;
    @JoinColumn(name = "vacante_id", referencedColumnName = "vacante_id")
    @ManyToOne
    private Vacante vacanteId;

    public OfertaEmpleo() {
    }

    public OfertaEmpleo(Long ofertaEmpleoId) {
        this.ofertaEmpleoId = ofertaEmpleoId;
    }

    public Long getOfertaEmpleoId() {
        return ofertaEmpleoId;
    }

    public void setOfertaEmpleoId(Long ofertaEmpleoId) {
        this.ofertaEmpleoId = ofertaEmpleoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<FacturaDetalle> getFacturaDetalleList() {
        return facturaDetalleList;
    }

    public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
        this.facturaDetalleList = facturaDetalleList;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Costo getCostoId() {
        return costoId;
    }

    public void setCostoId(Costo costoId) {
        this.costoId = costoId;
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
        hash += (ofertaEmpleoId != null ? ofertaEmpleoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaEmpleo)) {
            return false;
        }
        OfertaEmpleo other = (OfertaEmpleo) object;
        if ((this.ofertaEmpleoId == null && other.ofertaEmpleoId != null) || (this.ofertaEmpleoId != null && !this.ofertaEmpleoId.equals(other.ofertaEmpleoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.OfertaEmpleo[ ofertaEmpleoId=" + ofertaEmpleoId + " ]";
    }
    
}
