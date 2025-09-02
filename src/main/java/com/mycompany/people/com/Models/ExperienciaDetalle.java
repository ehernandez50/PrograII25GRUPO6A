/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovany
 */
@Entity
@Table(name = "experiencia_detalle")
@NamedQueries({
    @NamedQuery(name = "ExperienciaDetalle.BuscarDetalle",query="SELECT d FROM ExperienciaDetalle d WHERE d.experienciaId=:experiencia"),
    @NamedQuery(name = "ExperienciaDetalle.findAll", query = "SELECT e FROM ExperienciaDetalle e"),
    @NamedQuery(name = "ExperienciaDetalle.findByExperienciaDetalleId", query = "SELECT e FROM ExperienciaDetalle e WHERE e.experienciaDetalleId = :experienciaDetalleId"),
    @NamedQuery(name = "ExperienciaDetalle.findByEmpresa", query = "SELECT e FROM ExperienciaDetalle e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "ExperienciaDetalle.findByCargo", query = "SELECT e FROM ExperienciaDetalle e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "ExperienciaDetalle.findByFechaInicio", query = "SELECT e FROM ExperienciaDetalle e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ExperienciaDetalle.findByFechaFin", query = "SELECT e FROM ExperienciaDetalle e WHERE e.fechaFin = :fechaFin")})
public class ExperienciaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "experiencia_detalle_id")
    private Integer experienciaDetalleId;
    @Basic(optional = false)
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "cargo")
    private String cargo;
    @Lob
    @Column(name = "funcion")
    private String funcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "experiencia_id", referencedColumnName = "experiencia_id")
    @ManyToOne
    private Experiencia experienciaId;

    public ExperienciaDetalle() {
    }

    public ExperienciaDetalle(Integer experienciaDetalleId) {
        this.experienciaDetalleId = experienciaDetalleId;
    }

    public ExperienciaDetalle(Integer experienciaDetalleId, String empresa) {
        this.experienciaDetalleId = experienciaDetalleId;
        this.empresa = empresa;
    }

    public Integer getExperienciaDetalleId() {
        return experienciaDetalleId;
    }

    public void setExperienciaDetalleId(Integer experienciaDetalleId) {
        this.experienciaDetalleId = experienciaDetalleId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Experiencia getExperienciaId() {
        return experienciaId;
    }

    public void setExperienciaId(Experiencia experienciaId) {
        this.experienciaId = experienciaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experienciaDetalleId != null ? experienciaDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaDetalle)) {
            return false;
        }
        ExperienciaDetalle other = (ExperienciaDetalle) object;
        if ((this.experienciaDetalleId == null && other.experienciaDetalleId != null) || (this.experienciaDetalleId != null && !this.experienciaDetalleId.equals(other.experienciaDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.ExperienciaDetalle[ experienciaDetalleId=" + experienciaDetalleId + " ]";
    }
    
}
