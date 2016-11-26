/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.myapp.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "recurso_permiso")
@NamedQueries({
    @NamedQuery(name = "RecursoPermiso.findAll", query = "SELECT r FROM RecursoPermiso r")})
public class RecursoPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecursoPermisoPK recursoPermisoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "cod_permiso", referencedColumnName = "cod_permiso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Permiso permiso;
    @JoinColumn(name = "cod_recurso", referencedColumnName = "cod_recurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recurso recurso;

    public RecursoPermiso() {
    }

    public RecursoPermiso(RecursoPermisoPK recursoPermisoPK) {
        this.recursoPermisoPK = recursoPermisoPK;
    }

    public RecursoPermiso(RecursoPermisoPK recursoPermisoPK, String estado) {
        this.recursoPermisoPK = recursoPermisoPK;
        this.estado = estado;
    }

    public RecursoPermiso(String codRecurso, String codPermiso) {
        this.recursoPermisoPK = new RecursoPermisoPK(codRecurso, codPermiso);
    }

    public RecursoPermisoPK getRecursoPermisoPK() {
        return recursoPermisoPK;
    }

    public void setRecursoPermisoPK(RecursoPermisoPK recursoPermisoPK) {
        this.recursoPermisoPK = recursoPermisoPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recursoPermisoPK != null ? recursoPermisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoPermiso)) {
            return false;
        }
        RecursoPermiso other = (RecursoPermiso) object;
        if ((this.recursoPermisoPK == null && other.recursoPermisoPK != null) || (this.recursoPermisoPK != null && !this.recursoPermisoPK.equals(other.recursoPermisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.RecursoPermiso[ recursoPermisoPK=" + recursoPermisoPK + " ]";
    }
    
}
