package com.sinctrlaltf4.action;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.sinctrlaltf4.action.util.GestionJuegoUtil;
import com.sinctrlaltf4.action.util.LocalDateTimeAdapter;
import com.sinctrlaltf4.model.entity.*;
import com.sinctrlaltf4.model.services.repository.GenericRepositoryServiceImpl;
import com.sinctrlaltf4.model.services.repository.util.JpaUtil;

/**
 * Clase que es el controlador de la tercera vista y que se encarga de gestionar las redirecciones según lo que retorne el método execute
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class JuegoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String accion;
    private int opcionPlayer1;
    private int opcionPlayer2;
    private String nombreGanador;
    private String nombrePerdedor;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
		String accion = request.getParameter("accion");
		if(accion.equals("jugada")) {
			Jugada jugada = null;
			try {
				jugada = GestionJuegoUtil.resolverJugada(request);
			}catch(Exception e) {
				e.printStackTrace();
			}
			String jugadaGson = null;
			if(jugada==null)jugadaGson="null";
			else jugadaGson = gson.toJson(jugada);
			response.addHeader("Content-Type", "application/json");
			response.getWriter().write(jugadaGson);
			response.flushBuffer();
			return null;
		}else if(accion.equals("asignarGanador")){
			request.getSession().setAttribute("ganador", request.getAttribute("nombreGanador"));
		}
		return INPUT;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getOpcionPlayer1() {
		return opcionPlayer1;
	}

	public void setOpcionPlayer1(int opcionPlayer1) {
		this.opcionPlayer1 = opcionPlayer1;
	}

	public int getOpcionPlayer2() {
		return opcionPlayer2;
	}

	public void setOpcionPlayer2(int opcionPlayer2) {
		this.opcionPlayer2 = opcionPlayer2;
	}

	public String getNombreGanador() {
		return nombreGanador;
	}

	public void setNombreGanador(String nombreGanador) {
		this.nombreGanador = nombreGanador;
	}

	public String getNombrePerdedor() {
		return nombrePerdedor;
	}

	public void setNombrePerdedor(String nombrePerdedor) {
		this.nombrePerdedor = nombrePerdedor;
	}
	
}
