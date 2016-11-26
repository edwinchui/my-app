package org.myapp.web.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.myapp.web.constants.CodigoParametro;
import org.myapp.web.model.Parametro;

public class ParametroDao extends GenericDao<Parametro>{

	@Inject
	private EntityManager EntityManager;
	
	public ParametroDao() {
		super(Parametro.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return this.EntityManager;
	}
	
	public List<Parametro> selectByCode(CodigoParametro codigoParametro) {
		StringBuilder query = new StringBuilder();
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		query.append(" From Parametro ");
		query.append("Where codParametro = :codigoParametro");
		
		parametros.put("codigoParametro", codigoParametro.getCodigo());
		
		return super.listQuery(query.toString(), parametros);
	}

}
