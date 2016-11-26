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
public class RolRecursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_rol")
    private String codRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_recurso")
    private String codRecurso;

    public RolRecursoPK() {
    }

    public RolRecursoPK(String codRol, String codRecurso) {
        this.codRol = codRol;
        this.codRecurso = codRecurso;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public String getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(String codRecurso) {
        this.codRecurso = codRecurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        hash += (codRecurso != null ? codRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolRecursoPK)) {
            return false;
        }
        RolRecursoPK other = (RolRecursoPK) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        if ((this.codRecurso == null && other.codRecurso != null) || (this.codRecurso != null && !this.codRecurso.equals(other.codRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.RolRecursoPK[ codRol=" + codRol + ", codRecurso=" + codRecurso + " ]";
    }
    
}
