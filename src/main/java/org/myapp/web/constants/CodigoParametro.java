package org.myapp.web.constants;

public enum CodigoParametro {
	
	TIPO_DOCUMENTO("TIPDOC");
	
	private String codigo;
	
	CodigoParametro(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
