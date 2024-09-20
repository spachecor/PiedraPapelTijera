package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Clase que es el controlador de la tercera vista y que se encarga de gestionar las redirecciones según lo que retorne el método execute
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class JuegoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
}
