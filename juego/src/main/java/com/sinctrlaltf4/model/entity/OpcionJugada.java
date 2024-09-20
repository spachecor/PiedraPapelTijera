package com.sinctrlaltf4.model.entity;

/**
 * Enum que define las diferentes opciones que se pueden usar en el juego
 * @author SinCtrlAltF4
 * @version 1.0
 */
public enum OpcionJugada {
    PIEDRA(0),
    PAPEL(1),
    TIJERA(2);
    private final Integer opcion;
    OpcionJugada(Integer opcion){
        this.opcion = opcion;
    }
    public Integer getOpcion(){
        return this.opcion;
    }
}
