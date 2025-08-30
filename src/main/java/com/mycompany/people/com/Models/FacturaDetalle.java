/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Models;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "factura_detalle")
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"),
    @NamedQuery(name = "FacturaDetalle.findByFacturaDetalleId", query = "SELECT f FROM FacturaDetalle f WHERE f.facturaDetalleId = :facturaDetalleId")})
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_detalle_id")
    private Long facturaDetalleId;
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id")
    @ManyToOne
    private Factura facturaId;
    @JoinColumn(name = "oferta_empleo_id", referencedColumnName = "oferta_empleo_id")
    @ManyToOne
    private OfertaEmpleo ofertaEmpleoId;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Long facturaDetalleId) {
        this.facturaDetalleId = facturaDetalleId;
    }

    public Long getFacturaDetalleId() {
        return facturaDetalleId;
    }

    public void setFacturaDetalleId(Long facturaDetalleId) {
        this.facturaDetalleId = facturaDetalleId;
    }

    public Factura getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Factura facturaId) {
        this.facturaId = facturaId;
    }

    public OfertaEmpleo getOfertaEmpleoId() {
        return ofertaEmpleoId;
    }

    public void setOfertaEmpleoId(OfertaEmpleo ofertaEmpleoId) {
        this.ofertaEmpleoId = ofertaEmpleoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaDetalleId != null ? facturaDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.facturaDetalleId == null && other.facturaDetalleId != null) || (this.facturaDetalleId != null && !this.facturaDetalleId.equals(other.facturaDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.FacturaDetalle[ facturaDetalleId=" + facturaDetalleId + " ]";
    }
    
}
