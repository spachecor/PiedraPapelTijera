package com.sinctrlaltf4.model.services.resolucionjuego;

import com.sinctrlaltf4.model.entity.Jugada;

/**
 * Clase que contiene los métodos necesarios para resolver el juego
 * @author Selene
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
        switch(jugadaPrimera.getOpcion()){
            case "PIEDRA":
                switch(jugadaSegunda.getOpcion()){
                    case "PAPEL":
                        winner = jugadaSegunda;
                        break;
                    case "TIJERA":
                        winner = jugadaPrimera;
                        break;
                    default:
                        winner = null;
                        break;
                }
                break;
            case "PAPEL":
                switch(jugadaSegunda.getOpcion()){
                    case "PIEDRA":
                        winner = jugadaPrimera;
                        break;
                    case "TIJERA":
                        winner = jugadaSegunda;
                        break;
                    default:
                        winner = null;
                        break;
                }
                break;
            case "TIJERA":
                switch(jugadaSegunda.getOpcion()){
                    case "PIEDRA":
                        winner = jugadaSegunda;
                        break;
                    case "PAPEL":
                        winner = jugadaPrimera;
                        break;
                    default:
                        winner = null;
                        break;
                }
        }
        return winner;
    }
}
