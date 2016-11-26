package org.myapp.web.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.myapp.web.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	@Inject
	private EntityManager EntityManager;
	
	public UsuarioDao() {
		super(Usuario.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return this.EntityManager;
	}
	
	public List<Usuario> selectAllActive() {
		StringBuilder query = new StringBuilder();
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		query.append(" From Usuario u ");
		query.append("Where u.estado = :estado");
		
		parametros.put("estado", Estado.ACTIVO.getCodigo());
		
		return super.listQuery(query.toString(), parametros);
	}

}
