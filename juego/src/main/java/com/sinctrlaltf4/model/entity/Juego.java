package com.sinctrlaltf4.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Clase que define la estructura y métodos de la entidad Juego.
 * @author SinCtrlAltF4
 * @version 1.0
 */
@Entity
@Table(name = "juego")
public class Juego extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_jugador_uno")
    private Jugador jugadorUno;
    @ManyToOne
    @JoinColumn(name = "id_jugador_dos")
    private Jugador jugadorDos;
    @Column(name = "hora")
    private LocalDateTime hora;
    @ManyToOne
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
                ", hora=" + hora +
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

    public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
}
