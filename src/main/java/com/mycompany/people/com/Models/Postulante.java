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
@Table(name = "postulante")
@NamedQueries({
     @NamedQuery(
    name = "Postulante.BuscarPerfil",
    query = "SELECT p FROM Postulante p WHERE p.usuarioId.usuarioId = :usuarioID"
)

,
    @NamedQuery(name = "Postulante.findAll", query = "SELECT p FROM Postulante p"),
    @NamedQuery(name = "Postulante.findByPostulanteId", query = "SELECT p FROM Postulante p WHERE p.postulanteId = :postulanteId"),
    @NamedQuery(name = "Postulante.findByNombre", query = "SELECT p FROM Postulante p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Postulante.findByApellido", query = "SELECT p FROM Postulante p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Postulante.findByDpi", query = "SELECT p FROM Postulante p WHERE p.dpi = :dpi"),
    @NamedQuery(name = "Postulante.findByNit", query = "SELECT p FROM Postulante p WHERE p.nit = :nit"),
    @NamedQuery(name = "Postulante.findByTelefono", query = "SELECT p FROM Postulante p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Postulante.findByTelefonoAdicional", query = "SELECT p FROM Postulante p WHERE p.telefonoAdicional = :telefonoAdicional"),
    @NamedQuery(name = "Postulante.findByNacionalidad", query = "SELECT p FROM Postulante p WHERE p.nacionalidad = :nacionalidad")})
public class Postulante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postulante_id")
    private Long postulanteId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dpi")
    private Integer dpi;
    @Column(name = "nit")
    private Integer nit;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "telefono_adicional")
    private Integer telefonoAdicional;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @OneToMany(mappedBy = "postulanteId")
    private List<Experiencia> experienciaList;
    @JoinColumn(name = "cod_postal_id", referencedColumnName = "cod_postal_id")
    @ManyToOne
    private CodigoPostal codPostalId;
    @JoinColumn(name = "genero_id", referencedColumnName = "genero_id")
    @ManyToOne
    private Genero generoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "postulanteId")
    private List<Proceso> procesoList;
    @OneToMany(mappedBy = "postulanteId")
    private List<Educacion> educacionList;

    public Postulante() {
    }

    public Postulante(Long postulanteId) {
        this.postulanteId = postulanteId;
    }

    public Postulante(Long postulanteId, String nombre) {
        this.postulanteId = postulanteId;
        this.nombre = nombre;
    }

    public Long getPostulanteId() {
        return postulanteId;
    }

    public void setPostulanteId(Long postulanteId) {
        this.postulanteId = postulanteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefonoAdicional() {
        return telefonoAdicional;
    }

    public void setTelefonoAdicional(Integer telefonoAdicional) {
        this.telefonoAdicional = telefonoAdicional;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public CodigoPostal getCodPostalId() {
        return codPostalId;
    }

    public void setCodPostalId(CodigoPostal codPostalId) {
        this.codPostalId = codPostalId;
    }

    public Genero getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Genero generoId) {
        this.generoId = generoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postulanteId != null ? postulanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulante)) {
            return false;
        }
        Postulante other = (Postulante) object;
        if ((this.postulanteId == null && other.postulanteId != null) || (this.postulanteId != null && !this.postulanteId.equals(other.postulanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.people.com.Models.Postulante[ postulanteId=" + postulanteId + " ]";
    }
    
}
