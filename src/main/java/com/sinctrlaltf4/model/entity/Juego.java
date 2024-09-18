package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Clase que define la estructura y métodos de la entidad Juego.
 * @author Selene
 * @version 1.0
 */
@Entity
@Table(name = "juego")
public class Juego extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_jugador_uno")
    private Jugador jugadorUno;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_jugador_dos")
    private Jugador jugadorDos;
    @Column(name = "hora_inicio")
    private LocalDateTime horaInicio;
    @Column(name = "hora_fin")
    private LocalDateTime horaFin;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_ganador")
    private Jugador ganador;

    public Juego(){}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", jugadorUno=" + jugadorUno +
                ", jugadorDos=" + jugadorDos +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", ganador=" + ganador +
                '}';
    }

    public Jugador getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(Jugador jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    public Jugador getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(Jugador jugadorDos) {
        this.jugadorDos = jugadorDos;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
}
