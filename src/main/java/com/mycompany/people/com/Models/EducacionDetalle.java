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
@Table(name = "educacion_detalle")
@NamedQueries({
    @NamedQuery(name = "EducacionDetalle.findAll", query = "SELECT e FROM EducacionDetalle e"),
    @NamedQuery(name = "EducacionDetalle.findByEducacionDetalleId", query = "SELECT e FROM EducacionDetalle e WHERE e.educacionDetalleId = :educacionDetalleId"),
    @NamedQuery(name = "EducacionDetalle.findByCentroEducativo", query = "SELECT e FROM EducacionDetalle e WHERE e.centroEducativo = :centroEducativo"),
    @NamedQuery(name = "EducacionDetalle.findByFechaInicio", query = "SELECT e FROM EducacionDetalle e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EducacionDetalle.findByFechaFin", query = "SELECT e FROM EducacionDetalle e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EducacionDetalle.findByTitulo", query = "SELECT e FROM EducacionDetalle e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "EducacionDetalle.findByNivelEstudio", query = "SELECT e FROM EducacionDetalle e WHERE e.nivelEstudio = :nivelEstudio")})
public class EducacionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "educacion_detalle_id")
    private Integer educacionDetalleId;
    @Basic(optional = false)
    @Column(name = "centro_educativo")
    private String centroEducativo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    
    @Column(name = "nivel_estudio")
    private String nivelEstudio;
    @JoinColumn(name = "educacion_id", referencedColumnName = "educacion_id")
    @ManyToOne
    private Educacion educacionId;

    public EducacionDetalle() {
    }

    public EducacionDetalle(Integer educacionDetalleId) {
        this.educacionDetalleId = educacionDetalleId;
    }

    public EducacionDetalle(Integer educacionDetalleId, String centroEducativo) {
        this.educacionDetalleId = educacionDetalleId;
        this.centroEducativo = centroEducativo;
    }

    public Integer getEducacionDetalleId() {
        return educacionDetalleId;
    }

    public void setEducacionDetalleId(Integer educacionDetalleId) {
        this.educacionDetalleId = educacionDetalleId;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public Educacion getEducacionId() {
        return educacionId;
    }

    public void setEducacionId(Educacion educacionId) {
        this.educacionId = educacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educacionDetalleId != null ? educacionDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducacionDetalle)) {
            return false;
        }
        EducacionDetalle other = (EducacionDetalle) object;
        if ((this.educacionDetalleId == null && other.educacionDetalleId != null) || (this.educacionDetalleId != null && !this.educacionDetalleId.equals(other.educacionDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.EducacionDetalle[ educacionDetalleId=" + educacionDetalleId + " ]";
    }
    
}
