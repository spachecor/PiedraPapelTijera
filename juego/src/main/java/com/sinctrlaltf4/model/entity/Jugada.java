package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Clase que define la estructura y métodos de la entidad Jugada.
 * @author Selene
 * @version 1.0
 */
@Entity
@Table(name = "jugada")
public class Jugada extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugada")
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_juego")
    private Juego juego;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;
    private String opcion;
    @Column(name = "hora_jugada")
    private LocalDateTime horaJugada;

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
                ", horaJugada=" + horaJugada +
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

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public LocalDateTime getHoraJugada() {
        return horaJugada;
    }

    public void setHoraJugada(LocalDateTime horaJugada) {
        this.horaJugada = horaJugada;
    }
}
