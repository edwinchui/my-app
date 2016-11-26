package org.myapp.web.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.myapp.web.dao.UsuarioDao;
import org.myapp.web.model.Usuario;

@Stateless
public class GestionUsuariosService {
	
	@Inject
	private UsuarioDao daoUsuario;
	
	public List<Usuario> getUsuariosActivos() {
		return this.daoUsuario.selectAllActive();
	}
	
}
