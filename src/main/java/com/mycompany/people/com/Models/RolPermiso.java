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
@Table(name = "rol_permiso")
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r"),
    @NamedQuery(name = "RolPermiso.findByRolPermisoId", query = "SELECT r FROM RolPermiso r WHERE r.rolPermisoId = :rolPermisoId")})
public class RolPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_permiso_id")
    private Integer rolPermisoId;
    @JoinColumn(name = "permiso_id", referencedColumnName = "permiso_id")
    @ManyToOne
    private Permiso permisoId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;

    public RolPermiso() {
    }

    public RolPermiso(Integer rolPermisoId) {
        this.rolPermisoId = rolPermisoId;
    }

    public Integer getRolPermisoId() {
        return rolPermisoId;
    }

    public void setRolPermisoId(Integer rolPermisoId) {
        this.rolPermisoId = rolPermisoId;
    }

    public Permiso getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Permiso permisoId) {
        this.permisoId = permisoId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolPermisoId != null ? rolPermisoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.rolPermisoId == null && other.rolPermisoId != null) || (this.rolPermisoId != null && !this.rolPermisoId.equals(other.rolPermisoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.RolPermiso[ rolPermisoId=" + rolPermisoId + " ]";
    }
    
}
