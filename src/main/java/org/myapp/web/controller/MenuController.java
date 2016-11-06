package org.myapp.web.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "menuController")
@SessionScoped
public class MenuController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date fechaActual;
	
	@PostConstruct
	public void inicio() {
		this.fechaActual = new Date();
	}
	
	public void eventoMenu() {
		System.out.println("Evento Menu Procesado");
	}
	
	/*********** Getters y Setter ***********/
	

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
}
