package com.sinctrlaltf4.action.util;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.sinctrlaltf4.model.entity.*;
import com.sinctrlaltf4.model.services.repository.GenericRepositoryServiceImpl;
import com.sinctrlaltf4.model.services.repository.util.JpaUtil;
import com.sinctrlaltf4.model.services.resolucionjuego.ResolucionJuego;

public class GestionJuegoUtil {
	private static GenericRepositoryServiceImpl<Jugada> jugadaGenericRepositoryServiceImpl;
	private static GenericRepositoryServiceImpl<Juego> juegoGenericRepositoryServiceImpl;
	private static GenericRepositoryServiceImpl<Jugador> jugadorGenericRepositoryServiceImpl;
	static {
		jugadaGenericRepositoryServiceImpl = new GenericRepositoryServiceImpl<Jugada>(JpaUtil.getEntityManager(), Jugada.class);
		juegoGenericRepositoryServiceImpl = new GenericRepositoryServiceImpl<Juego>(JpaUtil.getEntityManager(), Juego.class);
		jugadorGenericRepositoryServiceImpl = new GenericRepositoryServiceImpl<Jugador>(JpaUtil.getEntityManager(), Jugador.class);
	}
	
	public static Jugada resolverJugada(HttpServletRequest request){
		String nombrePlayer1 = (String) request.getSession().getAttribute("player1");
		String nombrePlayer2 = (String) request.getSession().getAttribute("player2");
		Integer opcionPlayer1 = Integer.parseInt(request.getParameter("opcionPlayer1"));
		Integer opcionPlayer2 = Integer.parseInt(request.getParameter("opcionPlayer2"));
		Jugador player1 = null;
		Jugador player2 = null;
		Juego juego = null;
		Jugada jugadaPlayer1 = null;
		Jugada jugadaPlayer2 = null;
		if(request.getSession().getAttribute("idJuego")!=null) {
			Optional<Juego> oJuego = juegoGenericRepositoryServiceImpl.porId((Integer) request.getSession().getAttribute("idJuego"));
			if(oJuego.isPresent()) juego = oJuego.get();
			player1 = juego.getJugadorUno();
			player2 = juego.getJugadorDos();
		}else {
			//creamos los jugadores
			player1 = new Jugador();
			player1.setNombre(nombrePlayer1);
			player2 = new Jugador();
			player2.setNombre(nombrePlayer2);
			jugadorGenericRepositoryServiceImpl.guardar(player1);
			jugadorGenericRepositoryServiceImpl.guardar(player2);
			//creamos el juego
			juego = new Juego();
			juego.setJugadorUno(player1);
			juego.setJugadorDos(player2);
			juego.setHora(LocalDateTime.now());
		}
		//creamos las jugadas
		jugadaPlayer1 = new Jugada();
		jugadaPlayer1.setJuego(juego);
		jugadaPlayer1.setJugador(player1);
		jugadaPlayer1.setOpcion(opcionPlayer1);
		jugadaPlayer2 = new Jugada();
		jugadaPlayer2.setJuego(juego);
		jugadaPlayer2.setJugador(player2);
		jugadaPlayer2.setOpcion(opcionPlayer2);
		//resolvemos juego
		Jugada winner = ResolucionJuego.resolverJuego(jugadaPlayer1, jugadaPlayer2);
		if(winner!=null) {
			juego.setGanador(winner.getJugador());
			//ajustamos las vidas de los jugadores
			if(winner.getJugador().equals(player1))player2.setVidas(player2.getVidas()-1);
			else player1.setVidas(player1.getVidas()-1);
		}
		
		//persistimos las jugadas
		juegoGenericRepositoryServiceImpl.guardar(juego);
		jugadaGenericRepositoryServiceImpl.guardar(jugadaPlayer1);
		jugadaGenericRepositoryServiceImpl.guardar(jugadaPlayer2);
		request.getSession().setAttribute("idJuego", juego.getId());
		request.getSession().setAttribute("vidasplayer1", player1.getVidas());
		request.getSession().setAttribute("vidasplayer2", player2.getVidas());
		return winner;
	}
}
