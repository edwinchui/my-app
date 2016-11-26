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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login_usuario")
    private String loginUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginUsuario")
    private List<IntentoFallido> intentoFallidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioRol> usuarioRolList;
    
    @OneToMany(mappedBy = "login")
    private List<Password> passwordList;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public Usuario(String loginUsuario, String correoElectronico, String tipoUsuario, String estado) {
        this.loginUsuario = loginUsuario;
        this.correoElectronico = correoElectronico;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<IntentoFallido> getIntentoFallidoList() {
        return intentoFallidoList;
    }

    public void setIntentoFallidoList(List<IntentoFallido> intentoFallidoList) {
        this.intentoFallidoList = intentoFallidoList;
    }

    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    public List<Password> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(List<Password> passwordList) {
        this.passwordList = passwordList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona idPersona) {
        this.persona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginUsuario != null ? loginUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.loginUsuario == null && other.loginUsuario != null) || (this.loginUsuario != null && !this.loginUsuario.equals(other.loginUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.myapp.web.model.Usuario[ loginUsuario=" + loginUsuario + " ]";
    }
    
}
