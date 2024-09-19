package com.sinctrlaltf4.model.entity;

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
