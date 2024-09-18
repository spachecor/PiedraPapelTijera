package com.sinctrlaltf4.model.entity;

public enum OpcionJugada {
    PIEDRA("PIEDRA"),
    PAPEL("PAPEL"),
    TIJERA("TIJERA");
    private final String opcion;
    OpcionJugada(String opcion){
        this.opcion = opcion;
    }
    public String getOpcion(){
        return this.opcion;
    }
}
