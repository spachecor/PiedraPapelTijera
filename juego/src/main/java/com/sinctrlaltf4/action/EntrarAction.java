package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class EntrarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String accion;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setAccion(request.getParameter("accion"));
		return SUCCESS;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
}
