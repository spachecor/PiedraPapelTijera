package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * Clase que es el controlador de la segunda vista y que se encarga de gestionar las redirecciones según lo que retorne el método execute
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class JugarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String accion;
	private String player1;
	private String player2;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setAccion(request.getParameter("accion"));
		if(accion!=null&&accion.equals("salir")) {
			return NONE;
		}else{
			this.setParametros(request);
			return SUCCESS;
		}
	}
	/**
	 * Método que toma el nombre de ambos jugadores y que los asigna a la sesión para tomarla en la siguiente ventana
	 * @param request La solicitud que contiene el nombre de ambos jugadores
	 */
	private void setParametros(HttpServletRequest request) {
		this.setPlayer1(request.getParameter("player1"));
		if(request.getParameter("player2")==null||request.getParameter("player2").isEmpty()) {
			this.setPlayer2("Machine");
		}else this.setPlayer2(request.getParameter("player2"));
		request.getSession().setAttribute("player1", this.getPlayer1());
		request.getSession().setAttribute("player2", this.getPlayer2());
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
}
