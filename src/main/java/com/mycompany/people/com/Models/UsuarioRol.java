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


 @Entity
@Table(name = "usuario_rol")
@NamedQueries({
    
  @NamedQuery(
    name = "UsuarioRol.buscarRolPorUsuario",
    query = "SELECT ur.rolId.rolId FROM UsuarioRol ur WHERE ur.usuarioId.usuarioId = :usuarioId"),
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findByUsuarioRolId", query = "SELECT u FROM UsuarioRol u WHERE u.usuarioRolId = :usuarioRolId")
})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_rol_id")
    private Long usuarioRolId;

    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;

    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId; // este es el campo de relación hacia Usuario

    public UsuarioRol() {}

    public UsuarioRol(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
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
        hash += (usuarioRolId != null ? usuarioRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.usuarioRolId == null && other.usuarioRolId != null) || 
            (this.usuarioRolId != null && !this.usuarioRolId.equals(other.usuarioRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.UsuarioRol[ usuarioRolId=" + usuarioRolId + " ]";
    }
}
