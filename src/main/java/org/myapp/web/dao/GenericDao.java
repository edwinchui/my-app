package org.myapp.web.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericDao<T> {
	
	public enum Estado {
		ACTIVO("AC"),
		ANULADO("AN");
		
		private String codigo;
		
		Estado(String codigo) {
			this.codigo = codigo;
		}
		
		public String getCodigo() {
			return this.codigo;
		}
	}
	
	private Class<T> entityClass;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void create(T entity) {
		getEntityManager().persist(entity);
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void edit(T entity) {
		getEntityManager().merge(entity);
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getEntityManager().createQuery(
				"select object(o) from " + entityClass.getSimpleName()
						+ " as o").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findRange(int[] range) {
		javax.persistence.Query q = getEntityManager().createQuery(
				"select object(o) from " + entityClass.getSimpleName()
						+ " as o");
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	public int count() {
		return ((Long) getEntityManager()
				.createQuery(
						"select count(o) from " + entityClass.getSimpleName()
								+ " as o").getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	protected T simpleNamedQuery(String namedQuery,
			HashMap<String, Object> parametros) {
		Query query;
		
		query = this.getEntityManager().createNamedQuery(namedQuery);

		if (parametros != null) {
			for (Entry<String, Object> entry : parametros.entrySet())
				query.setParameter(entry.getKey(), entry.getValue());
		}

		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	protected T simpleQuery(String consulta,
			HashMap<String, Object> parametros) {
		Query query;

		query = this.getEntityManager().createQuery(consulta);

		if (parametros != null && !parametros.isEmpty()) {
			for (Entry<String, Object> entry : parametros.entrySet())
				query.setParameter(entry.getKey(), entry.getValue());
		}

		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	protected List<T> listNamedQuery(String namedQuery,
			HashMap<String, Object> parametros) {
		Query query;

		query = this.getEntityManager().createNamedQuery(namedQuery);

		if (parametros != null) {
			for (Entry<String, Object> entry : parametros.entrySet())
				query.setParameter(entry.getKey(), entry.getValue());
		}

		return (List<T>) query.getResultList();

	}

	@SuppressWarnings("unchecked")
	protected List<T> listQuery(String consulta,
			HashMap<String, Object> parametros) {
		Query query;

		query = this.getEntityManager().createQuery(consulta);

		if (parametros != null && !parametros.isEmpty()) {
			for (Entry<String, Object> entry : parametros.entrySet())
				query.setParameter(entry.getKey(), entry.getValue());
		}

		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected <U> U singleResultNamedQuery(String namedQuery,
			HashMap<String, Object> parametros, Class<U> clazz) {
		Query query;
		
		query = this.getEntityManager().createNamedQuery(namedQuery);

		if (parametros != null) {
			for (Entry<String, Object> entry : parametros.entrySet())
				query.setParameter(entry.getKey(), entry.getValue());
		}

		return (U) query.getSingleResult();
	}

	public void detachEntity(T entity) {
		this.getEntityManager().detach(entity);
	}

	public Query buildNativeQuery(String consulta,
			LinkedHashMap<String, Object> parametros) {
		Query query;

		query = this.getEntityManager().createNativeQuery(consulta);

		if (parametros != null && !parametros.isEmpty()) {
			for (Entry<String, Object> parametro : parametros.entrySet()) {
				query.setParameter(parametro.getKey(), parametro.getValue());
			}
		}

		return query;
	}

}
