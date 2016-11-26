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
@Table(name = "valor_dominio")
@NamedQueries({
    @NamedQuery(name = "ValorDominio.findAll", query = "SELECT v FROM ValorDominio v")})
public class ValorDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValorDominioPK valorDominioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor_dato")
    private String valorDato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desc_valor_dato")
    private String descValorDato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "cod_dominio", referencedColumnName = "cod_dominio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dominio dominio;

    public ValorDominio() {
    }

    public ValorDominio(ValorDominioPK valorDominioPK) {
        this.valorDominioPK = valorDominioPK;
    }

    public ValorDominio(ValorDominioPK valorDominioPK, String valorDato, String descValorDato, String estado) {
        this.valorDominioPK = valorDominioPK;
        this.valorDato = valorDato;
        this.descValorDato = descValorDato;
        this.estado = estado;
    }

    public ValorDominio(String codDominio, String codDato) {
        this.valorDominioPK = new ValorDominioPK(codDominio, codDato);
    }

    public ValorDominioPK getValorDominioPK() {
        return valorDominioPK;
    }

    public void setValorDominioPK(ValorDominioPK valorDominioPK) {
        this.valorDominioPK = valorDominioPK;
    }

    public String getValorDato() {
        return valorDato;
    }

    public void setValorDato(String valorDato) {
        this.valorDato = valorDato;
    }

    public String getDescValorDato() {
        return descValorDato;
    }

    public void setDescValorDato(String descValorDato) {
        this.descValorDato = descValorDato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valorDominioPK != null ? valorDominioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorDominio)) {
            return false;
        }
        ValorDominio other = (ValorDominio) object;
        if ((this.valorDominioPK == null && other.valorDominioPK != null) || (this.valorDominioPK != null && !this.valorDominioPK.equals(other.valorDominioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.ValorDominio[ valorDominioPK=" + valorDominioPK + " ]";
    }
    
}
