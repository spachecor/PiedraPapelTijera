package com.sinctrlaltf4.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FinalAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String accion;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setAccion(request.getParameter("accion"));
		if(this.getAccion()!=null&&this.getAccion().equals("jugar")) {
			//mantenemos el atributo opcionJuego de la sesion para que se use de nuevo en la pantalla de pre-game y borramos el resto
			request.getSession().removeAttribute("player1");
			if(request.getSession().getAttribute("opcionJuego").equals("1vs1"))request.getSession().removeAttribute("player2");
			request.getSession().removeAttribute("ganador");
			request.getSession().removeAttribute("perdedor");
			request.getSession().removeAttribute("idJuego");
			request.getSession().removeAttribute("vidasplayer1");
			request.getSession().removeAttribute("vidasplayer2");
			return INPUT;
		}else if(this.getAccion()!=null&&this.getAccion().equals("salir")) {
			request.getSession().removeAttribute("opcionJuego");
			request.getSession().removeAttribute("player1");
			if(request.getSession().getAttribute("opcionJuego")!=null&&request.getSession().getAttribute("opcionJuego").equals("1vs1"))request.getSession().removeAttribute("player2");
			request.getSession().removeAttribute("ganador");
			request.getSession().removeAttribute("perdedor");
			request.getSession().removeAttribute("idJuego");
			request.getSession().removeAttribute("vidasplayer1");
			request.getSession().removeAttribute("vidasplayer2");	
			return SUCCESS;
		}
		return NONE;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
