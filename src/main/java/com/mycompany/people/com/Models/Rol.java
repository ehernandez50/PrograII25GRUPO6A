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
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByRolId", query = "SELECT r FROM Rol r WHERE r.rolId = :rolId"),
    @NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "rolId")
    private List<RolPermiso> rolPermisoList;
    @OneToMany(mappedBy = "rolId")
    private List<UsuarioRol> usuarioRolList;

    public Rol() {
    }

    public Rol(Integer rolId) {
        this.rolId = rolId;
    }

    public Rol(Integer rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<RolPermiso> getRolPermisoList() {
        return rolPermisoList;
    }

    public void setRolPermisoList(List<RolPermiso> rolPermisoList) {
        this.rolPermisoList = rolPermisoList;
    }

    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Rol[ rolId=" + rolId + " ]";
    }
    
}
