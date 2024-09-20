package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * Clase que es el controlador de la primera vista y que se encarga de gestionar las redirecciones según lo que retorne el método execute
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class EntrarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String accion;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setAccion(request.getParameter("accion"));
		if(accion.equals("1vs1")) {
			request.getSession().setAttribute("opcionJuego", "1vs1");
		}else {
			request.getSession().setAttribute("opcionJuego", "1vsMachine");
		}
		return SUCCESS;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
}
