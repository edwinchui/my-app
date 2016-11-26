package org.myapp.web.service;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.myapp.web.constants.CodigoParametro;
import org.myapp.web.dao.ParametroDao;
import org.myapp.web.model.Parametro;

@Stateless
public class CommonService {

	@Inject
	private ParametroDao daoParametro;
	
	public HashMap<String, String> getListaTipoDocumentos() {
		List<Parametro> listParametros;
		HashMap<String, String> mapTipoDocs = new HashMap<String, String>();
		
		listParametros = this.daoParametro.selectByCode(CodigoParametro.TIPO_DOCUMENTO);
		
		for(Parametro parametro : listParametros) {
			mapTipoDocs.put(parametro.getValorParametro(), parametro.getDescParametro());
		}
		
		return mapTipoDocs;
	}
	
}
