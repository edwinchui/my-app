/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.myapp.web.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "recurso")
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r")})
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_recurso")
    private String codRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desc_recurso")
    private String descRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_recurso")
    private String tipoRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recurso")
    private List<RecursoPermiso> recursoPermisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recurso")
    private List<RolRecurso> rolRecursoList;

    public Recurso() {
    }

    public Recurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    public Recurso(String codRecurso, String descRecurso, String tipoRecurso, String nivel, String estado) {
        this.codRecurso = codRecurso;
        this.descRecurso = descRecurso;
        this.tipoRecurso = tipoRecurso;
        this.nivel = nivel;
        this.estado = estado;
    }

    public String getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    public String getDescRecurso() {
        return descRecurso;
    }

    public void setDescRecurso(String descRecurso) {
        this.descRecurso = descRecurso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<RecursoPermiso> getRecursoPermisoList() {
        return recursoPermisoList;
    }

    public void setRecursoPermisoList(List<RecursoPermiso> recursoPermisoList) {
        this.recursoPermisoList = recursoPermisoList;
    }

    public List<RolRecurso> getRolRecursoList() {
        return rolRecursoList;
    }

    public void setRolRecursoList(List<RolRecurso> rolRecursoList) {
        this.rolRecursoList = rolRecursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRecurso != null ? codRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.codRecurso == null && other.codRecurso != null) || (this.codRecurso != null && !this.codRecurso.equals(other.codRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.Recurso[ codRecurso=" + codRecurso + " ]";
    }
    
}
