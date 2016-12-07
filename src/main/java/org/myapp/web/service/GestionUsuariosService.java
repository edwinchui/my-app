package org.myapp.web.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.myapp.web.dao.UsuarioDao;
import org.myapp.web.model.Usuario;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class GestionUsuariosService {
	
	@Inject
	private UsuarioDao daoUsuario;
	
	public List<Usuario> getUsuariosActivos() {
		return this.daoUsuario.selectAllActive();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearNuevoUsuario(Usuario usuario) {
		this.daoUsuario.create(usuario);
	}
	
}
