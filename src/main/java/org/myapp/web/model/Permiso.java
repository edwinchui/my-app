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
@Table(name = "permiso")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_permiso")
    private String codPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desc_permiso")
    private String descPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_permiso")
    private String valorPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiso")
    private List<RecursoPermiso> recursoPermisoList;

    public Permiso() {
    }

    public Permiso(String codPermiso) {
        this.codPermiso = codPermiso;
    }

    public Permiso(String codPermiso, String descPermiso, String valorPermiso, String estado) {
        this.codPermiso = codPermiso;
        this.descPermiso = descPermiso;
        this.valorPermiso = valorPermiso;
        this.estado = estado;
    }

    public String getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(String codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getDescPermiso() {
        return descPermiso;
    }

    public void setDescPermiso(String descPermiso) {
        this.descPermiso = descPermiso;
    }

    public String getValorPermiso() {
        return valorPermiso;
    }

    public void setValorPermiso(String valorPermiso) {
        this.valorPermiso = valorPermiso;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPermiso != null ? codPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codPermiso == null && other.codPermiso != null) || (this.codPermiso != null && !this.codPermiso.equals(other.codPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.Permiso[ codPermiso=" + codPermiso + " ]";
    }
    
}
