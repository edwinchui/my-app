/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.myapp.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Embeddable
public class RecursoPermisoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_recurso")
    private String codRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_permiso")
    private String codPermiso;

    public RecursoPermisoPK() {
    }

    public RecursoPermisoPK(String codRecurso, String codPermiso) {
        this.codRecurso = codRecurso;
        this.codPermiso = codPermiso;
    }

    public String getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    public String getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(String codPermiso) {
        this.codPermiso = codPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRecurso != null ? codRecurso.hashCode() : 0);
        hash += (codPermiso != null ? codPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoPermisoPK)) {
            return false;
        }
        RecursoPermisoPK other = (RecursoPermisoPK) object;
        if ((this.codRecurso == null && other.codRecurso != null) || (this.codRecurso != null && !this.codRecurso.equals(other.codRecurso))) {
            return false;
        }
        if ((this.codPermiso == null && other.codPermiso != null) || (this.codPermiso != null && !this.codPermiso.equals(other.codPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.RecursoPermisoPK[ codRecurso=" + codRecurso + ", codPermiso=" + codPermiso + " ]";
    }
    
}
