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
@Table(name = "administrador")
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
  
    @NamedQuery(name = "Administrador.findByCreacion", query = "SELECT a FROM Administrador a WHERE a.creacion = :creacion"),
    @NamedQuery(name = "Administrador.findByPuestoEmpleado", query = "SELECT a FROM Administrador a WHERE a.puestoEmpleado = :puestoEmpleado"),
    @NamedQuery(name = "Administrador.findByCodEmpleado", query = "SELECT a FROM Administrador a WHERE a.codEmpleado = :codEmpleado")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "administrador_id")
    private Integer administradorId;
    
    
    
    @Column(name = "creacion")
    @Temporal(TemporalType.DATE)
    private Date creacion;
    
    @Column(name = "puesto_empleado")
    private String puestoEmpleado;
    @Column(name = "cod_empleado")
    private Integer codEmpleado;
    

    
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;

    public Administrador() {
    }

    public Administrador(Integer administradorId) {
        this.administradorId = administradorId;
    }

    public Integer getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(Integer administradorId) {
        this.administradorId = administradorId;
    }

 

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Integer getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
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
        hash += (administradorId != null ? administradorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.administradorId == null && other.administradorId != null) || (this.administradorId != null && !this.administradorId.equals(other.administradorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Administrador[ administradorId=" + administradorId + " ]";
    }
    
}
