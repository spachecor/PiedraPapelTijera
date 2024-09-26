package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

public class CreditosAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String accion;
	
	@Override
	public String execute() throws Exception {
		if(this.getAccion()!=null&&this.getAccion().equals("salir")) {
			return NONE;
		}
		return INPUT;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
}
