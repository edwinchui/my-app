package org.myapp.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.myapp.web.constants.CodigoParametro;
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
	private Usuario usuario;
	
	private List<Usuario> listaUsuarios;
	private HashMap<String, String> tipoDocs;
	private HashMap<String, String> mapExpedidos;
	
	@PostConstruct
	public void inicio() {
		this.usuarioBusqueda = new Usuario();
		this.usuarioBusqueda.setPersona(new Persona());
		
		this.listaUsuarios = this.servGestionUsuarios.getUsuariosActivos();
		this.tipoDocs = this.servCommon.getMapParametros(CodigoParametro.TIPO_DOCUMENTO);
	}
	
	public void eventoNuevoUsuario(ActionEvent actionEvent) {
		this.usuario = new Usuario();
		this.usuario.setPersona(new Persona());
		
		if(this.mapExpedidos == null) {
			this.mapExpedidos = this.servCommon.getMapParametros(CodigoParametro.EXPEDIDO);
		}
	}
	
	public void eventoCrearUsuario(ActionEvent actionEvent) {
		this.servGestionUsuarios.crearNuevoUsuario(this.usuario);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Correcto", "El usuario se ha creado correctamente"));
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public HashMap<String, String> getMapExpedidos() {
		return mapExpedidos;
	}

	public void setMapExpedidos(HashMap<String, String> mapExpedidos) {
		this.mapExpedidos = mapExpedidos;
	}

}
