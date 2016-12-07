package org.myapp.web.constants;

public enum Estados {
	ACTIVO("AC"),
	ANULADO("AN");
	
	private String codigo;
	
	private Estados(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
}
