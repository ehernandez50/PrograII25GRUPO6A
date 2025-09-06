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
@Table(name = "log_sesion")
@NamedQueries({
    @NamedQuery(name = "LogSesion.findAll", query = "SELECT l FROM LogSesion l"),
    @NamedQuery(name = "LogSesion.findByLogSesionId", query = "SELECT l FROM LogSesion l WHERE l.logSesionId = :logSesionId"),
    @NamedQuery(name = "LogSesion.findByEvento", query = "SELECT l FROM LogSesion l WHERE l.evento = :evento"),
    @NamedQuery(name = "LogSesion.findByTiempo", query = "SELECT l FROM LogSesion l WHERE l.tiempo = :tiempo"),
    @NamedQuery(name = "LogSesion.findByDetalle", query = "SELECT l FROM LogSesion l WHERE l.detalle = :detalle")})
public class LogSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_sesion_id")
    private Long logSesionId;
    
    
    @Column(name = "evento")
    private String evento;
    @Column(name = "tiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempo;
    @Column(name ="ip")
    private String ip;
   
    
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;

    public LogSesion() {
    }

    public LogSesion(Long logSesionId) {
        this.logSesionId = logSesionId;
    }

    public Long getLogSesionId() {
        return logSesionId;
    }

    public void setLogSesionId(Long logSesionId) {
        this.logSesionId = logSesionId;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }
     public String getip() {
        return ip;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
      public void setIp(String usuarioId) {
        this.ip = usuarioId;
    }
      

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logSesionId != null ? logSesionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogSesion)) {
            return false;
        }
        LogSesion other = (LogSesion) object;
        if ((this.logSesionId == null && other.logSesionId != null) || (this.logSesionId != null && !this.logSesionId.equals(other.logSesionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.LogSesion[ logSesionId=" + logSesionId + " ]";
    }
    
}
