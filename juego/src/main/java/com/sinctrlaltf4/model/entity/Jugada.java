package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Clase que define la estructura y métodos de la entidad Jugada.
 * @author SinCtrlAltF4
 * @version 1.0
 */
@Entity
@Table(name = "jugada")
public class Jugada extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugada")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;
    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;
    private Integer opcion;

    public Jugada() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Jugada{" +
                "id=" + id +
                ", juego=" + juego +
                ", jugador=" + jugador +
                ", opcion='" + opcion + '\'' +
                '}';
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion = opcion;
    }
}
