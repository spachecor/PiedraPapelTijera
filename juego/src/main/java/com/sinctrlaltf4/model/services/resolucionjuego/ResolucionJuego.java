package com.sinctrlaltf4.model.services.resolucionjuego;

import com.sinctrlaltf4.model.entity.Jugada;
import com.sinctrlaltf4.model.entity.OpcionJugada;

/**
 * Clase que contiene los métodos necesarios para resolver el juego
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class ResolucionJuego {
    /**
     * Método que toma ambas jugadas y resuelve cual es la ganadora
     * @param jugadaPrimera La jugada primera
     * @param jugadaSegunda La jugada segunda
     * @return La jugada ganadora. Si es null, será empate
     */
    public static Jugada resolverJuego(Jugada jugadaPrimera, Jugada jugadaSegunda){
        Jugada winner = null;
        if(jugadaPrimera.getOpcion().equals(jugadaSegunda.getOpcion())) {
        	winner=null;//empate
        }else if(jugadaPrimera.getOpcion().equals(OpcionJugada.PIEDRA.getOpcion())&&jugadaSegunda.getOpcion().equals(OpcionJugada.TIJERA.getOpcion())
        		||jugadaPrimera.getOpcion().equals(OpcionJugada.PAPEL.getOpcion())&&jugadaSegunda.getOpcion().equals(OpcionJugada.PIEDRA.getOpcion())
        		||jugadaPrimera.getOpcion().equals(OpcionJugada.TIJERA.getOpcion())&&jugadaSegunda.getOpcion().equals(OpcionJugada.PAPEL.getOpcion())) {
        	winner=jugadaPrimera;//gana jugador jugada primera
        }else {
        	winner=jugadaSegunda;//gana jugador jugada segunda
        }
        return winner;
    }
}
