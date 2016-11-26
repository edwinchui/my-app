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
@Table(name = "rol_recurso")
@NamedQueries({
    @NamedQuery(name = "RolRecurso.findAll", query = "SELECT r FROM RolRecurso r")})
public class RolRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolRecursoPK rolRecursoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "cod_recurso", referencedColumnName = "cod_recurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recurso recurso;
    @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public RolRecurso() {
    }

    public RolRecurso(RolRecursoPK rolRecursoPK) {
        this.rolRecursoPK = rolRecursoPK;
    }

    public RolRecurso(RolRecursoPK rolRecursoPK, String estado) {
        this.rolRecursoPK = rolRecursoPK;
        this.estado = estado;
    }

    public RolRecurso(String codRol, String codRecurso) {
        this.rolRecursoPK = new RolRecursoPK(codRol, codRecurso);
    }

    public RolRecursoPK getRolRecursoPK() {
        return rolRecursoPK;
    }

    public void setRolRecursoPK(RolRecursoPK rolRecursoPK) {
        this.rolRecursoPK = rolRecursoPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolRecursoPK != null ? rolRecursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolRecurso)) {
            return false;
        }
        RolRecurso other = (RolRecurso) object;
        if ((this.rolRecursoPK == null && other.rolRecursoPK != null) || (this.rolRecursoPK != null && !this.rolRecursoPK.equals(other.rolRecursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.RolRecurso[ rolRecursoPK=" + rolRecursoPK + " ]";
    }
    
}
