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
@Table(name = "dominio")
@NamedQueries({
    @NamedQuery(name = "Dominio.findAll", query = "SELECT d FROM Dominio d")})
public class Dominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cod_dominio")
    private String codDominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desc_dominio")
    private String descDominio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificable")
    private boolean modificable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dominio")
    private List<ValorDominio> valorDominioList;

    public Dominio() {
    }

    public Dominio(String codDominio) {
        this.codDominio = codDominio;
    }

    public Dominio(String codDominio, String descDominio, boolean modificable, String estado) {
        this.codDominio = codDominio;
        this.descDominio = descDominio;
        this.modificable = modificable;
        this.estado = estado;
    }

    public String getCodDominio() {
        return codDominio;
    }

    public void setCodDominio(String codDominio) {
        this.codDominio = codDominio;
    }

    public String getDescDominio() {
        return descDominio;
    }

    public void setDescDominio(String descDominio) {
        this.descDominio = descDominio;
    }

    public boolean getModificable() {
        return modificable;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ValorDominio> getValorDominioList() {
        return valorDominioList;
    }

    public void setValorDominioList(List<ValorDominio> valorDominioList) {
        this.valorDominioList = valorDominioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDominio != null ? codDominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dominio)) {
            return false;
        }
        Dominio other = (Dominio) object;
        if ((this.codDominio == null && other.codDominio != null) || (this.codDominio != null && !this.codDominio.equals(other.codDominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.Dominio[ codDominio=" + codDominio + " ]";
    }
    
}
