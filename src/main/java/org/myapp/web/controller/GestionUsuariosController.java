package org.myapp.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.myapp.web.model.Persona;
import org.myapp.web.model.Usuario;
import org.myapp.web.service.CommonService;
import org.myapp.web.service.GestionUsuariosService;

@ManagedBean(name = "mbGestionUsuarios")
@RequestScoped
public class GestionUsuariosController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestionUsuariosService servGestionUsuarios;
	
	@Inject
	private CommonService servCommon;
	
	private Usuario usuarioBusqueda;
	
	private List<Usuario> listaUsuarios;
	private HashMap<String, String> tipoDocs;
	
	@PostConstruct
	public void inicio() {
		this.usuarioBusqueda = new Usuario();
		this.usuarioBusqueda.setPersona(new Persona());
		
		this.listaUsuarios = this.servGestionUsuarios.getUsuariosActivos();
		this.tipoDocs = this.servCommon.getListaTipoDocumentos();
	}

	public Usuario getUsuarioBusqueda() {
		return usuarioBusqueda;
	}

	public void setUsuarioBusqueda(Usuario usuarioBusqueda) {
		this.usuarioBusqueda = usuarioBusqueda;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public HashMap<String, String> getTipoDocs() {
		return tipoDocs;
	}

	public void setTipoDocs(HashMap<String, String> tipoDocs) {
		this.tipoDocs = tipoDocs;
	}

}
