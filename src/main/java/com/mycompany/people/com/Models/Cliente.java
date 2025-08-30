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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT c FROM Cliente c WHERE c.clienteId = :clienteId"),
    @NamedQuery(name = "Cliente.findByEmpresa", query = "SELECT c FROM Cliente c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Cliente.findByNombreContacto", query = "SELECT c FROM Cliente c WHERE c.nombreContacto = :nombreContacto"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cliente.findByCodPostal", query = "SELECT c FROM Cliente c WHERE c.codPostal = :codPostal"),
    @NamedQuery(name = "Cliente.findByNit", query = "SELECT c FROM Cliente c WHERE c.nit = :nit"),
    @NamedQuery(name = "Cliente.findByPuestoContacto", query = "SELECT c FROM Cliente c WHERE c.puestoContacto = :puestoContacto"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private Long clienteId;
    @Basic(optional = false)
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Column(name = "correo")
    private String correo;
    @Column(name = "cod_postal")
    private Integer codPostal;
    @Column(name = "nit")
    private Long nit;
    @Column(name = "puesto_contacto")
    private String puestoContacto;
    @Column(name = "telefono")
    private Integer telefono;
    @OneToMany(mappedBy = "clienteId")
    private List<OfertaEmpleo> ofertaEmpleoList;
    @OneToMany(mappedBy = "clienteId")
    private List<Factura> facturaList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;

    public Cliente() {
    }

    public Cliente(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente(Long clienteId, String empresa) {
        this.clienteId = clienteId;
        this.empresa = empresa;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getPuestoContacto() {
        return puestoContacto;
    }

    public void setPuestoContacto(String puestoContacto) {
        this.puestoContacto = puestoContacto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List<OfertaEmpleo> getOfertaEmpleoList() {
        return ofertaEmpleoList;
    }

    public void setOfertaEmpleoList(List<OfertaEmpleo> ofertaEmpleoList) {
        this.ofertaEmpleoList = ofertaEmpleoList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Cliente[ clienteId=" + clienteId + " ]";
    }
    
}
